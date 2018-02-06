package com.faza.learning.spring.boot.starter.mail.command.implementation;

import com.faza.learning.spring.boot.starter.mail.command.SendMailResponseCommand;
import com.faza.learning.spring.boot.starter.mail.model.response.SendMailResponse;
import com.faza.learning.spring.boot.starter.mail.util.ProvideSendMailResponse;

/**
 * @author faza.zulfika
 * @version 1.0.0
 * @since 6 February 2018
 */

public class SendMailSuccessResponseCommand implements SendMailResponseCommand {

    private String message;

    public SendMailSuccessResponseCommand(String message) {
        this.message = message;
    }

    @Override
    public SendMailResponse execute() {
        return ProvideSendMailResponse.proviceSendMailSuccessResponse(message);
    }
}
