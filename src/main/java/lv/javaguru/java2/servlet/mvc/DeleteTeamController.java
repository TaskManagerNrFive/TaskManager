package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TeamDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@Component
public class DeleteTeamController implements MVCController {

    @Autowired
    @Qualifier("ORM_TeamDAO")
    private TeamDAO teamDAO;

    @Override
    public ModelAndView processRequest(HttpServletRequest req) {

        ModelAndView mvcModel;
        try {
            long teamID = Long.parseLong(req.getParameter("teamId"));
            teamDAO.delete(teamID);
            mvcModel = new ModelAndView("/helloWorld.jsp", "Team deleted!");
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld.jsp", "Error!");
        }
        return mvcModel;
    }

}
