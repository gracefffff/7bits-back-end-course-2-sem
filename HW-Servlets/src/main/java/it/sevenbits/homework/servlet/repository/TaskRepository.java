package it.sevenbits.homework.servlet.repository;

import java.util.concurrent.CopyOnWriteArrayList;

public class TaskRepository {
    private static TaskRepository instance;
    private CopyOnWriteArrayList<String> tasks;

    private TaskRepository() {
        tasks = new CopyOnWriteArrayList<String>();
        tasks.add("first");
        tasks.add("second");
    }
    public static TaskRepository getInstance() {
        if (instance == null) {
            instance = new TaskRepository();
        }
        return instance;
    }
    public void addTask(String task){
        tasks.add(task);
    }
    public boolean isTaskExist(int id) {
        return tasks.size() > id && id >= 0;
    }
    public String getTask(int id){
        return tasks.get(id);
    }
    public void deleteTask(int id) {
        tasks.remove(id);
    }
    public int countOfTasks() {
        return tasks.size();
    }
    public String writeList() {
        StringBuilder list = new StringBuilder();
        list.append("[\n");

        for (int i = 0; i < tasks.size(); i++) {
            list.append("{\n");
            list.append( "\"id\": " + i+ "\n" + "\"name\": \""+ tasks.get(i)+"\"");
            list.append("\n},\n");

        }
        list.append("\n]");
        return list.toString();
    }

}
