package com.faza.learning.spring.boot.starter.mail.util;

import com.faza.learning.spring.boot.starter.mail.model.request.SimpleMailAttachmentRequest;
import com.faza.learning.spring.boot.starter.mail.model.request.SimpleMailRequest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author faza.zulfika
 * @version 1.0.0
 * @since 6 February 2018
 */

public class ProvideMailMessage {

    public static SimpleMailMessage provideSimpleMailMessage(SimpleMailRequest simpleMailRequest) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

//        simpleMailMessage.setFrom(simpleMailRequest.getFrom());   // From are same with user email
        simpleMailMessage.setTo(simpleMailRequest.getTo());
        simpleMailMessage.setCc(simpleMailRequest.getCc());
        simpleMailMessage.setBcc(simpleMailRequest.getBcc());
        simpleMailMessage.setSubject(simpleMailRequest.getSubject());
        simpleMailMessage.setText(simpleMailRequest.getMessage());
        simpleMailMessage.setReplyTo(simpleMailRequest.getReplyTo());
        simpleMailMessage.setSentDate(simpleMailRequest.getSentDate());

        return simpleMailMessage;
    }

    public static MimeMessage provideSimpleMailMimeMessage(SimpleMailAttachmentRequest simpleMailAttachmentRequest,
                                                           MimeMessage mimeMessage) throws MessagingException {

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        FileSystemResource file = new FileSystemResource(new File(simpleMailAttachmentRequest.getAttachmentPath()));
        SimpleMailRequest simpleMailRequest = simpleMailAttachmentRequest.getSimpleMailRequest();

//        mimeMessageHelper.setFrom(simpleMailRequest.getFrom());   // From are same with user email
        mimeMessageHelper.setTo(simpleMailRequest.getTo());
        mimeMessageHelper.setCc(simpleMailRequest.getCc());
        mimeMessageHelper.setBcc(simpleMailRequest.getBcc());
        mimeMessageHelper.setSubject(simpleMailRequest.getSubject());
        mimeMessageHelper.setText(simpleMailRequest.getMessage());
        mimeMessageHelper.setReplyTo(simpleMailRequest.getReplyTo());
        mimeMessageHelper.setSentDate(simpleMailRequest.getSentDate());
        mimeMessageHelper.setSubject(simpleMailRequest.getSubject());
        mimeMessageHelper.setText(simpleMailRequest.getMessage());
        mimeMessageHelper.addAttachment("Attachment-File", file);

        return mimeMessage;
    }
}
