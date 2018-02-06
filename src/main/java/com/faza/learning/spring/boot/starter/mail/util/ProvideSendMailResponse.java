package com.faza.learning.spring.boot.starter.mail.util;

import com.faza.learning.spring.boot.starter.mail.model.response.SendMailResponse;

/**
 * @author faza.zulfika
 * @version 1.0.0
 * @since 6 February 2018
 */

public class ProvideSendMailResponse {

    public static SendMailResponse provideSendMailFailureResponse(String message) {
        return new SendMailResponse(false, message);
    }

    public static SendMailResponse proviceSendMailSuccessResponse(String message) {
        return new SendMailResponse(true, message);
    }
}
