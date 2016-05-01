package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskDAO;
import lv.javaguru.java2.domain.Task;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 4/30/16.
 */
@Component("JDBC_TaskDAO")
public class TaskDAOImpl extends DAOImpl implements TaskDAO {

    @Override
    public void create(Task task) throws DBException {
        if (task == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into tasks values (default, ?, ?, ?, ?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);

//            preparedStatement.setTimestamp(1, new java.sql.Timestamp(task.getDueDatetime().getTime()));
//            preparedStatement.setDate(2, new java.sql.Date(task.getDoneDate().getTime()));

            preparedStatement.setString(1, "2016-05-01 00:00:00");
            preparedStatement.setString(2, "2016-05-01");
            preparedStatement.setString(3, task.getTitle());
            preparedStatement.setString(4, task.getDescription());
//
            preparedStatement.setInt(5, (int) 1);
            preparedStatement.setInt(6, (int) 1);
//            preparedStatement.setString(7, task.getTaskType());
            preparedStatement.setString(7, "");

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                task.setTaskId(rs.getInt(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute TaskDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }


    @Override
    public void delete(int id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from tasks where TaskID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute TaskDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Task getById(int id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from tasks where TaskID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Task task = null;
            if (resultSet.next()) {
                task = new Task();
                task.setTitle(resultSet.getString("Title"));
                task.setTaskId(resultSet.getInt("TaskID"));
                task.setTaskType(resultSet.getString("TaskType"));
                task.setDescription(resultSet.getString("Description"));
                task.setDueDatetime(resultSet.getTimestamp("DueDatetime"));
                task.setDoneDate(resultSet.getDate("DoneDate"));
                task.setUserId(resultSet.getInt("UserId"));
                task.setResponsibleId(resultSet.getInt("ResponsibleId"));            }
            return task;
        } catch (Throwable e) {
            System.out.println("Exception while execute TaskDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Task> getAll() throws DBException {
        List<Task> tasks =  new ArrayList<Task>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tasks");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Task task = new Task();
                task.setTitle(resultSet.getString("Title"));
                task.setTaskId(resultSet.getInt("TaskID"));
                task.setTaskType(resultSet.getString("TaskType"));
                task.setDescription(resultSet.getString("Description"));
                task.setDueDatetime(resultSet.getTimestamp("DueDatetime"));
                task.setDoneDate(resultSet.getDate("DoneDate"));
                task.setUserId(resultSet.getInt("UserId"));
                task.setResponsibleId(resultSet.getInt("ResponsibleId"));
                tasks.add(task);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list TaskDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return tasks;
    }
}