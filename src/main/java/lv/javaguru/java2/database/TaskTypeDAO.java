package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.TaskType;

import java.util.List;

/**
 * Created by andrew on 4/3/16.
 */
public interface TaskTypeDAO {

    List<TaskType> getAll() throws DBException;
}
