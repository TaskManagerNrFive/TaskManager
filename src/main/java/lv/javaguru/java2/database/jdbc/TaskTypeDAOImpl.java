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
