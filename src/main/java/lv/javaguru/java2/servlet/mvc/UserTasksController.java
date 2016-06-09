package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Task;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by andrew on 5/14/16.
 */
@Controller
@Transactional

public class UserTasksController {

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
    AccountManager accountManager;

    @RequestMapping(value = "/userTasks") // , method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        List<Object> list = new ArrayList<>();
        List<Task> allTasks = new ArrayList<Task>();

        ModelAndView mvcModel;

        try {
            // int userId = Integer.parseInt(req.getParameter("userId"));
            // Long longUserId = Long.parseLong(req.getParameter("userId"));

            String filterMode = req.getParameter("filterMode");
            AllTasksFilterState filterState;
            if (filterMode.equals("2")) {
                filterState = formFilterStateFromSession(sessionUser);
            } else {
                filterState = formFilterStateFromRequest(req);
            }

            allTasks = ormTaskDAO.getFilteredList(filterState.getUserId(), filterState.getTeamId(),
                                                  filterState.getStatus(), filterState.getTitle());
            list.add(allTasks);

            User user = userDAO.getById(filterState.getUserId());

            list.add(user);

            List<List<FilterItem>> filterLists = formFilterLists();

            mvcModel = new ModelAndView("/userTasks", "data", list);
            mvcModel.addObject("filterLists", filterLists);
            mvcModel.addObject("filterState", filterState);

        } catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld", "data", "Error!" + e.getMessage());
        }

        return mvcModel;
    }

    public AllTasksFilterState formFilterStateFromRequest(HttpServletRequest req) {
        AllTasksFilterState filterState = new AllTasksFilterState();
        filterState.setUserId(Long.parseLong(req.getParameter("filterUserId")));
        filterState.setTeamId(0L);
        filterState.setStatus(Long.parseLong(req.getParameter("filterStatus")));
        filterState.setTitle(req.getParameter("filterTitle").trim());
        return filterState;
    }

    public AllTasksFilterState formFilterStateFromSession(User sessionUser) {
        AllTasksFilterState filterState = new AllTasksFilterState();
        filterState.setUserId(sessionUser.getUserId());
        filterState.setTeamId(0L);
        filterState.setStatus(1L);
        filterState.setTitle("");
        return filterState;
    }

    public List<List<FilterItem>> formFilterLists() {
        List<List<FilterItem>> filterLists = new ArrayList();
        filterLists.add(AllTasksFilterState.formStatusFilterList());
        return filterLists;
    }

}