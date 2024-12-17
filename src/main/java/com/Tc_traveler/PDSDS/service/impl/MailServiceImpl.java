package com.Tc_traveler.PDSDS.service.impl;

import com.Tc_traveler.PDSDS.entity.Doctor;
import com.Tc_traveler.PDSDS.mapper.MailMapper;
import com.Tc_traveler.PDSDS.service.MailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private MailMapper mailMapper;

    @Value("${spring.mail.username}")
    private String username;
    @Autowired
    private JavaMailSenderImpl mailSender;

    @Override
    public Doctor findByDoctorEmail(String email) {
        return mailMapper.findByDoctorEmail(email);
    }

    @Override
    public void getCode(String email) {
        Random random = new Random();
        int token = 100000 + random.nextInt(900000);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><head><title></title></head><body>");
        stringBuilder.append("您好<br/>");
        stringBuilder.append("您的验证码是：").append(token).append("<br/>");
        stringBuilder.append("您可以复制此验证码并返回至找回密码页面，以验证您的邮箱。<br/>");
        stringBuilder.append("此验证码只能使用一次，在5分钟内有效。验证成功则自动失效。<br/>");
        stringBuilder.append("如果您没有进行上述操作，请忽略此邮件。");
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setFrom(username);
            mimeMessageHelper.setSubject("重置密码");
            mimeMessageHelper.setText(stringBuilder.toString(), true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        mailMapper.addMsg(email,token);
    }
}
