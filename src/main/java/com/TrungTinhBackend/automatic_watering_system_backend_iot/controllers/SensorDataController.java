package com.TrungTinhBackend.automatic_watering_system_backend_iot.controllers;

import com.TrungTinhBackend.automatic_watering_system_backend_iot.models.SensorData;
import com.TrungTinhBackend.automatic_watering_system_backend_iot.services.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorDataController {

    @Autowired
    private SensorDataService sensorDataService;

    @GetMapping
    public List<SensorData> getAllSensorData() {
        return sensorDataService.getAllSensorData();
    }

    @GetMapping("/latest")
    public List<SensorData> getLatestSensorData() {
        return sensorDataService.getLatestSensorData();
    }

    @PostMapping("/fetch")
    public String fetchData() {
        sensorDataService.fetchDataFromThinkSpeak("YOUR_CHANNEL_ID", "YOUR_API_KEY");
        return "Data fetched successfully";
    }
}
