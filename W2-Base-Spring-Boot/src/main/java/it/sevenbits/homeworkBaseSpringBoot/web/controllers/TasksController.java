
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

/**
 * this is bean which services requests
 */
@Controller
@RequestMapping("/tasks")
public class TasksController {
    private ITaskRepository taskRepository;

    /**
     * this is constructor of this class
     *
     * @param taskRepository - repository of tasks
     */
    public TasksController(final ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    /**
     * function that processes the GET request and returns all the tasks
     * @param status status of task
     * @return list of task with this status
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List> list(final @RequestParam("status") String status) {
        if (taskRepository.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return ResponseEntity.ok(taskRepository.getAllTaskByStatus(status));
        }
    }

    /**
     * function that processes the POST request and create a new task
     *
     * @param newTask the object which contains new name of task
     * @return new created task
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity create(final @RequestBody AddTaskRequest newTask) {
        Task createdTask = taskRepository.create(newTask.getText());

        if (createdTask != null && !createdTask.getName().equals("")) {

            URI location = UriComponentsBuilder.fromPath("/tasks/")
                    .path(String.valueOf(createdTask.getId()))
                    .build().toUri();
            return ResponseEntity.created(location).build();
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * function that processes the GET request and returns task by its id
     *
     * @param id - id of returned task
     * @return task
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getTask(final @RequestBody @PathVariable String id) {
        Task taskToReturn = taskRepository.getTask(id);
        if (taskToReturn == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(taskToReturn);
    }

    /**
     * function that processes the DELETE request and delete task by its id
     *
     * @param id - id of the task
     * @return deleted task
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteTask(final @RequestBody @PathVariable String id) {
        if (taskRepository.deleteTask(id) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);

    }

    /**
     * function that processes the PATCH request and update task by its id
     *
     * @param updateTask - the object which contains the new name and status of the task
     * @param id         - id of the task
     * @return new updated task
     */
    @RequestMapping(value = "/{id}",
            method = RequestMethod.PATCH)
    @ResponseBody
    public ResponseEntity updateTask(final @RequestBody UpdateTaskRequest updateTask, final @PathVariable String id) {
        if (!taskRepository.isTaskExist(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        if ((!TaskStatus.isExists(updateTask.getStatus()))) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        taskRepository.updateTask(id, updateTask);
        return new ResponseEntity(HttpStatus.OK);

    }
}



