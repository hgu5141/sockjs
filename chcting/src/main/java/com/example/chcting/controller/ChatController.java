package com.example.chcting.controller;

import com.example.chcting.dto.MessageDto;
import com.example.chcting.model.Chat;
import com.example.chcting.model.Message;
import com.example.chcting.repository.ChatRepository;
import com.example.chcting.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Controller
@RequiredArgsConstructor
public class ChatController {

    @Autowired
    private SimpMessageSendingOperations simpMessagingTemplate;
//    private final ChatRepository chatRepository;
    private final ChatService chatService;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public Message receivePublicMessage(@Payload Message message){
        chatService.save(message);
        return message;
    }

    @MessageMapping("/private-message")
    private Message receivePrivateMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message); //user/hgu/private
        chatService.save(message);
        return message;
        
    }
}
