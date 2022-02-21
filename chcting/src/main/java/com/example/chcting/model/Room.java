package com.example.chcting.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Room {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long roomid;

    @ManyToOne
    @JoinColumn(name = "senderName")
    private User user;

    @Column(nullable = false)
    private String receiverName;

    @OneToMany
    private List<Chat> ChatList = new ArrayList<>();

    public Room(String receiverName, User user) {
        this.user = user;
        this.receiverName = receiverName;
    }
}
