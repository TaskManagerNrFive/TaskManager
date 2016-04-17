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

    void delete(Long id) throws DBException;

    void create(TaskType taskType) throws DBException;

    List<TaskType> getAll() throws DBException;



}
