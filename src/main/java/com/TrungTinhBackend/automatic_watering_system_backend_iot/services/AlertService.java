package com.TrungTinhBackend.automatic_watering_system_backend_iot.services;

import com.TrungTinhBackend.automatic_watering_system_backend_iot.models.Alert;
import com.TrungTinhBackend.automatic_watering_system_backend_iot.repositories.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public void sendEmailAlert(String message) {
        // Gửi email (bạn có thể sử dụng Spring Mail hoặc thư viện khác)
        System.out.println("Sending email alert: " + message);

        // Lưu vào cơ sở dữ liệu
        Alert alert = new Alert();
        alert.setMessage(message);
        alertRepository.save(alert);
    }
}
