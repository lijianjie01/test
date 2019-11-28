package com.test.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class SendMailTest {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("604764332@qq.com");
        simpleMailMessage.setTo("");
        simpleMailMessage.setSubject("标题：");
        simpleMailMessage.setText("内容");
        javaMailSender.send(simpleMailMessage);
    }
}
