package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Task;

import java.util.List;

/**
 * Created by andrew on 4/30/16.
 */
public interface TaskDAO {

    void update(Task user) throws DBException;

    void create(Task task) throws DBException;

    void delete(long id) throws DBException;

    Task getById(long id) throws DBException;

    List<Task> getAll() throws DBException;

    List<Task> getAllTasksByUserId(long userId) throws DBException;

    List<Task> getFilteredList(long userId, long teamId,
                               long status, String title) throws DBException;

}
