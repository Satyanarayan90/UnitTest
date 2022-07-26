package com.arkaysoft.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Email {

    private String to;
    private String recipientName;
    private String subject;
    private String text;
    private String senderName;


}
