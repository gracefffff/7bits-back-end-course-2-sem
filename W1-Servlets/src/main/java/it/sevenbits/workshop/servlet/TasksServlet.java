package it.sevenbits.workshop.servlet;

import it.sevenbits.workshop.servlet.repostitory.TaskRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TasksServlet extends HttpServlet {
    private TaskRepository tasks = TaskRepository.getInstance();
    //add new task
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        if( name != null && !name.equals("")) {
            tasks.addTask(name);
            resp.setStatus(HttpServletResponse.SC_CREATED);
            resp.getWriter().write(String.format("{ \"id\": \"%d\", \"name\": \"%s\"}", tasks.countOfTasks() - 1, tasks.getTask(tasks.countOfTasks() - 1)));
            resp.getWriter().write("\"Created task\"");
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("\"Incorrect URL or parameters\"");
        }
    }
    //write all tasks
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        if ( tasks.countOfTasks() != 0) {
            resp.getWriter().write(tasks.writeList());
            resp.setStatus(HttpServletResponse.SC_OK);
        } else {
            resp.getWriter().write("\"Tasks are empty\"");
        }
    }
}
