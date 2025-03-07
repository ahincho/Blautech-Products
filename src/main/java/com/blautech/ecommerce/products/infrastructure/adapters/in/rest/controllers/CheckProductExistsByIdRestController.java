package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.controllers;

import com.blautech.ecommerce.products.application.ports.in.CheckProductExistsByIdUseCase;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.CheckResponse;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.mappers.CommonRestMapper;

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
public class CheckProductExistsByIdRestController {
    private final CheckProductExistsByIdUseCase checkProductExistsByIdUseCase;
    public CheckProductExistsByIdRestController(CheckProductExistsByIdUseCase checkProductExistsByIdUseCase) {
        this.checkProductExistsByIdUseCase = checkProductExistsByIdUseCase;
    }
    @GetMapping("/ids/{productId}")
    public ResponseEntity<CheckResponse> checkProductExistsById(
        @PathVariable
        @Min(value = 1, message = "Product id must be greater than 0")
        Long productId
    ) {
        Boolean existsById = this.checkProductExistsByIdUseCase.execute(productId);
        return ResponseEntity.ok(CommonRestMapper.boleanToCheckResponse(existsById));
    }
}
