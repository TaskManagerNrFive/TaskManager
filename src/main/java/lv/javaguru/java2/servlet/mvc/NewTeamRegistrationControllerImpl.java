package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.*;
import lv.javaguru.java2.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */

@Controller
public class NewTeamRegistrationControllerImpl {

    @Autowired
    @Qualifier("ORM_TeamDAO")
    private TeamDAO teamDAO;

    @RequestMapping(value = "/newTeamRegistration") // method = {RequestMethod.POST})
    @Transactional
    public ModelAndView processRequest(HttpServletRequest req) {
        /* need to check form params here too */
        ModelAndView mvcModel;
        try {
            Team team = new Team();
            String newName = req.getParameter("name");
            String newDescription = req.getParameter("description");
            team.setName(newName);
            team.setDescription(newDescription);
            teamDAO.create(team);
            mvcModel = new ModelAndView("/helloWorld", "data", "Record created!");
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld", "data", "Error!");
        }
        return mvcModel;
    }

}
