package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ProductIdsValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidProductIds {
    String message() default "All product ids must be greater than 0 and not null";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
