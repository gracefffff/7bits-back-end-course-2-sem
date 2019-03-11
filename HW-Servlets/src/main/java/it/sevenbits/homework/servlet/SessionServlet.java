package it.sevenbits.homework.servlet;

import it.sevenbits.homework.servlet.repository.SessionRepository;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionServlet extends HttpServlet {
    private SessionRepository sessions = SessionRepository.getInstance();
    protected void doPost( HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        if ( name != null && !name.equals("")) {

            resp.setStatus(HttpServletResponse.SC_CREATED);
            String id = sessions.addUSer(name);
            resp.addCookie(new Cookie("SessionID",id));

        } else {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().write("\"Incorrect URL or parameters\"");
        }

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/html");
        resp.setCharacterEncoding("UTF-8");
        String id = getSessionID(req, "SessionID");
        if (sessions.isSessionExist(id)) {

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().write("<html><body>Current user is " + sessions.getName(id) + "</body></html>");
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }



    private String getSessionID(HttpServletRequest req, String key) {
        Cookie[] cookies = req.getCookies();
        Cookie cookie = null;
        if (cookies != null && key != null && !key.equals("")) {
            for (Cookie c: cookies) {
                if (key.equals(c.getName())) {
                    cookie = c;
                    break;
                }
            }
            return cookie.getValue();
        } else {
            return null;
        }

    }


}
