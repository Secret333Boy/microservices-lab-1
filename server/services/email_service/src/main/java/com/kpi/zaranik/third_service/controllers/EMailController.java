package com.kpi.zaranik.third_service.controllers;

import com.kpi.zaranik.third_service.dto.request.ActivationDetails;
import com.kpi.zaranik.third_service.dto.request.EMailDetails;
import com.kpi.zaranik.third_service.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EMailController {

    private final MailService mailService;

    @PostMapping("/send")
    public String sendEMail(@RequestBody @Valid EMailDetails details){
        return mailService.sendEMail(details);
    }

    @PostMapping("/send-activation")
    public String sendEMail(@RequestBody @Valid ActivationDetails details){
        EMailDetails eMailDetails = new EMailDetails(details.getEmailTo(), "Movie Booking Activation", details.getActivationLink());
        return mailService.sendEMail(eMailDetails);
    }



}
