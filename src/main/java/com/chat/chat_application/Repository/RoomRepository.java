package com.chat.chat_application.Repository;

import com.chat.chat_application.Entity.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room,String> {
    // get room using room ID
    Room findByRoomId(String roomId);
}
