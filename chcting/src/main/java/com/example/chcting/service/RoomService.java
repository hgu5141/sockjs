package com.example.chcting.service;


import com.example.chcting.dto.CreateRoomDto;
import com.example.chcting.model.Chat;
import com.example.chcting.model.Room;
import com.example.chcting.model.User;
import com.example.chcting.repository.RoomRepository;
import com.example.chcting.repository.UserRepository;
import com.example.chcting.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;


    //룸 생성
    public void create(String name , User user ) {
        String  receiverName = name;
        Room Room = new Room(receiverName, user);
        roomRepository.save(Room);
    }

    public List<Room> getRooms(User user) {
        List<Room> rooms = roomRepository.findByUser(user);
        return rooms;

    }
}
