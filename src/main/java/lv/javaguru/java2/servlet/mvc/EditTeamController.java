package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TeamDAO;
import lv.javaguru.java2.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by NightStranger on 4/28/2016.
 */
@Component
public class EditTeamController implements MVCController {

    @Autowired
    @Qualifier("ORM_TeamDAO")
    private TeamDAO teamDAO;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        MVCModel mvcModel;
        try {
            long teamId = Long.parseLong(req.getParameter("teamId"));
            Team team = teamDAO.getById(teamId);
            mvcModel = new MVCModel("/editTeamForm.jsp", team);
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/helloWorld.jsp", "Error!");
        }
        return mvcModel;
    }
}
