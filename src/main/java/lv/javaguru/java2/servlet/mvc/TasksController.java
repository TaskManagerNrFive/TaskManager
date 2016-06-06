package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.*;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.Team;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by andrew on 4/30/16.
 */
@Controller
public class TasksController {

    @Autowired
    @Qualifier("JDBC_TaskDAO")
    private TaskDAO taskDAO;

    @Autowired
    @Qualifier("ORM_TaskDAO")
    private TaskDAO ormTaskDAO;

    @Autowired
    @Qualifier("JDBC_UserDAO")
    private UserDAO userDAO;

    @Autowired
    @Qualifier("ORM_TeamDAO")
    private TeamDAO teamDAO;

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/tasks") // , method = {RequestMethod.GET})
    @Transactional
    public ModelAndView processRequest(HttpServletRequest req) {

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        ModelAndView mvcModel;

        List<Map> list = new ArrayList();
        Map<String,List> tasksMap = new HashMap<>();
        Map<Long,String> usersMap = new HashMap<>();

        List<Task> allTasks;
        List<Cookie> newCookies = new ArrayList();

        try {

            Cookie[] cookiesArray = req.getCookies();
            Map<String, Cookie> cookies = getCookiesMap(cookiesArray);

            AllTasksFilterState filterState;
            String filterMode = req.getParameter("filterMode");
            if (filterMode != null) {
                filterState = formFilterStateFromRequest(req);
                if (filterMode.equals("1")) {
                    newCookies = formNewCookiesList(filterState, sessionUser);
                }
            } else {
                filterState = formFilterStateFromCookies(cookies, sessionUser);
            }

            allTasks = ormTaskDAO.getFilteredList(filterState.getUserId(), filterState.getTeamId(),
                                                  filterState.getStatus(), filterState.getTitle());
            tasksMap.put("tasks", allTasks);
            list.add(tasksMap);

            List<User> users = new ArrayList();
            users = userDAO.getAll();

            List<Team> teams = new ArrayList();
            teams = teamDAO.getAll();

            for(User uu:users) {
                usersMap.put(uu.getUserId(), uu.getFullName());
            }

            list.add(usersMap);

            List<List<FilterItem>> filterLists = formFilterLists(users, teams);

            mvcModel = new ModelAndView("/tasks", "data", list);
            mvcModel.addObject("filterLists", filterLists);
            mvcModel.addObject("newCookies", newCookies);
            mvcModel.addObject("filterState", filterState);

        } catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld", "data", "Error!" + e.getMessage());
        }

        return mvcModel;

    }

    public AllTasksFilterState formFilterStateFromRequest(HttpServletRequest req) {
        AllTasksFilterState filterState = new AllTasksFilterState();
        filterState.setUserId(Long.parseLong(req.getParameter("filterUserId")));
        filterState.setTeamId(Long.parseLong(req.getParameter("filterTeamId")));
        filterState.setStatus(Long.parseLong(req.getParameter("filterStatus")));
        filterState.setTitle(req.getParameter("filterTitle").trim());
        return filterState;
    }

    public AllTasksFilterState formFilterStateFromCookies(Map cookies, User sessionUser) {
        AllTasksFilterState filterState = new AllTasksFilterState();
        filterState.setUserId(formItemFromCookie(cookies, "filterUserId" + sessionUser.getUserId(),
                                                 sessionUser.getUserId()));
        filterState.setTeamId(formItemFromCookie(cookies, "filterTeamId" + sessionUser.getUserId(), 0));
        filterState.setStatus(formItemFromCookie(cookies, "filterStatus" + sessionUser.getUserId(), 1));
        filterState.setTitle(formItemFromCookieStr(cookies, "filterTitle" + sessionUser.getUserId(), ""));
        return filterState;
    }

    public long formItemFromCookie(Map<String, Cookie> cookies, String name, long defaultValue) {
        Cookie cookie = cookies.get(name);
        return cookie != null ? Long.parseLong(cookie.getValue()) : defaultValue;
    }

    public String formItemFromCookieStr(Map<String, Cookie> cookies, String name, String defaultValue) {
        Cookie cookie = cookies.get(name);
        return cookie != null ? cookie.getValue().trim() : defaultValue;
    }

    public Map<String, Cookie> getCookiesMap(Cookie[] cookiesArray) {
        Map<String, Cookie> cookiesMap = new HashMap();
        for (Cookie cookie: cookiesArray) {
            cookiesMap.put(cookie.getName(), cookie);
        }
        return cookiesMap;
    }

    public List<Cookie> formNewCookiesList(AllTasksFilterState filterState, User sessionUser) {
        List<Cookie> list = new ArrayList();
        list.add(new Cookie("filterUserId" + sessionUser.getUserId(),
                String.valueOf(filterState.getUserId())));
        list.add(new Cookie("filterTeamId" + sessionUser.getUserId(),
                String.valueOf(filterState.getTeamId())));
        list.add(new Cookie("filterStatus" + sessionUser.getUserId(),
                String.valueOf(filterState.getStatus())));
        list.add(new Cookie("filterTitle" + sessionUser.getUserId(),
                filterState.getTitle()));
        for (Cookie cookie: list) {
            cookie.setMaxAge(60 * 60 * 24 * 365);
        }
        return list;
    }

    public List<List<FilterItem>> formFilterLists(List<User> users, List<Team> teams) {
        List<List<FilterItem>> filterLists = new ArrayList();
        filterLists.add(formUserFilterList(users));
        filterLists.add(formTeamFilterList(teams));
        filterLists.add(AllTasksFilterState.formStatusFilterList());
        return filterLists;
    }

    public List<FilterItem> formUserFilterList(List<User> users) {
        List<FilterItem> currlist = new ArrayList();
        for (User user: users) {
            currlist.add(new FilterItem(user.getUserId(), user.getFullName()));
        }
        currlist.sort(Comparator.comparing(f -> f.getName()));
        currlist.add(0, new FilterItem(0L, "--- all ---"));
        return currlist;
    }

    public List<FilterItem> formTeamFilterList(List<Team> teams) {
        List<FilterItem> currlist = new ArrayList();
        for (Team team: teams) {
            currlist.add(new FilterItem(team.getTeamID(), team.getName()));
        }
        currlist.sort(Comparator.comparing(f -> f.getName()));
        currlist.add(0, new FilterItem(0L, "--- all ---"));
        return currlist;
    }

}
