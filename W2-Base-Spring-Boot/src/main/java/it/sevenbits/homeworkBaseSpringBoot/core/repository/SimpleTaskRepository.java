package it.sevenbits.homeworkBaseSpringBoot.core.repository;

import it.sevenbits.homeworkBaseSpringBoot.core.model.Task;
import it.sevenbits.homeworkBaseSpringBoot.core.model.TaskStatus;
import it.sevenbits.homeworkBaseSpringBoot.web.models.UpdateTaskRequest;

import java.util.*;

/**
 * this is class is representation of the interface ITaskRepository
 */
public class SimpleTaskRepository implements ITaskRepository {
    private Map<String, Task> tasks;

    /**
     * this is construct of this class
     *
     * @param tasks - tasks which was stored in this repository
     */
    public SimpleTaskRepository(final Map<String, Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public List<Task> getAllTasks() {
        return Collections.unmodifiableList(new ArrayList<>(tasks.values()));
    }

    @Override
    public Task create(final String text) {
        Task newTask = new Task(UUID.randomUUID().toString(), text, TaskStatus.inbox);
        tasks.put(newTask.getId(), newTask);
        return newTask;
    }

    @Override
    public Task getTask(final String id) {
        return tasks.get(id);
    }

    @Override
    public Task deleteTask(final String id) {
        return tasks.remove(id);
    }

    @Override
    public Task updateTask(final String id, final UpdateTaskRequest updateTask) {

        Task currentTask = tasks.get(id);
        currentTask.setName(updateTask.getText() == null ? currentTask.getName() : updateTask.getText());
        currentTask.setStatus(updateTask.getStatus() == null ? currentTask.getStatus() : updateTask.getStatus());
        return currentTask;
    }

    @Override
    public boolean isTaskExist(final String id) {
        return tasks.containsKey(id);
    }

    @Override
    public boolean isEmpty() {
        return tasks.isEmpty();
    }


}