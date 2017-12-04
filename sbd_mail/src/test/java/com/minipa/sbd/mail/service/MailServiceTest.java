package com.minipa.sbd.mail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * MailServiceTest:
 *
 * @author: <a href="mailto:chengjs@servyou.com.cn">chengjs</a>
            <a href="https://github.com/MiniPa">minipa_github</a>
 * @version: 1.0.0, 2017-12-04 shared by all free coders
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private IMailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendSimpleMail() throws Exception {
        mailService.sendSimpleMail("chengjs@servyou.com.cn","test simple mail","hi chengjs!");
    }

    @Test
    public void sendHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hi chengjs ! This is a html email!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("chengjs@servyou.com.cn","hi chengjs html",content);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath="D:\\tmp\\sbd_mail.log";
        mailService.sendAttachmentsMail("chengjs@servyou.com.cn", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }


    @Test
    public void sendInlineResourceMail() {
        String rscId = "img01";
        String content="<html><body>带图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "D:\\tmp\\sbd_mail.png";

        mailService.sendInlineResourceMail("chengjs@servyou.com.cn", "主题：带图片的邮件", content, imgPath, rscId);
    }


    @Test
    public void sendTempMail() {
        Context context = new Context();
        context.setVariable("id", "01");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("chengjs@servyou.com.cn","主题：模板邮件",emailContent);
    }
}
