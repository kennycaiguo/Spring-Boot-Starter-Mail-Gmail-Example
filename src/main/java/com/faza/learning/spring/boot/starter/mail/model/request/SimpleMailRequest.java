package com.faza.learning.spring.boot.starter.mail.model.request;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

/**
 * @author faza.zulfika
 * @version 1.0.0
 * @since 6 February 2018
 */

@Data
@Builder
public class SimpleMailRequest {

    private String from;
    private String password;
    private String to;
    private String[] cc;
    private String[] bcc;
    private String subject;
    private String message;
    private String replyTo;
    private Date sentDate;
}
