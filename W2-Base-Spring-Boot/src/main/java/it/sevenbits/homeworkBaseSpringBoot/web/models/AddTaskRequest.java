package it.sevenbits.homeworkBaseSpringBoot.web.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddTaskRequest {
    private  String text;
    @JsonCreator
    public AddTaskRequest(@JsonProperty("text") final String text) {
        this.text = text;
    }
    public String getText(){
        return text;
    }
}
