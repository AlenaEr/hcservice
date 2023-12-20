package com.example.hcservices.validators;

import com.example.hcservices.annotations.DateRange;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Validator for the {@link DateRange} annotation.
 * Validates that the date range.
 * does not exceed 30 days.
 */
public class DateRangeValidator implements ConstraintValidator<DateRange, Object> {

    @Override
    public void initialize(DateRange constraintAnnotation) {
    }

    /**
     * Validates the date range.
     *
     * @param value   The object to be validated.
     * @param context The validation context.
     * @return {@code true} if the date range is valid, {@code false} otherwise.
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value instanceof DateRangeValidatable) {
            DateRangeValidatable dateRangeValidatable = (DateRangeValidatable) value;
            ZonedDateTime fromDateTime = dateRangeValidatable.getFromDateTime();
            ZonedDateTime toDateTime = dateRangeValidatable.getToDateTime();

            if (fromDateTime != null && toDateTime != null) {
                long daysBetween = ChronoUnit.DAYS.between(fromDateTime, toDateTime);
                return daysBetween <= 30;
            }
        }
        return true;
    }
}

