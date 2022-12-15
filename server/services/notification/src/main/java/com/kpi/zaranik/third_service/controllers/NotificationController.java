package com.kpi.zaranik.third_service.controllers;

import com.kpi.zaranik.third_service.dto.request.ActivationDetails;
import com.kpi.zaranik.third_service.dto.request.DelayedEMailDetails;
import com.kpi.zaranik.third_service.dto.request.EMailDetails;
import com.kpi.zaranik.third_service.dto.request.EMailWithImageDto;
import com.kpi.zaranik.third_service.services.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class NotificationController {

  private final NotificationService notificationService;

  @PostMapping("/send-delayed")
  public String sendDelayedEMail(@RequestBody @Valid DelayedEMailDetails details) {
    notificationService.registerDelayedMessage(details);
    return "successfully registered message";
  }

  @PostMapping("/send/ticket")
  public String sendEMailWithImage(@RequestBody @Valid EMailWithImageDto details) {
    return notificationService.sendEMailWithImage(details);
  }

  @KafkaListener(topics = "notification", groupId = "groupId")
  public void listenGroupFoo(String type, @Header("email_to") String emailTo, @Header("activation_link") String activationLink) {
    System.out.println("<<<Received Message " + type);
    switch (type) {
      case "activation-email" -> {
        System.out.println("<<< Sending activation email: email_to = " + emailTo + " activation_link = " + activationLink);
        ActivationDetails details = new ActivationDetails(emailTo, activationLink);
        EMailDetails eMailDetails = new EMailDetails(
          details.getEmailTo(),
          "Movie Booking Activation",
          details.getActivationLink()
        );
        notificationService.sendEMail(eMailDetails);
      }

    }
  }

}
