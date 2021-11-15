package com.example.realtimewebchatapplication;

import com.example.realtimewebchatapplication.connected.ConnectedUser;
import com.example.realtimewebchatapplication.connected.ConnectedUserList;
import com.example.realtimewebchatapplication.message.Message;
import com.example.realtimewebchatapplication.configuration.WebSocketConfig;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class MessageController {
    ConnectedUserList userList = new ConnectedUserList();

    @MessageMapping("/chat")
    @SendTo("/chat")
    public Message index(Message message){
        return message;
    }

    @MessageMapping("/chat/connected_users")
    @SendTo("/chat/connected_users")
    public ConnectedUserList connectedUsers(ConnectedUser user){
        userList.handleUser(user);
        return userList;
    }

}
