package it.sevenbits.homeworkBaseSpring.core.repository;

import it.sevenbits.homeworkBaseSpring.core.model.Task;

import java.util.List;

public interface ITaskRepository {
    List<Task> getAllTasks();
    Task create(Task task);
    boolean isEmpty();


}
