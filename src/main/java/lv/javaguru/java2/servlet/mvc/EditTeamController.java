package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TeamDAO;
import lv.javaguru.java2.domain.Team;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by NightStranger on 4/28/2016.
 */
@Controller
public class EditTeamController {

    @Autowired
    @Qualifier("ORM_TeamDAO")
    private TeamDAO teamDAO;

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/editTeam") // method = {RequestMethod.POST})
    public ModelAndView processRequest(HttpServletRequest req) {

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        ModelAndView mvcModel;
        try {
            long teamId = Long.parseLong(req.getParameter("teamId"));
            Team team = teamDAO.getById(teamId);
            if (team == null) {
                throw new Exception();
            }
            mvcModel = new ModelAndView("/editTeamForm", "data", team);
            mvcModel.addObject("mode", "1");
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld", "data", "Error!");
        }
        return mvcModel;
    }
}
