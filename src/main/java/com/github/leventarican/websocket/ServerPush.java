package com.github.leventarican.websocket;

import javax.jms.Session;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

/**
 * @author levent@protonmail.com
 */
@ApplicationScoped
@ServerEndpoint("/websocket")
public class ServerPush {

    @OnOpen
    public void open(Session session) {
    }

    @OnClose
    public void close(Session session) {
    }

    @OnMessage
    public void onMessage(String message, Session session) {
    }
}
