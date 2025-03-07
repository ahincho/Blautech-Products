package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.controllers;

import com.blautech.ecommerce.products.application.ports.in.FindProductsUseCase;
import com.blautech.ecommerce.products.domain.models.PaginationResult;
import com.blautech.ecommerce.products.domain.models.Product;
import com.blautech.ecommerce.products.domain.models.ProductFilters;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.PaginationResultResponse;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.ProductQueryRequest;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.ProductResponse;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.mappers.ProductRestMapper;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class FindProductsRestController {
    private final FindProductsUseCase findProductsUseCase;
    public FindProductsRestController(FindProductsUseCase findProductsUseCase) {
        this.findProductsUseCase = findProductsUseCase;
    }
    @GetMapping
    public ResponseEntity<PaginationResultResponse<ProductResponse>> findProducts(
        @ModelAttribute @Valid ProductQueryRequest productQueryRequest
    ) {
        ProductFilters productFilters = ProductRestMapper.queryRequestToDomain(productQueryRequest);
        PaginationResult<Product> productPaginationResult = this.findProductsUseCase.execute(productFilters);
        if (productPaginationResult.getItems().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ProductRestMapper.domainPageToResponsePage(productPaginationResult));
    }
}
