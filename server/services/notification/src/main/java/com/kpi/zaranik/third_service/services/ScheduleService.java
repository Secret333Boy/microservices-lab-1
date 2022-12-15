package com.kpi.zaranik.third_service.services;

import com.kpi.zaranik.third_service.entities.DelayedMessage;
import com.kpi.zaranik.third_service.repositories.DelayedMessageRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
  @Autowired
  private DelayedMessageRepository delayedMessageRepository;

  @Autowired
  private NotificationService notificationService;

  @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
  private void doCyclicLogs(){
    LocalDateTime now = LocalDateTime.now();
    List<DelayedMessage> list = delayedMessageRepository.findAllByWhenToSendMillisIsLessThan(now);
    list.forEach((msg) -> {
      notificationService.sendEMail(msg.getEmailDetails());
      delayedMessageRepository.delete(msg);
    });
  }


}
