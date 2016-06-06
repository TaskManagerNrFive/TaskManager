package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TeamDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Team;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Controller
public class TeamsController {

    @Autowired
    @Qualifier("ORM_TeamDAO")
    private TeamDAO teamDAO;

    @Autowired
    @Qualifier("ORM_UserDAO")
    private UserDAO userDAO;

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/teams") // method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        ModelAndView mvcModel;
        try {
            List<Team> teams = teamDAO.getAll();
            Map <Long, List<User>> users = new HashMap();
            for (Team team: teams) {
                users.put(team.getTeamID(), userDAO.getByTeamId(team.getTeamID()));
            }
            mvcModel = new ModelAndView();
            mvcModel.setViewName("/teams");
            mvcModel.addObject("teams", teams).addObject("users", users);
            // ("/teams", "data", teams);
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld", "data", "Error! " +
            e.getMessage());
        }
        return mvcModel;
    }

}
