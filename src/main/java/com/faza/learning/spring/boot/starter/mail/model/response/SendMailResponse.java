package com.faza.learning.spring.boot.starter.mail.model.response;

import lombok.Data;
import lombok.NonNull;

/**
 * @author faza.zulfika
 * @version 1.0.0
 * @since 6 February 2018
 */

@Data
public class SendMailResponse {

    @NonNull
    private Boolean success;

    @NonNull
    private String message;
}
