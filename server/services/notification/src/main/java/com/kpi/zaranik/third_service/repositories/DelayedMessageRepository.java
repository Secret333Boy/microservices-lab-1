package com.kpi.zaranik.third_service.repositories;

import com.kpi.zaranik.third_service.entities.DelayedMessage;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DelayedMessageRepository extends JpaRepository<DelayedMessage, Long> {

  List<DelayedMessage> findAllByWhenToSendMillisIsLessThan(LocalDateTime millisNow);

}
