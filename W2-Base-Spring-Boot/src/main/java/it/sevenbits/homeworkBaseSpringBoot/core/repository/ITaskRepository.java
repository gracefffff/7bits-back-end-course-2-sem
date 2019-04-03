package it.sevenbits.homeworkBaseSpringBoot.core.repository;

import it.sevenbits.homeworkBaseSpringBoot.core.model.Task;
import it.sevenbits.homeworkBaseSpringBoot.web.models.UpdateTaskRequest;

import java.util.List;

public interface ITaskRepository {
    List<Task> getAllTasks();
    Task create(String text);
    boolean isEmpty();
    Task getTask(String id);
    Task deleteTask(String id);
    boolean isTaskExist(String id);
    Task updateTask(String id, UpdateTaskRequest task);


}
