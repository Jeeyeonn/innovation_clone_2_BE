package com.innovation.innovation_clone_be.mail.Service;

import com.innovation.innovation_clone_be.mail.Dto.MailDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSender {

    private final JavaMailSender javaMailSender;
    private static final String FROM_ADDRESS = "osullocclone@gmail.com";

    public void sendEMail (MailDto mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(FROM_ADDRESS);
        message.setTo(mailDto.getAddress());
        message.setSubject(mailDto.getTitle());
        message.setText(mailDto.getContent());

        javaMailSender.send(message);
    }
}
