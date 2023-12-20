package com.example.hcservices.validators;

import java.time.ZonedDateTime;

public interface DateRangeValidatable {
    ZonedDateTime getFromDateTime();
    ZonedDateTime getToDateTime();
}
