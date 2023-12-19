package com.example.hcservices.validators;

import java.time.LocalDateTime;

public interface DateRangeValidatable {
    LocalDateTime getFromDateTime();
    LocalDateTime getToDateTime();
}
