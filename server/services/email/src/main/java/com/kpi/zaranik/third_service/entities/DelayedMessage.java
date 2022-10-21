package com.kpi.zaranik.third_service.entities;

import com.kpi.zaranik.third_service.dto.request.DelayedEMailDetails;
import com.kpi.zaranik.third_service.dto.request.EMailDetails;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "delayed_messages")
@NoArgsConstructor
public class DelayedMessage extends BaseEntity{

  private String emailTo;

  private String caption;

  private String messageBody;

  private LocalDateTime whenToSendMillis;

  public DelayedMessage(DelayedEMailDetails dto) {
    this.emailTo = dto.getEmailTo();
    this.caption = dto.getCaption();
    this.messageBody = dto.getMessageBody();
    this.whenToSendMillis = dto.getWhenToSendMillis();
  }

  public EMailDetails getEmailDetails(){
    return new EMailDetails(emailTo, caption, messageBody);
  }


}
