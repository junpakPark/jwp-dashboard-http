package org.apache.coyote.http11.session;

import java.util.HashMap;
import java.util.Map;
import org.apache.catalina.Manager;

public class SessionManager implements Manager {

    private static final Map<String, HttpSession> SESSIONS = new HashMap<>();

    @Override
    public void add(HttpSession httpSession) {
        SESSIONS.put(httpSession.getId(), httpSession);
    }

    @Override
    public HttpSession findSession(String id) {
        return SESSIONS.get(id);
    }

    @Override
    public void remove(HttpSession httpSession) {
        SESSIONS.remove(httpSession.getId());
    }

}
