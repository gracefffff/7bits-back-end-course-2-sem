package it.sevenbits.homeworkBaseSpring.core.repository;

import it.sevenbits.homeworkBaseSpring.core.model.Task;

import java.util.*;

public class SimpleTaskRepository implements ITaskRepository {
private HashMap<String, String> tasks= new HashMap<>();

    @Override
    public List<Task> getAllTasks() {
        List<Task> phones = entry.getValue();
       // return tasks.values();
    }

    @Override
    public Task create(Task task) {
        Task newTask = new Task(UUID.randomUUID().toString(), task.getName());
        tasks.put(newTask.getId(), newTask.getName());
        return newTask;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }
   // public Task getTask(String id) {
  //      return tasks.get()
   // }
}
