package com.example.hcservices.repository;

import com.example.hcservices.entities.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    List<Measurement> findByUserIdOrderByLocalDateTimeDesc(Long userId);
}
