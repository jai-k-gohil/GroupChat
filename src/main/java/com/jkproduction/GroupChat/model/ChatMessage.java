package com.jkproduction.GroupChat.model;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by
 *
 * @author jaikishorgohil
 */

@Builder
public class ChatMessage {
    private  MessageType messageType;

    @Getter
    private String sender;

    @Getter
    private String content;

    @Getter
    private String time;
}
