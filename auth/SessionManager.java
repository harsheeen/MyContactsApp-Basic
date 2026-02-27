package com.seveneleven.mycontactsapp.auth;

import java.util.*;

import com.seveneleven.mycontactsapp.user.model.User;


public class SessionManager {
    private Map<Integer, User> sessions = new HashMap<>();
    private int sessionCounter = 0;

    public int createSession(User user) {
        sessionCounter++;
        sessions.put(sessionCounter, user);
        return sessionCounter; // return numeric session ID
    }

    public User getUserBySession(int sessionId) {
        return sessions.get(sessionId);
    }

    public void endSession(int sessionId) {
        sessions.remove(sessionId);
    }
}
