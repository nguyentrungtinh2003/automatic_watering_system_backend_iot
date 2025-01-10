package com.TrungTinhBackend.automatic_watering_system_backend_iot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendEmail(APIRequest apiRequest) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(apiRequest.getTo());
            message.setSubject(apiRequest.getSubject());
            message.setText(apiRequest.getBody());
            javaMailSender.send(message);
            return "Email sent successfully!";
        } catch (Exception e) {
            return "Failed to send email!";
        }
    }
}
