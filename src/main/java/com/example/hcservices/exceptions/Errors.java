package com.example.hcservices.exceptions;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.util.Map;

public class Errors {

    private HttpStatus status;

    private ZonedDateTime ZonedDateTime;

    private String message;
    private Map<String, Object> details;

    public Errors(HttpStatus status, Map<String, Object> details) {
        this.status = status;
        this.ZonedDateTime = ZonedDateTime.now();
        this.message = "Unexpected error";
        this.details = details;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ZonedDateTime getTimestamp() {
        return ZonedDateTime;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getDetails() {
        return details;
    }
}

