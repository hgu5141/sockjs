package com.example.chcting.repository;

import com.example.chcting.model.Room;
import com.example.chcting.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findByUser(User user);
}
