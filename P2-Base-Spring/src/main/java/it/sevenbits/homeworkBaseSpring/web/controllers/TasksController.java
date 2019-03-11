package it.sevenbits.homeworkBaseSpring.web.controllers;

import it.sevenbits.homeworkBaseSpring.core.model.Task;
import it.sevenbits.homeworkBaseSpring.core.repository.ITaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TasksController {
    private ITaskRepository taskRepository;

    public TasksController(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List> list() {
        if (taskRepository.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return  ResponseEntity.ok(taskRepository.getAllTasks());
        }
    }
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity create(@RequestBody Task newTask) {


        if (newTask != null && !newTask.getName().equals("")) {
            Task createdTask = taskRepository.create(newTask);
            URI location = UriComponentsBuilder.fromPath("/tasks/")
                    .path(String.valueOf(createdTask.getId()))
                    .build().toUri();
            return ResponseEntity.created(location).body(createdTask);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
}
