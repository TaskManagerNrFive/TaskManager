package lv.javaguru.java2.domain;


import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by andrew on 4/30/16.
 */
public class Task {

    private int taskId;
    private String title;
    private String description;
    private int userId;
    private int responsibleId;
    private String taskType;
    private Date doneDate;
    private Timestamp dueDatetime;

    public Timestamp getDueDatetime() {
        return dueDatetime;
    }

    public void setDueDatetime(Timestamp dueDatetime) {
        this.dueDatetime = dueDatetime;
    }

    public Date getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(Date doneDate) {
        this.doneDate = doneDate;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getresponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(int responsibleId) {
        this.responsibleId = responsibleId;
    }



    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
