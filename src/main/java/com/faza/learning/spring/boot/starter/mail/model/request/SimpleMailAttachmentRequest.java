package com.faza.learning.spring.boot.starter.mail.model.request;

import lombok.Data;
import lombok.NonNull;

/**
 * @author faza.zulfika
 * @version 1.0.0
 * @since 6 February 2018
 */

@Data
public class SimpleMailAttachmentRequest {

    @NonNull
    private SimpleMailRequest simpleMailRequest;

    @NonNull
    private String attachmentPath;
}
