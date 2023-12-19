package com.example.hcservices.validators;

import com.example.hcservices.annotations.DateRange;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateRangeValidator implements ConstraintValidator<DateRange, Object> {

    @Override
    public void initialize(DateRange constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value instanceof DateRangeValidatable) {
            DateRangeValidatable dateRangeValidatable = (DateRangeValidatable) value;
            LocalDateTime fromDateTime = dateRangeValidatable.getFromDateTime();
            LocalDateTime toDateTime = dateRangeValidatable.getToDateTime();

            if (fromDateTime != null && toDateTime != null) {
                long daysBetween = ChronoUnit.DAYS.between(fromDateTime, toDateTime);
                return daysBetween <= 30;
            }
        }

        return true;
    }
}

