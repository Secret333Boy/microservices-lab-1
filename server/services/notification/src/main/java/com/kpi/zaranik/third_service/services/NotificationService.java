package com.kpi.zaranik.third_service.services;

import com.kpi.zaranik.third_service.dto.request.DelayedEMailDetails;
import com.kpi.zaranik.third_service.dto.request.EMailDetails;
import com.kpi.zaranik.third_service.dto.request.EMailWithImageDto;
import com.kpi.zaranik.third_service.entities.DelayedMessage;
import com.kpi.zaranik.third_service.exceptions.MailSendingFailedException;
import com.kpi.zaranik.third_service.repositories.DelayedMessageRepository;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

  private final KafkaTemplate<String, String> kafkaTemplate;
  private final DelayedMessageRepository delayedMessageRepository;

  public String sendEMail(EMailDetails dto) {
    var record = new ProducerRecord<String, String>("email", "send");
    record.headers().add("To", dto.getEmailTo().getBytes());
    record.headers().add("subject", dto.getCaption().getBytes());
    record.headers().add("message_body", dto.getMessageBody().getBytes());
    kafkaTemplate.send(record);
    return "e-mail was sent successfully";
  }

  public void registerDelayedMessage(DelayedEMailDetails dto) {
    DelayedMessage delayedMessage = new DelayedMessage(dto);
    delayedMessageRepository.save(delayedMessage);
  }

  public String sendEMailWithImage(EMailWithImageDto dto) {
    /*try {
      Email email = EmailBuilder.startingBlank()
              .from("From", emailFrom)
              .to("To", dto.getEmailTo())
              .withSubject(dto.getCaption())
              .withPlainText(dto.getMessageBody())
              .withEmbeddedImage("Your ticket here!", dto.getImage(),"image/jpeg")
              .buildEmail();
      MailerBuilder
              .withSMTPServer("smtp.gmail.com", 587, emailFrom, emailKey)
              .withTransportStrategy(TransportStrategy.SMTP)
              .buildMailer()
              .sendMail(email);
    } catch (Exception e) {
      throw new MailSendingFailedException("something went wrong, your letter was not sent");
    }*/
    return "e-mail was sent successfully";
  }

}
