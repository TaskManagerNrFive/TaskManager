package lv.javaguru.java2.domain;


import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
    private Date dueDate;

    public int getDoneStatus() {
        int status = 0;
        if(doneDate != null) {
            status = 1;
        }
        return status;
    }

    public String getDoneDateFormated() {
        String formatedDate;
        if(doneDate != null) {
            formatedDate = new SimpleDateFormat("dd.MM.yyyy").format(doneDate);
        } else {
            formatedDate = "Not done";
        }
        return formatedDate;
    }

    public String getDueDateFormated() {
        String formatedDateTime;
        if(dueDate != null) {
            formatedDateTime = new SimpleDateFormat("dd.MM.yyyy").format(dueDate);
        } else {
            formatedDateTime = "Not done";
        }
        return formatedDateTime;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
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
