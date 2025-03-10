package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class ProductIdsValidator implements ConstraintValidator<ValidProductIds, List<Long>> {
    @Override
    public boolean isValid(List<Long> ids, ConstraintValidatorContext context) {
        if (ids == null || ids.isEmpty()) {
            return false;
        }
        return ids.stream().allMatch(id -> id != null && id > 0);
    }
}
