package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TeamDAO;
import lv.javaguru.java2.domain.Team;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by NightStranger on 4/5/2016.
 */

@Component("JDBC_TeamDAO")
public class TeamDAOImpl extends DAOImpl implements TeamDAO {

    @Override
    public void create(Team team) throws DBException {
        if (team == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into TEAMS values (default, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, team.getName());
            preparedStatement.setString(2, team.getDescription());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                team.setTeamID(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute TeamDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public Team getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from TEAMS where TeamID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Team team = null;
            if (resultSet.next()) {
                team = new Team();
                team.setTeamID(resultSet.getLong("TeamID"));
                team.setName(resultSet.getString("Name"));
                team.setDescription(resultSet.getString("Description"));
            }
            return team;
        } catch (Throwable e) {
            /* System.out.println("Exception while execute TeamDAOImpl.getById()");
            e.printStackTrace(); */
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Team> getAll() throws DBException {
        List<Team> teams = new ArrayList<Team>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from TEAMS");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Team team = new Team();
                team.setTeamID(resultSet.getLong("TeamID"));
                team.setName(resultSet.getString("Name"));
                team.setDescription(resultSet.getString("Description"));
                teams.add(team);
            }
        } catch (Throwable e) {
            /* System.out.println("Exception while getting team list TeamDAOImpl.getList()");
            e.printStackTrace(); */
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return teams;
    }

    @Override
    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from TEAMS where TeamID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            /* System.out.println("Exception while execute TeamDAOImpl.delete()");
            e.printStackTrace(); */
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Team team) throws DBException {
        if (team == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update TEAMS set Name = ?, Description = ? " +
                            "where TeamID = ?");
            preparedStatement.setString(1, team.getName());
            preparedStatement.setString(2, team.getDescription());
            preparedStatement.setLong(3, team.getTeamID());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            /* System.out.println("Exception while execute TeamDAOImpl.update()");
            e.printStackTrace(); */
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }
    
}
