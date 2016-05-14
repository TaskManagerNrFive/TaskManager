package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TeamDAO;
import lv.javaguru.java2.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by NightStranger on 4/27/2016.
 */
@Component
public class ShowTeamController implements MVCController {

    @Autowired
    @Qualifier("ORM_TeamDAO")
    private TeamDAO teamDAO;

    @Override
    public ModelAndView processRequest(HttpServletRequest req) {
        ModelAndView mvcModel;
        try {
            Long teamID = Long.parseLong(req.getParameter("teamId"));
            Team team = teamDAO.getById(teamID);
            mvcModel = new ModelAndView("/showTeam.jsp", team);
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld.jsp", "Error!");
        }
        return mvcModel;
    }
}
