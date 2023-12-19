package com.example.hcservices.services;

import com.example.hcservices.entities.Measurement;
import com.example.hcservices.repository.MeasurementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Measurement> getMeasurementHistory(Long userId) {
        return measurementRepository.findByUserIdOrderByLocalDateTimeDesc(userId);
    }

}
