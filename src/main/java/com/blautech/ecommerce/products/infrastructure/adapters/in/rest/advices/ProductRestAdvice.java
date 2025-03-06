package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.advices;

import com.blautech.ecommerce.products.domain.exceptions.ProductDuplicateException;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.ExceptionResponse;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductRestAdvice {
    @ExceptionHandler(ProductDuplicateException.class)
    public ResponseEntity<ExceptionResponse> productDuplicateException(
        ProductDuplicateException productDuplicateException,
        HttpServletRequest httpServletRequest
    ) {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
            .path(httpServletRequest.getRequestURI())
            .method(httpServletRequest.getMethod())
            .statusCode(HttpStatus.CONFLICT.value())
            .statusDescription(HttpStatus.CONFLICT.name())
            .message(productDuplicateException.getMessage())
            .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponse);
    }
}
