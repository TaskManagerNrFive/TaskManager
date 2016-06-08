package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TeamDAO;
import lv.javaguru.java2.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by NightStranger on 6/7/2016.
 */

@Service
public class TeamService {

    @Autowired
    @Qualifier("ORM_TeamDAO")
    TeamDAO teamDAO;

    public void create(Team team) throws Exception {

        String errorMessage = validate(team);
        if (errorMessage != "") {
            throw new IllegalArgumentException(errorMessage);
        }

        Team teamByName = teamDAO.getByName(team.getName().trim(), 0L);
        if (teamByName != null) {
            throw new IllegalArgumentException("Team with this name exist!");
        }

        teamDAO.create(team);

    }

    public void update(Team team) throws Exception {

        String errorMessage = validate(team);
        if (errorMessage != "") {
            throw new IllegalArgumentException(errorMessage);
        }

        Team teamByName = teamDAO.getByName(team.getName().trim(), team.getTeamID());
        if (teamByName != null && teamByName.getTeamID() != team.getTeamID()) {
            throw new IllegalArgumentException("Team with this name exist!");
        }

        teamDAO.update(team);

    }

    public String validate(Team team) {
        if (team == null) {
            return "Incorrect data.";
        }
        if (team.getName() == null || team.getName().trim().length() == 0) {
            return "Incorrect name.";
        }
        return "";
    }

}
