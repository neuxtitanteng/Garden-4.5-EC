package com.neux.garden.ec.runtime.service;

import com.neux.garden.ec.runtime.service.bean.MailInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    private Logger logger = LoggerFactory.getLogger(MailService.class);

    @Value("${spring.profiles.active}")
    private String profileID;

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(MailInfo mailInfo) {

        logger.debug("mailInfo : " + mailInfo.toString());

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mailInfo.toRecipientArray());
        msg.setSubject(mailInfo.getSubject());
        msg.setText(mailInfo.getBody());

        try{
            javaMailSender.send(msg);
        }catch(Exception e) {
            logger.error("SendMail fail!!",e);
            throw e;
        }


    }

}
