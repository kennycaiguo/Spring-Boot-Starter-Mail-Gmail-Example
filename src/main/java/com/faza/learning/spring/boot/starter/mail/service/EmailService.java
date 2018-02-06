package com.faza.learning.spring.boot.starter.mail.service;

import com.faza.learning.spring.boot.starter.mail.model.request.SimpleMailAttachmentRequest;
import com.faza.learning.spring.boot.starter.mail.model.request.SimpleMailRequest;
import com.faza.learning.spring.boot.starter.mail.model.response.SendMailResponse;

/**
 * @author faza.zulfika
 * @version 1.0.0
 * @since 6 February 2018
 */

public interface EmailService {

    SendMailResponse sendSimpleMail(SimpleMailRequest simpleMailRequest);

    SendMailResponse sendSimpleMailWithAttachment(SimpleMailAttachmentRequest simpleMailAttachmentRequest);
}