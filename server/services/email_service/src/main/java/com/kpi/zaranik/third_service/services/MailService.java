package com.kpi.zaranik.third_service.services;

import com.kpi.zaranik.third_service.dto.request.EMailDetails;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    public String sendEMail(EMailDetails dto){
        return "your e-letter has been successfully sent";
    }
}
