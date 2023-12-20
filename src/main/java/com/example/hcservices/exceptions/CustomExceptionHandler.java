package com.example.hcservices.exceptions;

import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

//@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(PropertyReferenceException.class)
    protected ResponseEntity<Object> handlePropertyReferenceException(PropertyReferenceException ex, WebRequest request) {
        String propertyName = ex.getPropertyName();
        String baseClassName = ex.getClass().getSimpleName();
        String errorMessage = "Invalid property reference: " + propertyName + " for type " + baseClassName;

        Map<String, Object> errorDetails = new HashMap<>();

        String requestURI = ((ServletWebRequest) request).getRequest().getRequestURI();
        errorDetails.put("requestURI", requestURI);
        errorDetails.put("error", "Invalid Property Reference");
        errorDetails.put("message", errorMessage);
        errorDetails.put("propertyName", propertyName);
        errorDetails.put("baseClassName", baseClassName);
        Errors errors = new Errors(HttpStatus.BAD_REQUEST, errorDetails);
        return new ResponseEntity<>(errors, errors.getStatus());
    }
}

