package com.fzt.boot.service.impl;

import com.fzt.boot.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {

    @Autowired
    private MailService mailService;

    @Value("${spring.mail.to}")
    private String toAddress;

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail(toAddress, "simple mail",
                "hello this is simple mail");
    }

    @Test
    public void sendHtmlMail() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("time", System.currentTimeMillis());
        model.put("message", "tao   测试邮件");
        String content = "<html><h1>h1字号</h1></html>";

        mailService.sendHtmlMail(toAddress, "主题：html邮件", content);
    }

    @Test
    public void sendAttachmentsMail() {
        mailService.sendAttachmentsMail(toAddress, "主题：带附件的邮件",
                "有附件，请查收！", "/Users/wf/Desktop/WechatIMG100.jpeg");
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "tao";
        mailService.sendInlineResourceMail(toAddress,
                "主题：嵌入静态资源的邮件",
                "<html><body>这是有嵌入静态资源：<img src=\'cid:"
                        + rscId + "\' ></body></html>",
                "/Users/wf/Desktop/WechatIMG100.jpeg",
                rscId);
    }
}