package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.TaskComment;

import java.util.List;

/**
 * Created by NightStranger on 5/24/2016.
 */
public interface TaskCommentDAO {

    void create(TaskComment taskComment) throws DBException;

    List<TaskComment> getByTaskID(long taskID) throws DBException;

}
