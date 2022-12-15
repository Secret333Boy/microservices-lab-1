package com.kpi.zaranik.third_service.controllers;

import com.kpi.zaranik.third_service.dto.request.EMailDetails;
import com.kpi.zaranik.third_service.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EMailController {

  private final MailService mailService;

  @KafkaListener(topics = "email", groupId = "email_group_id")
  public String sendEMail(
    String message,
    @Header("To") String emailTo,
    @Header("subject") String subject,
    @Header("message_body") String text
  ) {
    if (message.equals("send")) {
      EMailDetails details = new EMailDetails(emailTo, subject, text);
      System.out.println("Received Message in group foo: " + message);
      return mailService.sendEMail(details);
    }
    return "fuck you, but not a message!";
  }

}
