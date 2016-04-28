package lv.javaguru.java2.domain;

import javax.persistence.*;

/**
 * Created by andrew on 4/3/16.
 */

@Entity
@Table(name = "task_types")
public class TaskType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tasktypeid", nullable = false)
    protected int TaskTypeId;

    @Column(name = "Name")
    protected String name;

    @Column(name = "Description", columnDefinition = "TEXT")
    protected String description;

//    @ManyToOne
    @Column(name = "UserId")
    protected int userId;

//    transient private long taskTypeID;
//    private String name;

//    transient private String name;
//    transient private String description;
//    transient private int user_id;

    public long getTaskTypeID() {
        return TaskTypeId;
    }

    public String getName() {
        return name;
    }

    public void setTaskTypeId(int taskTypeID) {
        this.TaskTypeId = taskTypeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
