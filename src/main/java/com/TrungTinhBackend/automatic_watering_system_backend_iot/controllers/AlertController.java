package com.TrungTinhBackend.automatic_watering_system_backend_iot.controllers;

import com.TrungTinhBackend.automatic_watering_system_backend_iot.models.Alert;
import com.TrungTinhBackend.automatic_watering_system_backend_iot.services.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    @Autowired
    private AlertService alertService;

    @GetMapping
    public List<Alert> getAllAlerts() {
        return alertService.getAllAlerts();
    }

    @PostMapping("/send-email")
    public String sendEmailAlert(@RequestParam String message) {
        alertService.sendEmailAlert(message);
        return "Email alert sent";
    }
}
