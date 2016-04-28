package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.database.TeamDAO;
import lv.javaguru.java2.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 */
@Component
public class DeleteTeamController implements MVCController {

    @Autowired
    @Qualifier("ORM_TeamDAO")
    private TeamDAO teamDAO;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {

        MVCModel mvcModel;
        try {
            long teamID = Long.parseLong(req.getParameter("teamId"));
            teamDAO.delete(teamID);
            mvcModel = new MVCModel("/helloWorld.jsp", "Team deleted!");
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/helloWorld.jsp", "Error!");
        }
        return mvcModel;
    }

}