package com.example.hcservices.repository;

import com.example.hcservices.entities.Measurement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    Page<Measurement> findByUserIdOrderByLocalDateTimeDesc(Long userId, Pageable pageable);
}
