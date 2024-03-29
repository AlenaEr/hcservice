package com.example.hcservices.services;

import com.example.hcservices.entities.Measurement;
import com.example.hcservices.repository.MeasurementRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {


    final MeasurementRepository measurementRepository;

    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }

    /**
     * Submit a new measurement.
     *
     * @param measurement The measurement to submit.
     * @return The submitted measurement.
     */
    public Measurement submitMeasurement(Measurement measurement) {
        return measurementRepository.save(measurement);
    }

    /**
     * Get user measurement history by userId.
     *
     * @param userId The ID of the user to retrieve measurement history.
     * @return The measurement history for the specified user.
     */
    public Page<Measurement> getMeasurementHistory(Long userId, Pageable pageable) {
        return measurementRepository.findByUserIdOrderBySubmittedDateTimeDesc(userId, pageable);
    }

}
