package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TeamDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Team;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by NightStranger on 4/27/2016.
 */
@Controller
public class ShowTeamController {

    @Autowired
    @Qualifier("ORM_TeamDAO")
    private TeamDAO teamDAO;

    @Autowired
    @Qualifier("ORM_UserDAO")
    private UserDAO userDAO;

    @RequestMapping(value = "/showTeam") // method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest req) {
        ModelAndView mvcModel;
        try {
            Long teamID = Long.parseLong(req.getParameter("teamId"));
            Team team = teamDAO.getById(teamID);
            List<User> teamUsers = userDAO.getByTeamId(team.getTeamID());
            mvcModel = new ModelAndView();
            mvcModel.setViewName("/showTeam");
            mvcModel.addObject("team", team).addObject("teamUsers", teamUsers);
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld", "data", "Error!");
        }
        return mvcModel;
    }
}
