package com.example.chcting.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MessageDto {
    private String message;
    private String SenderName;
    private String receiverName;
}
