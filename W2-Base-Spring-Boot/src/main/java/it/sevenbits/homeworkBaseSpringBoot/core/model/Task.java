package it.sevenbits.homeworkBaseSpringBoot.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Task {
    private final String id;
    private  String name;
    private  TaskStatus status;


    @JsonCreator
    public Task(@JsonProperty("id") String id, @JsonProperty("text") String name, @JsonProperty("status") TaskStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public void setStatus( final String newStatus) {
        status = TaskStatus.valueOf(newStatus);
    }

    public String getStatus() {
        return status.toString();
    }




}

