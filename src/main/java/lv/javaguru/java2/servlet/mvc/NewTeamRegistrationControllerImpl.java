package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.*;
import lv.javaguru.java2.domain.Team;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.AccountManager;
import lv.javaguru.java2.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */

@Controller
public class NewTeamRegistrationControllerImpl {

    /*
    @Autowired
    @Qualifier("ORM_TeamDAO")
    private TeamDAO teamDAO;
    */

    @Autowired
    private TeamService teamService;

    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "/newTeamRegistration", method = {RequestMethod.POST})
    @Transactional
    public ModelAndView processRequest(HttpServletRequest req) {

        User sessionUser = accountManager.getUserFromSession(req.getSession());
        if (sessionUser == null) {
            return new ModelAndView("/redirect", "data", "");
        }

        ModelAndView mvcModel;
        try {
            Team team = new Team();
            String newName = req.getParameter("name");
            String newDescription = req.getParameter("description");
            team.setName(newName);
            team.setDescription(newDescription);
            teamService.create(team);
            mvcModel = new ModelAndView("/helloWorld", "data", "Record created!");
        }
        catch (IllegalArgumentException e) {
            mvcModel = new ModelAndView("/newTeamRegistration", "errorMessage",
                                        e.getMessage());
            mvcModel.addObject("mode", "2");
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld", "data", "Error!");
        }
        return mvcModel;
    }

}
