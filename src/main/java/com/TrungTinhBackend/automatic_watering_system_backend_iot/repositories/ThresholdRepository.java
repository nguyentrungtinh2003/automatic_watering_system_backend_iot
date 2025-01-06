package com.TrungTinhBackend.automatic_watering_system_backend_iot.repositories;

import com.TrungTinhBackend.automatic_watering_system_backend_iot.models.Threshold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThresholdRepository extends JpaRepository<Threshold,Long> {
}
