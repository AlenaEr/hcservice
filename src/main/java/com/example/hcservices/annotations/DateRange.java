package com.example.hcservices.annotations;


import com.example.hcservices.validators.DateRangeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateRangeValidator.class)
@Documented
public @interface DateRange {

    String message() default "Date range must not exceed n days";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
