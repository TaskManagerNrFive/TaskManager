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
    public ModelAndView processRequest(HttpServletRequest req) {

        ModelAndView mvcModel;
        try {
            List<Team> teams = teamDAO.getAll();
            mvcModel = new ModelAndView("/teams.jsp", teams);
        }
        catch (Exception e) {
            mvcModel = new ModelAndView("/helloWorld.jsp", "Error!");
        }
        return mvcModel;
    }

}
