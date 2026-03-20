package com.chat.chat_application.Controller;

import com.chat.chat_application.Entity.Message;
import com.chat.chat_application.Entity.Room;
import com.chat.chat_application.PayLoad.MessagRequest;
import com.chat.chat_application.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Controller
@CrossOrigin("${frontend.url}")
public class ChatController {

    @Autowired
    private RoomRepository roomRepository;

    @MessageMapping("/sendMessage/{roomId}")
    @SendTo("/topic/room/{roomId}")
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessagRequest request
    ) {
          Room room =  roomRepository.findByRoomId((request.getRoomId()));
          Message message = new Message();
          message.setContent(request.getContent());
          message.setSender(request.getSender());
          message.setMediaUrl(request.getMediaUrl());     // 🆕 Added
          message.setMediaType(request.getMediaType());   // 🆕 Added
          message.setTimeStamp(LocalDateTime.now());
          if(room!=null){
              room.getMessages().add(message);
              roomRepository.save(room);
          }else{
              throw new RuntimeException("Room Not Found !");
          }
          return message;
    }


}
