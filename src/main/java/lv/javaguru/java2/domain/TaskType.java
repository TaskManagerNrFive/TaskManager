package lv.javaguru.java2.domain;

import javax.persistence.*;

/**
 * Created by andrew on 4/3/16.
 */

@Entity
@Table(name="task_types")
public class TaskType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TaskTypeId", nullable = false)
    protected int TaskTypeId;

    @Column(name = "name")
    protected String name;


//    transient private long taskTypeID;
//    private String name;

    transient private String description;

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
