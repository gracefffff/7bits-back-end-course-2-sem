package it.sevenbits.homeworkBaseSpringBoot.web.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.sevenbits.homeworkBaseSpringBoot.core.model.TaskStatus;

public class UpdateTaskRequest {
    private  String text;
    private String status;
    @JsonCreator
    public UpdateTaskRequest(@JsonProperty("text") final String text, @JsonProperty("status") String status) {
        this.text = text;
        this.status = status;
    }
    public String getText(){
        return text;
    }

    public String getStatus() {
        return status;
    }
}
