package it.sevenbits.homeworkBaseSpringBoot.web.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *this class is  add task request model
 */
public class AddTaskRequest {
    private  String text;

    /**
     * it's a constructor of this class
     * @param text - text of task
     */
    @JsonCreator
    public AddTaskRequest(@JsonProperty("text") final String text) {
        this.text = text;
    }

    /**
     * get the text of task
     * @return String value text
     */
    public String getText() {
        return text;
    }
}
