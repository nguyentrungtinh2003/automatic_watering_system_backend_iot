package com.TrungTinhBackend.automatic_watering_system_backend_iot.services;

import com.TrungTinhBackend.automatic_watering_system_backend_iot.models.Threshold;
import com.TrungTinhBackend.automatic_watering_system_backend_iot.repositories.ThresholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThresholdService {

    @Autowired
    private ThresholdRepository thresholdRepository;

    public Threshold getThreshold() {
        return thresholdRepository.findAll().stream().findFirst().orElse(null);
    }

    public void updateThreshold(Threshold newThreshold) {
        thresholdRepository.save(newThreshold);
    }
}
