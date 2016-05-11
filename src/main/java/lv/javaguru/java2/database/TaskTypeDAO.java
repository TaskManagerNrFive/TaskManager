package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.TaskType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by andrew on 4/3/16.
 */
public interface TaskTypeDAO {

    void update(TaskType user) throws DBException;

    TaskType getById(int id) throws DBException;

    void delete(int id) throws DBException;

    void create(TaskType taskType) throws DBException;

    List<TaskType> getAll() throws DBException;

    List<TaskType> getAllTaskTypeByUserId(int userId) throws DBException;

}
