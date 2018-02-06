package com.faza.learning.spring.boot.starter.mail.command;

import com.faza.learning.spring.boot.starter.mail.model.response.SendMailResponse;

/**
 * @author faza.zulfika
 * @version 1.0.0
 * @since 6 February 2018
 */

public interface SendMailResponseCommand {

    SendMailResponse execute();
}
