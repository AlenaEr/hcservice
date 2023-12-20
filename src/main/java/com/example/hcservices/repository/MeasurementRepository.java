package com.example.hcservices.repository;

import com.example.hcservices.entities.Measurement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing {@link Measurement} entities.
 */
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    /**
     * Retrieves a page of measurements for a specific user ID, ordered by submission date and time in descending order.
     *
     * @param userId   The ID of the user for whom measurements are retrieved.
     * @param pageable Pageable object for pagination and sorting.
     * @return A page of measurements for the specified user ID.
     */
    Page<Measurement> findByUserIdOrderBySubmittedDateTimeDesc(Long userId, Pageable pageable);
}
