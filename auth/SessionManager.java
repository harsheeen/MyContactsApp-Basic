/*PROJECT - MYCONTACTAPP
@Author Harsheen
@Version 2.0 - Session Management */

package com.seveneleven.mycontactsapp.auth;

import java.util.*;

import com.seveneleven.mycontactsapp.user.model.User;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SessionManager {
    private final Map<String, String> activeSessions = new HashMap<>();

    public String createSession(String username) {
        String sessionId = UUID.randomUUID().toString();
        activeSessions.put(sessionId, username);
        return sessionId;
    }

    public boolean validateSession(String sessionId) {
        return activeSessions.containsKey(sessionId);
    }

    public void endSession(String sessionId) {
        activeSessions.remove(sessionId);
    }
}
