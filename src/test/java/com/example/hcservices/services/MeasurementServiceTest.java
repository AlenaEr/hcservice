package com.example.hcservices.services;

import com.example.hcservices.entities.Measurement;
import com.example.hcservices.repository.MeasurementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MeasurementServiceTest {
    @Mock
    private MeasurementRepository measurementRepository;

    @InjectMocks
    private MeasurementService measurementService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    //TODO more testst and tests for controllers, repo (see README)

    @Test
    void testSubmitMeasurement() {
        Measurement measurement = new Measurement();
        measurement.setUserId(1L);
        measurement.setSubmittedDateTime(ZonedDateTime.now());

        when(measurementRepository.save(measurement)).thenReturn(measurement);

        Measurement submittedMeasurement = measurementService.submitMeasurement(measurement);

        assertEquals(measurement, submittedMeasurement);
    }

    @Test
    void testGetMeasurementHistory() {
        Long userId = 1L;
        Pageable pageable = PageRequest.of(0, 10);

        when(measurementRepository.findByUserIdOrderBySubmittedDateTimeDesc(userId, pageable)).thenReturn(Page.empty());

        Page<Measurement> history = measurementService.getMeasurementHistory(userId, pageable);

        assertEquals(Page.empty(), history);
    }


    @Test
    void testGetMeasurementHistoryForGasUsage() {
        Long userId = 1L;
        Pageable pageable = PageRequest.of(0, 10);

        Measurement measurement = new Measurement();
        measurement.setGasUsage(50.0);

        List<Measurement> measurementList = Collections.singletonList(measurement);
        Page<Measurement> page = new PageImpl<>(measurementList, pageable, measurementList.size());

        when(measurementRepository.findByUserIdOrderBySubmittedDateTimeDesc(userId, pageable)).thenReturn(page);

        Page<Measurement> history = measurementService.getMeasurementHistory(userId, pageable);

        assertEquals(1, history.getContent().size());
        assertEquals(50.0, history.getContent().get(0).getGasUsage());
    }

}