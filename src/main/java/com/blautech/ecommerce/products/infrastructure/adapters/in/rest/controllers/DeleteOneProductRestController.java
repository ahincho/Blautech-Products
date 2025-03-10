package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.controllers;

import com.blautech.ecommerce.products.application.ports.in.DeleteOneProductUseCase;
import com.blautech.ecommerce.products.domain.exceptions.ProductNotFoundException;

import jakarta.validation.constraints.PositiveOrZero;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/products")
public class DeleteOneProductRestController {
    private final DeleteOneProductUseCase deleteOneProductUseCase;
    public DeleteOneProductRestController(DeleteOneProductUseCase deleteOneProductUseCase) {
        this.deleteOneProductUseCase = deleteOneProductUseCase;
    }
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteOneProduct(
        @PathVariable("productId")
        @PositiveOrZero(message = "Product id must be greater than 0")
        Long productId
    ) throws ProductNotFoundException {
        this.deleteOneProductUseCase.execute(productId);
        return ResponseEntity.noContent().build();
    }
}
