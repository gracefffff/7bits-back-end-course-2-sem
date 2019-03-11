package it.sevenbits.homeworkBaseSpring.core.repository;

import it.sevenbits.homeworkBaseSpring.core.model.Task;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class SimpleTaskRepository implements ITaskRepository {
private List<Task> tasks= new ArrayList<>();

    @Override
    public List<Task> getAllTasks() {
        return Collections.unmodifiableList(tasks);
    }

    @Override
    public Task create(Task task) {
        Task newTask = new Task(UUID.randomUUID().toString(), task.getName());
        tasks.add(newTask);
        return newTask;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }
}
