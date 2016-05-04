package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskTypeDAO;
import lv.javaguru.java2.domain.TaskType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 4/3/16.
 */
@Component("JDBC_TaskTypeDAO")
public class TaskTypeDAOImpl extends DAOImpl implements TaskTypeDAO {


    @Override
    public void update(TaskType taskType) throws DBException {
        if (taskType == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update task_types set Name = ?, Description = ?" +
                            "where TaskTypeID = ?");
            preparedStatement.setString(1, taskType.getName());
            preparedStatement.setString(2, taskType.getDescription());
            preparedStatement.setInt(3, (int) taskType.getTaskTypeID());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute TaskTypeDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public TaskType getById(int id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from task_types where TaskTypeID = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            TaskType taskType = null;
            if (resultSet.next()) {
                taskType = new TaskType();
                taskType.setTaskTypeId(resultSet.getInt("TaskTypeID"));
                taskType.setName(resultSet.getString("Name"));
                taskType.setDescription(resultSet.getString("Description"));
            }
            return taskType;
        } catch (Throwable e) {
            System.out.println("Exception while execute TaskTypeDAOImpl.getById()");
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
                    .prepareStatement("delete from task_types where TaskTypeID = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute TaskTypeDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void create(TaskType taskType) throws DBException {
        if (taskType == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into task_types values (default, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, taskType.getName());
            preparedStatement.setString(2, taskType.getDescription());
            preparedStatement.setString(3, "0");

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                taskType.setTaskTypeId(rs.getInt(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    public List<TaskType> getAll() throws DBException {
        List<TaskType> taskTypes =  new ArrayList<TaskType>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from task_types");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TaskType taskType = new TaskType();
                taskType.setName(resultSet.getString("Name"));
                taskType.setTaskTypeId(resultSet.getInt("TaskTypeId"));
                taskTypes.add(taskType);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return taskTypes;
    }
}
