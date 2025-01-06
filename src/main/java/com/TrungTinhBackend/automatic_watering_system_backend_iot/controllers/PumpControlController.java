package com.TrungTinhBackend.automatic_watering_system_backend_iot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pump")
public class PumpControlController {

    private boolean pumpStatus = false;

    @PostMapping("/on")
    public String turnPumpOn() {
        pumpStatus = true;
        return "Pump turned on";
    }

    @PostMapping("/off")
    public String turnPumpOff() {
        pumpStatus = false;
        return "Pump turned off";
    }

    @GetMapping("/status")
    public String getPumpStatus() {
        return pumpStatus ? "Pump is ON" : "Pump is OFF";
    }
}
