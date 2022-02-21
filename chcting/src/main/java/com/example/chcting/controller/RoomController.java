package com.example.chcting.controller;


import com.example.chcting.dto.CreateRoomDto;
import com.example.chcting.model.Room;
import com.example.chcting.security.UserDetailsImpl;
import com.example.chcting.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
public class RoomController {

    private final RoomService roomService;


    @PostMapping("/room")
    public void createRoom(@RequestBody CreateRoomDto createRoomDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        roomService.create(createRoomDto.getReceiverName(), userDetails.getUser());
    }


    @GetMapping("/rooms")
    public List<Room> room(@AuthenticationPrincipal UserDetailsImpl userDetails){
        return roomService.getRooms(userDetails.getUser());
    }
//
//    @PostMapping("/room")
//    @ResponseBody
//        public ResponseEntity<?> createRoom(@RequestBody CreateRoomDto createRoomDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
//        return chatRoomService.createRoom(createRoomDto.getReceiverName, createRoomDto.getWorkspaceId, userDetails.getUser());


}
