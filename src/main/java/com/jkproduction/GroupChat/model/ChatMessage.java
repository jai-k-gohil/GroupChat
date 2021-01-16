package com.jkproduction.GroupChat.model;

/**
 * Created by
 *
 * @author jaikishorgohil
 */

public class ChatMessage {
    private  MessageType messageType;

    private String sender;

    private String content;

    private String time;

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
