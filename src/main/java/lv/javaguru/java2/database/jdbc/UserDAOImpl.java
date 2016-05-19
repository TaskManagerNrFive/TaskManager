package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component("JDBC_UserDAO")
public class UserDAOImpl extends DAOImpl implements UserDAO {

    @Override
    public void create(User user) throws DBException {
        if (user == null) {
            return;
        }
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into users values (default, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setInt(3, 1234);
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getLogin());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                user.setUserId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public User getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from users where UserID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setUserId(resultSet.getLong("UserID"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public User getByLogin(String login) throws DBException {
        Connection connect = null;

        try {
            connect = getConnection();
            PreparedStatement prepStat = connect.prepareStatement("select * from users where Login = ?");
            prepStat.setString(1, login);
            ResultSet rs = prepStat.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getLong("UserID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setLogin(rs.getString("Login"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("Email"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getByLogin()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connect);
        }
    }

    public List<User> getAll() throws DBException {
        List<User> users = new ArrayList<User>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong("UserID"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                users.add(user);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return users;
    }

    @Override
    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from users where UserID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(User user) throws DBException {
        if (user == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update users set FirstName = ?, LastName = ? " +
                            "where UserID = ?");
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setLong(3, user.getUserId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<User> getByTeamId(Long teamId) throws DBException {
        List<User> users = new ArrayList();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from users where TeamId = ?");
            preparedStatement.setLong(1, teamId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getLong("UserID"));
                user.setFirstName(resultSet.getString("FirstName"));
                user.setLastName(resultSet.getString("LastName"));
                users.add(user);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getByTeamId()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return users;
    }

}
