package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TeamDAO;
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
public class DeleteTeamController {

    @Autowired
    @Qualifier("ORM_TeamDAO")
    private TeamDAO teamDAO;

    @RequestMapping(value = "/deleteTeam") // method = {RequestMethod.GET})
    @Transactional
    public ModelAndView processRequest(HttpServletRequest req) {

        ModelAndView mvcModel;
        try {
            long teamID = Long.parseLong(req.getParameter("teamId"));
            teamDAO.delete(teamID);
            mvcModel = new ModelAndView("/helloWorld", "data", "Team deleted!");
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld", "data", "Error!");
        }
        return mvcModel;
    }

}
