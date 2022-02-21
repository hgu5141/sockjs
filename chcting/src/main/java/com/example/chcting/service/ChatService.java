package com.example.chcting.service;

import com.example.chcting.model.Chat;
import com.example.chcting.model.Message;
import com.example.chcting.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;


    public void save(Message message) {

        String data = message.getMessage();
        String receivetName = message.getReceiverName();
        String senderName = message.getSenderName();



        Chat chat = new Chat(data,receivetName, senderName);
        chatRepository.save(chat);
    }
}
