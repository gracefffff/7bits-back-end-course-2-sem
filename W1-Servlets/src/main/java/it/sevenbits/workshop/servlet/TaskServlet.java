package it.sevenbits.workshop.servlet;

import it.sevenbits.workshop.servlet.repostitory.TaskRepository;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TaskServlet extends HttpServlet {
    private TaskRepository tasks = TaskRepository.getInstance();
//find by ID
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String param =req.getParameter("taskID");
        if( param != null && !param.equals("")) {
            int id = Integer.parseInt(param);
            if (tasks.isTaskExist(id)) {
                resp.setContentType("application/json");
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write(String.format("{ \"id\": \"%d\", \"name\": \"%s\"}", id, tasks.getTask(id)));
            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("\"Task not found\"");
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("\"Incorrect URL or parameters\"");
        }
    }
    //delete by ID
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String param =req.getParameter("taskID");
        if( param != null && !param.equals("")) {
            int id = Integer.parseInt(param);
            if (tasks.isTaskExist(id)) {

                tasks.deleteTask(id);
                resp.setContentType("application/json");
                resp.getWriter().write(String.format("{ \"id\": \"%d\"}", id));
                resp.setStatus(HttpServletResponse.SC_OK);

            } else {
                resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
                resp.getWriter().write("\"Task not found\"");
            }
        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("\"Incorrect URL or parameters\"");
        }
    }

}
