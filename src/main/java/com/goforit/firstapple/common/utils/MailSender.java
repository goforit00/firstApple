package com.goforit.firstapple.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by junqingfjq on 16/6/23.
 */

@Service
public class MailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    public boolean sendMail(String targetMail,String srcMail,String sub,String text){
        SimpleMailMessage smm=new SimpleMailMessage();

        smm.setTo(targetMail);
        smm.setFrom(srcMail);

        smm.setSubject(sub);
        smm.setText(text);

        try {
            javaMailSender.send(smm);

        }catch (Exception e){

            e.printStackTrace();
        }

        return true;
    }

}
