package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.controllers;

import com.blautech.ecommerce.products.application.ports.in.FindOneProductUseCase;
import com.blautech.ecommerce.products.domain.exceptions.ProductNotFoundException;
import com.blautech.ecommerce.products.domain.models.Product;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.ProductResponse;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.mappers.ProductRestMapper;

import jakarta.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/v1/products")
public class FindOneProductRestController {
    private final FindOneProductUseCase findOneProductUseCase;
    public FindOneProductRestController(FindOneProductUseCase findOneProductUseCase) {
        this.findOneProductUseCase = findOneProductUseCase;
    }
    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> findOneProduct(
        @PathVariable
        @Min(value = 1, message = "Product id must be greater than 0")
        Long productId
    ) throws ProductNotFoundException {
        Product product = this.findOneProductUseCase.execute(productId);
        return ResponseEntity.ok(ProductRestMapper.domainToResponse(product));
    }
}
