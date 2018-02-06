package com.faza.learning.spring.boot.starter.mail;

import com.faza.learning.spring.boot.starter.mail.model.request.SimpleMailRequest;
import com.faza.learning.spring.boot.starter.mail.model.response.SendMailResponse;
import com.faza.learning.spring.boot.starter.mail.service.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Calendar;
import java.util.Date;

/**
 * @author faza.zulfika
 * @version 1.0.0
 * @since 6 February 2018
 */

@SpringBootApplication
public class SpringBootStarterMailApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(SpringBootStarterMailApplication.class, args);
        EmailService emailService = applicationContext.getBean(EmailService.class);

        SimpleMailRequest simpleMailRequest = SimpleMailRequest.builder()
//                .from("from-user-email@gmail.com") // Same with username at application.properties, uncomment this if you didn't want to set user email at application properties
//                .password("application password") // Same with password at application.properties, uncomment this if you didn't want to set password at application properties
                .to("to-user-email@gmail.com")
                .subject("Testing Spring Boot Starter Mail")
                .message("Hello, I am sending email from my spring boot starter mail application")
                .build();

        SendMailResponse sendMailResponse = emailService.sendSimpleMail(simpleMailRequest);
        System.out.println(sendMailResponse.toString());
    }
}
