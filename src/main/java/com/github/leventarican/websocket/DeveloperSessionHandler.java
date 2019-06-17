package com.github.leventarican.websocket;

import com.github.leventarican.entity.Developer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.Session;
import javax.json.JsonObject;

/**
 * Each client connected to the application has its own session.
 * 
 * @author levent@protonmail.com
 */
@ApplicationScoped
public class DeveloperSessionHandler {
    private final Set<Session> sessions = new HashSet<>();
    private final Set<Developer> developers = new HashSet<>();
    
    public void addSession(Session session) {
        sessions.add(session);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }
    
    public List<Developer> getDevelopers() {
        return new ArrayList<>(developers);
    }

    public void addDeveloper(Developer developer) {
        developers.add(developer);
    }

    public void removeDeveloper(int id) {
        Optional<Developer> removeThis = developers.stream().filter( dev -> dev.getId() == id).findFirst();
        developers.remove(removeThis.orElse(null));
    }

    private JsonObject createAddMessage(Developer device) {
        return null;
    }
    
    private Developer getDeviceById(int id) {
        return null;
    }
    
    private void sendToAllConnectedSessions(JsonObject message) {
    }

    private void sendToSession(Session session, JsonObject message) {
    }
}
