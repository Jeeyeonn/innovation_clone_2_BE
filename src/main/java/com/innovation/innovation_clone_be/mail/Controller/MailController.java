package com.innovation.innovation_clone_be.mail.Controller;

import com.innovation.innovation_clone_be.mail.Dto.MailDto;
import com.innovation.innovation_clone_be.mail.Service.EmailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {
    private final EmailSender emailSender;

    @PostMapping("/api/mail")
    public void sendMail(@RequestBody MailDto mailDto) {
        emailSender.sendEMail(mailDto);
    }
}
