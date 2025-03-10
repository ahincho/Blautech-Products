package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.controllers;

import com.blautech.ecommerce.products.application.ports.in.CheckProductsExistByIdsUseCase;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.CheckResponse;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.ProductIdsRequest;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.mappers.CommonRestMapper;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class CheckProductsExistByIdsRestController {
    private final CheckProductsExistByIdsUseCase checkProductsExistByIdsUseCase;
    public CheckProductsExistByIdsRestController(CheckProductsExistByIdsUseCase checkProductsExistByIdsUseCase) {
        this.checkProductsExistByIdsUseCase = checkProductsExistByIdsUseCase;
    }
    @PostMapping(value = "/ids")
    public ResponseEntity<CheckResponse> checkProductsExistByIds(
        @RequestBody @Valid ProductIdsRequest productIdsRequest
    ) {
        List<Long> ids = productIdsRequest.getIds();
        Boolean existsByIds = this.checkProductsExistByIdsUseCase.execute(ids);
        return ResponseEntity.ok(CommonRestMapper.boleanToCheckResponse(existsByIds));
    }
}
