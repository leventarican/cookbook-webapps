package com.github.leventarican.websocket;

import com.github.leventarican.entity.Developer;
import java.io.StringReader;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.Session;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

/**
 * @author levent@protonmail.com
 */
@ApplicationScoped
@ServerEndpoint("/websocket")
public class DeveloperWebsocket {

    @Inject
    private DeveloperSessionHandler sessionHandler;
    
    @OnOpen
    public void open(Session session) {
        sessionHandler.addSession(session);
    }

    @OnClose
    public void close(Session session) {
        sessionHandler.removeSession(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        try (JsonReader reader = Json.createReader(new StringReader(message))) {
            JsonObject jsonMessage = reader.readObject();

            if ("add".equals(jsonMessage.getString("action"))) {
                Developer dev = new Developer(jsonMessage.getInt("id"), jsonMessage.getString("name"));
                sessionHandler.addDeveloper(dev);
            }
            if ("remove".equals(jsonMessage.getString("action"))) {
                int id = (int) jsonMessage.getInt("id");
                sessionHandler.removeDeveloper(id);
            }
        }
    }
}
