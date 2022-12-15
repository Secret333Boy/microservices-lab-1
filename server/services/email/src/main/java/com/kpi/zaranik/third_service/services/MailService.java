package com.kpi.zaranik.third_service.services;

import com.kpi.zaranik.third_service.dto.request.EMailDetails;
import com.kpi.zaranik.third_service.exceptions.MailSendingFailedException;
import lombok.RequiredArgsConstructor;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

  @Value("${from.email}")
  private String emailFrom;

  @Value("${from.key}")
  private String emailKey;

  public String sendEMail(EMailDetails dto) {
    try {
      Email email = EmailBuilder.startingBlank()
          .from("From", emailFrom)
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
}
