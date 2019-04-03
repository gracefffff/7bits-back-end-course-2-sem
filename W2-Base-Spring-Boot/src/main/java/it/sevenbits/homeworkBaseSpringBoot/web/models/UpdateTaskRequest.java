package it.sevenbits.homeworkBaseSpringBoot.web.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * this class is update task request model
 */
public class UpdateTaskRequest {
    private  String text;
    private String status;

    /**
     * it's a constructor of this class
     * @param text - text of task
     * @param status - status of task
     */
    @JsonCreator
    public UpdateTaskRequest(@JsonProperty("text") final String text, final @JsonProperty("status") String status) {
        this.text = text;
        this.status = status;
    }
    public String getText() {
        return text;
    }

    public String getStatus() {
        return status;
    }
}
