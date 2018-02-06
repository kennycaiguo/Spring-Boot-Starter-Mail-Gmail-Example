package com.faza.learning.spring.boot.starter.mail.service.implementation;

import com.faza.learning.spring.boot.starter.mail.command.SendMailResponseCommand;
import com.faza.learning.spring.boot.starter.mail.command.implementation.SendMailFailureResponseCommand;
import com.faza.learning.spring.boot.starter.mail.command.implementation.SendMailSuccessResponseCommand;
import com.faza.learning.spring.boot.starter.mail.model.request.SimpleMailAttachmentRequest;
import com.faza.learning.spring.boot.starter.mail.model.request.SimpleMailRequest;
import com.faza.learning.spring.boot.starter.mail.model.response.SendMailResponse;
import com.faza.learning.spring.boot.starter.mail.service.EmailService;
import com.faza.learning.spring.boot.starter.mail.util.ProvideMailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author faza.zulfika
 * @version 1.0.0
 * @since 6 February 2018
 */

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.send.success}")
    private String successMessage;

    @Value("${mail.send.failure}")
    private String failureMessage;

    @Override
    public SendMailResponse sendSimpleMail(SimpleMailRequest simpleMailRequest) {
        SimpleMailMessage simpleMailMessage = ProvideMailMessage.provideSimpleMailMessage(simpleMailRequest);
        SendMailResponseCommand sendMailResponseCommand = new SendMailSuccessResponseCommand(successMessage);

        try {
//            ((JavaMailSenderImpl) javaMailSender).setUsername(simpleMailRequest.getFrom());   // Uncomment this if you didn't want to set user email at application properties
//            ((JavaMailSenderImpl) javaMailSender).setPassword(simpleMailRequest.getPassword());   // Uncomment this if you didn't want to set password at application properties
            javaMailSender.send(simpleMailMessage);
        } catch (MailException e) {
            sendMailResponseCommand = new SendMailFailureResponseCommand(failureMessage + " " + e.getMessage());
        }

        return sendMailResponseCommand.execute();
    }

    @Override
    public SendMailResponse sendSimpleMailWithAttachment(SimpleMailAttachmentRequest simpleMailAttachmentRequest) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        SendMailResponseCommand sendMailResponseCommand = new SendMailSuccessResponseCommand(successMessage);

        try {
            mimeMessage = ProvideMailMessage.provideSimpleMailMimeMessage(simpleMailAttachmentRequest, mimeMessage);
        } catch (MessagingException e) {
            sendMailResponseCommand = new SendMailFailureResponseCommand(failureMessage + " " + e.getMessage());
        }

        try {
//            ((JavaMailSenderImpl) javaMailSender).setUsername(simpleMailAttachmentRequest.getSimpleMailRequest().getFrom());   // Uncomment this if you didn't want to set user email at application properties
//            ((JavaMailSenderImpl) javaMailSender).setPassword(simpleMailAttachmentRequest.getSimpleMailRequest().getPassword());   // Uncomment this if you didn't want to set password at application properties
            javaMailSender.send(mimeMessage);
        } catch (MailException e) {
            sendMailResponseCommand = new SendMailFailureResponseCommand(failureMessage + " " + e.getMessage());
        }

        return sendMailResponseCommand.execute();
    }
}
