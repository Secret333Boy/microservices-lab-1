package com.kpi.zaranik.third_service.services;

import com.kpi.zaranik.third_service.dto.request.DelayedEMailDetails;
import com.kpi.zaranik.third_service.dto.request.EMailDetails;
import com.kpi.zaranik.third_service.entities.DelayedMessage;
import com.kpi.zaranik.third_service.exceptions.MailSendingFailedException;
import com.kpi.zaranik.third_service.repositories.DelayedMessageRepository;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MailService {

  @Autowired
  private DelayedMessageRepository delayedMessageRepository;

  @Value("${from.email}")
  private String emailFrom;

  @Value("${from.key}")
  private String emailKey;

  public String sendEMail(EMailDetails dto) {
    try {
      Email email = EmailBuilder.startingBlank()
          .from("From", "zaranikbz@gmail.com")
          .to("To", dto.getEmailTo())
          .withSubject(dto.getCaption())
          .withPlainText(dto.getMessageBody())
          .buildEmail();
      MailerBuilder
          .withSMTPServer("smtp.gmail.com", 587, emailFrom, emailKey)
          .withTransportStrategy(TransportStrategy.SMTP)
          .buildMailer()
          .sendMail(email);
    } catch (Exception e) {
      throw new MailSendingFailedException("something went wrong, your letter was not sent");
    }
    return "e-mail was sent successfully";
  }

  public void registerDelayedMessage(DelayedEMailDetails dto) {
    DelayedMessage delayedMessage = new DelayedMessage(dto);
    delayedMessageRepository.save(delayedMessage);
  }
}
