package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Task;

import java.util.List;

/**
 * Created by andrew on 4/30/16.
 */
public interface TaskDAO {

    void create(Task task) throws DBException;

    void delete(int id) throws DBException;

    Task getById(int id) throws DBException;

    List<Task> getAll() throws DBException;
}
