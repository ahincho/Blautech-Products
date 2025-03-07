package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.controllers;

import com.blautech.ecommerce.products.application.ports.in.FindProductsByIdsUseCase;
import com.blautech.ecommerce.products.domain.models.Product;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.ProductIdsRequest;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.ProductResponse;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.mappers.ProductRestMapper;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class FindProductsByIdsRestController {
    private final FindProductsByIdsUseCase findProductsByIdsUseCase;
    public FindProductsByIdsRestController(FindProductsByIdsUseCase findProductsByIdsUseCase) {
        this.findProductsByIdsUseCase = findProductsByIdsUseCase;
    }
    @GetMapping("/ids")
    public ResponseEntity<List<ProductResponse>> findProductsByIds(
        @ModelAttribute @Valid ProductIdsRequest productIdsRequest
    ) {
        List<Product> products = null;
        try {
            products = this.findProductsByIdsUseCase.execute(productIdsRequest.getIds());
        } catch (com.blautech.ecommerce.products.domain.exceptions.ProductNotFoundException productNotFoundException) {
            throw new RuntimeException(productNotFoundException);
        }
        return ResponseEntity.ok(ProductRestMapper.domainListToResponseList(products));
    }
}
