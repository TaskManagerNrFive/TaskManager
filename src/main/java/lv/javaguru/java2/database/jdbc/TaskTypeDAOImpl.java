package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.TaskTypeDAO;
import lv.javaguru.java2.domain.TaskType;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrew on 4/3/16.
 */
@Component
public class TaskTypeDAOImpl extends DAOImpl implements TaskTypeDAO {

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
            preparedStatement.setString(2, "");
            preparedStatement.setString(3, "0");

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                taskType.setTaskTypeId(rs.getLong(1));
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
