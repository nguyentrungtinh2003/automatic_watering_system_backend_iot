package com.TrungTinhBackend.automatic_watering_system_backend_iot.controllers;

import com.TrungTinhBackend.automatic_watering_system_backend_iot.models.Threshold;
import com.TrungTinhBackend.automatic_watering_system_backend_iot.services.ThresholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/threshold")
public class ThresholdController {

    @Autowired
    private ThresholdService thresholdService;

    @GetMapping
    public Threshold getThreshold() {
        return thresholdService.getThreshold();
    }

    @PutMapping
    public String updateThreshold(@RequestBody Threshold threshold) {
        thresholdService.updateThreshold(threshold);
        return "Threshold updated";
    }
}
