package com.example.hcservices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * This class represents a measurement entity.
 */
@Data
@Entity
public class Measurement {

    /**
     * Unique identifier for the measurement.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ID of the user who submitted the measurement.
     */
    private Long userId;

    /**
     * Date and time when the measurement was submitted.
     */
    private LocalDateTime localDateTime;

    /**
     * Amount of gas used in the measurement.
     */
    private Double gasUsage;

    /**
     * Amount of cold water used in the measurement.
     */
    private Double coldWaterUsage;

    /**
     * Amount of hot water used in the measurement.
     */
    private Double hotWaterUsage;
}
