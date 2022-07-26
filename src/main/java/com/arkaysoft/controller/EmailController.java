package com.arkaysoft.controller;

import com.arkaysoft.model.Email;
import com.arkaysoft.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EmailController {

    @Autowired
    EmailService service;

    @PostMapping("/email")
    public String email(@RequestBody Email email) throws MessagingException {
        Map<String, Object> templateModel = new HashMap<>();
        templateModel.put("recipientName", email.getRecipientName());
        templateModel.put("text", email.getText());
        templateModel.put("senderName", email.getSenderName());
        service.sendMessageUsingThymeleafTemplate(email.getTo(),"Testing",templateModel);
        return "Email sent successfully";
    }


}
