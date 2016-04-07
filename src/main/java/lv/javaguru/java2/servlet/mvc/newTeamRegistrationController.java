package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.TeamDAOImpl;
import lv.javaguru.java2.domain.Team;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */

@Component
public class newTeamRegistrationController implements MVCController {

    @Override
    public MVCModel processRequest(HttpServletRequest req) {
        /* need to check form params here too */
        MVCModel mvcModel;
        try {
            Team team = new Team();
            String newName = req.getParameter("name");
            String newDescription = req.getParameter("description");
            team.setName(newName);
            team.setDescription(newDescription);
            TeamDAOImpl teamDAO = new TeamDAOImpl();
            teamDAO.create(team);
            /* temporary */ return new MVCModel("/helloWorld.jsp", "Record created!");
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/newTeamRegistration.jsp", "Save error has occured, try later.");
        }
        return mvcModel;
    }

}
