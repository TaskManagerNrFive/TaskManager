package lv.javaguru.java2.domain;

/**
 * Created by andrew on 4/3/16.
 */
public class TaskType {

    private long taskTypeID;
    private String name;
    private String description;

    public long getTaskTypeID() {
        return taskTypeID;
    }

    public String getName() {
        return name;
    }

    public void setTaskTypeId(long taskTypeID) {
        this.taskTypeID = taskTypeID;
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
