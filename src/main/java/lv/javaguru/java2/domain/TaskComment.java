package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by NightStranger on 5/24/2016.
 */

@Entity
@Table(name = "task_comments")
public class TaskComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CommentID", nullable = false)
    private long commentID;

    @Column(name = "Text", columnDefinition = "TEXT")
    private String text;

    @Column(name = "CreateTimeStamp")
    private Date createTimeStamp;

    @Column(name = "TaskID", nullable = false)
    private long taskID;

    @Column(name = "UserID", nullable = false)
    private long userID;

    public long getCommentID() {
        return commentID;
    }

    public void setCommentID(long commentID) {
        this.commentID = commentID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(Date createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public long getTaskID() {
        return taskID;
    }

    public void setTaskID(long taskID) {
        this.taskID = taskID;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }
}
