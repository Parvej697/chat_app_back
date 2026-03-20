package com.chat.chat_application.PayLoad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MessagRequest {
    private String content;
    private String sender;
    private String roomId;
    private String mediaUrl;   // 🆕 Add this
    private String mediaType;  // 🆕 Add this
}
