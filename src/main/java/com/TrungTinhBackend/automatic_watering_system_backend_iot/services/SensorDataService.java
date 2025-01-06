package com.TrungTinhBackend.automatic_watering_system_backend_iot.services;

import com.TrungTinhBackend.automatic_watering_system_backend_iot.models.SensorData;
import com.TrungTinhBackend.automatic_watering_system_backend_iot.models.ThinkSpeakResponse;
import com.TrungTinhBackend.automatic_watering_system_backend_iot.repositories.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorDataService {

    @Autowired
    private SensorDataRepository sensorDataRepository;

    private final String THINKSPEAK_URL = "https://api.thingspeak.com/channels/{channel_id}/feeds.json?api_key={api_key}";

    public void fetchDataFromThinkSpeak(String channelId, String apiKey) {
        RestTemplate restTemplate = new RestTemplate();
        String url = THINKSPEAK_URL.replace("{channel_id}", channelId).replace("{api_key}", apiKey);
        ThinkSpeakResponse response = restTemplate.getForObject(url, ThinkSpeakResponse.class);

        if (response != null && response.getFeeds().size() > 0) {
            var feed = response.getFeeds().get(0);
            try {
                SensorData data = new SensorData();
                // Chuyển đổi field1 và field2 từ String sang float
                data.setTemperature(Float.parseFloat(feed.getField1()));
                data.setHumidity(Float.parseFloat(feed.getField2()));
                data.setTimestamp(LocalDateTime.now());
                sensorDataRepository.save(data);
            } catch (NumberFormatException e) {
                // Xử lý trường hợp chuyển đổi thất bại
                e.printStackTrace();  // Hoặc log lỗi
            }
        }
    }

    public List<SensorData> getAllSensorData() {
        return sensorDataRepository.findAllByOrderByTimestampDesc();
    }

    public List<SensorData> getLatestSensorData() {
        return sensorDataRepository.findTop1ByOrderByTimestampDesc();
    }
}
