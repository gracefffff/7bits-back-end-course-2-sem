package it.sevenbits.homeworkBaseSpringBoot.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * this class is representation of the Task
 */
public class Task {
    private final String id;
    private  String name;
    private  TaskStatus status;

    /**
     * this is constructor of this class
     * @param id - this is ID of the Task
     * @param name - this is text or name of the Task
     * @param status - this is a status of Task
     */
    @JsonCreator
    public Task(final @JsonProperty("id") String id, final @JsonProperty("text") String name, final @JsonProperty("status") TaskStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    /**
     * this is function which return id of the current task
     * @return String value id of this Task
     */
    public String getId() {
        return id;
    }

    /**
     *  this function is return name of the task
     * @return String value name of task
     */
    public String getName() {
        return name;
    }

    /**
     * this is function which allows setting the name of the task
     * @param newName - String value new name of the task
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * this is function which allows setting the status of the task
     * @param newStatus - String value new status of the task
     */
    public void setStatus(final String newStatus) {
        status = TaskStatus.valueOf(newStatus);
    }

    /**
     * this function is return status of the current task
     * @return String value status
     */
    public String getStatus() {
        return status.toString();
    }




}

