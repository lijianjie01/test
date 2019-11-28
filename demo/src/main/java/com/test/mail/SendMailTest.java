
package com.test.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class SendMailTest {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail() {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("604764332@qq.com");
            helper.setTo("347731846@qq.com");
            helper.setSubject("标题");
            StringBuffer sb = new StringBuffer();
            sb.append("<h1>大标题-h1</h1>")
                    .append("<p style='color:#F00'>红色字</p>")
                    .append("<p style='text-align:right'>右对齐</p>");
            helper.setText(sb.toString(), true);
            FileSystemResource fileSystemResource=new FileSystemResource(new File("D:\\BugReport.txt"));
            helper.addAttachment("123", fileSystemResource); // 文件名字 文件（附件）
            javaMailSender.send(message);
        } catch (Exception e) {

        }
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom("604764332@qq.com");
//        simpleMailMessage.setTo("1426387157@qq.com");
//        simpleMailMessage.setSubject("标题：");
//        simpleMailMessage.setText("内容");
//        simpleMailMessage.
//        javaMailSender.send(simpleMailMessage);
    }
}
