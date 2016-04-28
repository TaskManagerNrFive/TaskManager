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
public class TeamsController implements MVCController {

    @Autowired
    @Qualifier("ORM_TeamDAO")
    private TeamDAO teamDAO;

    @Override
    public MVCModel processRequest(HttpServletRequest req) {

        MVCModel mvcModel;
        try {
            List<Team> teams = teamDAO.getAll();
            mvcModel = new MVCModel("/teams.jsp", teams);
        }
        catch (Exception e) {
            mvcModel = new MVCModel("/helloWorld.jsp", "Error!");
        }
        return mvcModel;
    }

}
