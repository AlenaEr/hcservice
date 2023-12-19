package com.example.hcservices.entities;

import com.example.hcservices.annotations.DateRange;
import com.example.hcservices.validators.DateRangeValidatable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * This class represents a measurement entity.
 */
@Data
@Entity
@DateRange(message = "Date range must not exceed 30 days")
public class Measurement implements DateRangeValidatable {

    /**
     * Unique identifier for the measurement.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ID of the user who submitted the measurement.
     */
    @NotNull(message = "User ID must not be null")
    private Long userId;

    /**
     * Date and time when the measurement was submitted.
     */
    @PastOrPresent(message = "Submitted date and time must be in the past or present")
    private LocalDateTime submittedDateTime;

    /**
     * The starting date of the period for which the measurements were submitted
     */
    @PastOrPresent(message = "From date and time must be in the past or present")
    private LocalDateTime fromDateTime;

    /**
     * The end date of the period for which the measurements were submitted
     */
    @PastOrPresent(message = "To date and time must be in the past or present")
    private LocalDateTime toDateTime;

    /**
     * Amount of gas used in the measurement.
     */
    @Min(value = 0, message = "Gas usage must be a positive value")
    private Double gasUsage;

    /**
     * Amount of cold water used in the measurement.
     */
    @Min(value = 0, message = "Water usage must be a positive value")
    private Double coldWaterUsage;

    /**
     * Amount of hot water used in the measurement.
     */
    @Min(value = 0, message = "Water usage must be a positive value")
    private Double hotWaterUsage;
}
