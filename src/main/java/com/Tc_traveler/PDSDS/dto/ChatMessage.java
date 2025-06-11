package com.Tc_traveler.PDSDS.dto;

import lombok.Data;

@Data
public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;

    // enum, getters and setters
    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

}
