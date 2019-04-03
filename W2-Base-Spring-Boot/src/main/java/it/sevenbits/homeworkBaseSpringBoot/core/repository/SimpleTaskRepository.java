package it.sevenbits.homeworkBaseSpringBoot.core.repository;

import it.sevenbits.homeworkBaseSpringBoot.core.model.Task;
import it.sevenbits.homeworkBaseSpringBoot.core.model.TaskStatus;
import it.sevenbits.homeworkBaseSpringBoot.web.models.UpdateTaskRequest;

import java.util.*;

public class SimpleTaskRepository implements ITaskRepository {
    private Map<String, Task> tasks;

    public SimpleTaskRepository(Map<String, Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public List<Task> getAllTasks() {
        return Collections.unmodifiableList(new ArrayList<>(tasks.values()));
    }

    @Override
    public Task create(String text) {
        Task newTask = new Task(UUID.randomUUID().toString(), text, TaskStatus.inbox);
        tasks.put(newTask.getId(), newTask);
        return newTask;
    }

    public Task getTask(String id) {
        return tasks.get(id);
    }
    public Task deleteTask(String id) {
        return tasks.remove(id);
    }
    public Task updateTask(String id, UpdateTaskRequest updateTask) {

        Task currentTask = tasks.get(id);
        currentTask.setName(updateTask.getText() == null ? currentTask.getName() : updateTask.getText());
        currentTask.setStatus(updateTask.getStatus() == null ? currentTask.getStatus() : updateTask.getStatus());
        return currentTask;
    }
    public boolean isTaskExist(String id) {
        return tasks.containsKey(id);
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }


}