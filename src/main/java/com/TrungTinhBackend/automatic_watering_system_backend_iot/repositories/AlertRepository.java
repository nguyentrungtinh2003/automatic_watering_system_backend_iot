package com.TrungTinhBackend.automatic_watering_system_backend_iot.repositories;

import com.TrungTinhBackend.automatic_watering_system_backend_iot.models.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<Alert,Long> {
}
