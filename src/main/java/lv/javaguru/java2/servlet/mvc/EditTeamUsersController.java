package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TeamDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Team;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by NightStranger on 5/18/2016.
 */

@Controller
public class EditTeamUsersController {

    @Autowired
    @Qualifier("ORM_TeamDAO")
    private TeamDAO teamDAO;

    @Autowired
    @Qualifier("ORM_UserDAO")
    private UserDAO userDAO;

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/editTeamUsers") // method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        ModelAndView mvcModel;
        try {
            Long teamID = Long.parseLong(req.getParameter("teamId"));
            Team team = teamDAO.getById(teamID);
            List<User> teamUsers = userDAO.getByTeamId(team.getTeamID());
            List<User> allUsers = userDAO.getAll();
            mvcModel = new ModelAndView();
            mvcModel.setViewName("/editTeamUsers");
            mvcModel.addObject("team", team).addObject("teamUsers", teamUsers)
                    .addObject("allUsers", allUsers);
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld", "data", "Error!");
        }
        return mvcModel;
    }
}

