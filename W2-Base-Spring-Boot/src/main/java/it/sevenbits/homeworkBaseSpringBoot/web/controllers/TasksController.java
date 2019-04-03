package it.sevenbits.homeworkBaseSpringBoot.web.controllers;

import it.sevenbits.homeworkBaseSpringBoot.core.model.Task;
import it.sevenbits.homeworkBaseSpringBoot.core.model.TaskStatus;
import it.sevenbits.homeworkBaseSpringBoot.core.repository.ITaskRepository;
import it.sevenbits.homeworkBaseSpringBoot.web.models.AddTaskRequest;
import it.sevenbits.homeworkBaseSpringBoot.web.models.UpdateTaskRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity create(@RequestBody AddTaskRequest newTask) {
        Task createdTask = taskRepository.create(newTask.getText());

        if (createdTask != null && !createdTask.getName().equals("")) {

            URI location = UriComponentsBuilder.fromPath("/tasks/")
                    .path(String.valueOf(createdTask.getId()))
                    .build().toUri();
            return ResponseEntity.created(location).body(createdTask);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    } @RequestMapping(value = "/{id}",
            method = RequestMethod.GET)

    @ResponseBody
    public ResponseEntity getTask(@RequestBody @PathVariable String id) {
        Task taskToReturn = taskRepository.getTask(id);
        if (taskToReturn == null) {
           return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(taskToReturn);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteTask(@RequestBody @PathVariable String id) {
        if (taskRepository.deleteTask(id) == null) {
            return  new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);

    }
    @RequestMapping(value = "/{id}",
            method = RequestMethod.PATCH)
    @ResponseBody
    public ResponseEntity updateTask(@RequestBody UpdateTaskRequest updateTask, @PathVariable String id) {
        if (!taskRepository.isTaskExist(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if((!TaskStatus.isExists(updateTask.getStatus()))) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        taskRepository.updateTask(id,updateTask);
        return new ResponseEntity(HttpStatus.OK);

    }



}



