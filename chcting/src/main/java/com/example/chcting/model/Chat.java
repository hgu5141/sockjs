package com.example.chcting.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Chat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long messageid;

    @Column
    private String message;

    @Column
    private String senderName;

    @Column
    private String receiverName;

//    @ManyToOne
//    @JoinColumn(name = "roomid")
//    private Room room;

    public Chat(String message, String receiverName, String senderName) {
        this.message = message;
        this.senderName = senderName;
        this.receiverName = receiverName;


    }
}
