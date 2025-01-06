package com.TrungTinhBackend.automatic_watering_system_backend_iot.repositories;

import com.TrungTinhBackend.automatic_watering_system_backend_iot.models.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorDataRepository extends JpaRepository<SensorData,Long> {
    List<SensorData> findTop1ByOrderByTimestampDesc();  // Lấy dữ liệu mới nhất
    List<SensorData> findAllByOrderByTimestampDesc();
}
