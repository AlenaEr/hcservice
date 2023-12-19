package com.example.hcservices.controllers;

import com.example.hcservices.entities.Measurement;
import com.example.hcservices.services.MeasurementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Measurement Controller", description = "Operations related to measurements")
@RestController
@RequestMapping("/api")
public class MeasurementController {

    @Autowired
    MeasurementService measurementService;

    /**
     * Submit a new measurement.
     *
     * @param measurement The measurement to submit.
     * @return The submitted measurement.
     */
    @Operation(summary = "Submit a new measurement", description = "Submit a new measurement and get the submitted measurement.")
    @PostMapping
    public ResponseEntity<Measurement> submitMeasurement(@RequestBody Measurement measurement) {
        Measurement submittedMeasurement = measurementService.submitMeasurement(measurement);
        return new ResponseEntity<>(submittedMeasurement, HttpStatus.CREATED);
    }

    @Operation(summary = "Get user measurement history", description = "Retrieve the measurement history for a user by userId.")
    @GetMapping("/{userId}/history")
    public ResponseEntity<Page<Measurement>> getMeasurementHistory(@PathVariable Long userId, Pageable pageable) {
        Page<Measurement> history = measurementService.getMeasurementHistory(userId, pageable);
        return new ResponseEntity<>(history, HttpStatus.OK);
    }
}

