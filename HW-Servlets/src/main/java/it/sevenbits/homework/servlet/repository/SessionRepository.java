package it.sevenbits.homework.servlet.repository;

import java.util.HashMap;
import java.util.UUID;


public class SessionRepository {
    private static SessionRepository instance;
    private HashMap<String, String> sessions;

    private SessionRepository() {
        sessions = new HashMap<String, String>();
    }

    public static SessionRepository getInstance() {
        if (instance == null) {
            instance = new SessionRepository();
        }
        return instance;
    }
    public String addUSer (String name) {
        String id = UUID.randomUUID().toString();
        sessions.put(id, name);
        return id;

    }
    public String getName (String id) {
        return sessions.get(id);
    }
    public boolean isSessionExist(String id) {
        return sessions.containsKey(id);
    }


}
