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
public class UpdateTeamController implements MVCController {

    @Autowired
    @Qualifier("ORM_TeamDAO")
    private TeamDAO teamDAO;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        /* need to check form params here too */
        MVCModel mvcModel;
        try {
            long teamId = Long.parseLong(req.getParameter("teamId"));
            String newName = req.getParameter("name");
            String newDescription = req.getParameter("description");
            Team team = teamDAO.getById(teamId);
            team.setName(newName);
            team.setDescription(newDescription);
            teamDAO.update(team);
            mvcModel = new MVCModel("/helloWorld.jsp", "Record updated!");
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/helloWorld.jsp", "Error!");
        }
        return mvcModel;
    }
}
