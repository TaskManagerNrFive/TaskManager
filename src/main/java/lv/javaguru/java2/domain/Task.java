package lv.javaguru.java2.domain;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by andrew on 4/30/16.
 */

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TaskID", nullable = false)
    private long taskId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "UserId")
    private long userId;

    @Column(name = "ResponsibleId")
    private long responsibleId;

    @Column(name = "TaskType", columnDefinition = "CHAR")
    private String taskType;

    @Column(name = "DoneDate")
    private Date doneDate;

    @Column(name = "DueDate")
    private Date dueDate;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="UserId", insertable = false, updatable = false)
    private User user;

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
            formatedDateTime = "No due date";
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

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getresponsibleId() {
        return responsibleId;
    }

    public void setResponsibleId(long responsibleId) {
        this.responsibleId = responsibleId;
    }

    public User getUser() {
        return user;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
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
