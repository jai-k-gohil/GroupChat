package com.jkproduction.GroupChat.controller;

import com.jkproduction.GroupChat.model.ChatMessage;
import com.jkproduction.GroupChat.model.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

/**
 * Created by
 *
 * @author jaikishorgohil
 */

@Component
public class WebSocketEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEventListener.class);

    private SimpMessageSendingOperations sendingOperations;

    @EventListener
    public void handleWebSocketConnectListener(final SessionConnectedEvent event) {
        LOGGER.info("Bing bong. We have a new cheeky connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(final SessionConnectedEvent event) {
        LOGGER.info("Bing bong. We have a new cheeky connection");
        final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        final String username = (String) headerAccessor.getSessionAttributes().get("username");

        final ChatMessage chatMessage = new ChatMessage();
        chatMessage.setSender(username);
        chatMessage.setMessageType(MessageType.DISCONNECT);

        sendingOperations.convertAndSend("/topic/public", chatMessage);
    }

}
