package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.controllers;

import com.blautech.ecommerce.products.application.ports.in.CreateOneProductUseCase;
import com.blautech.ecommerce.products.domain.exceptions.ProductDuplicateException;
import com.blautech.ecommerce.products.domain.models.Product;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.CreateOneProductRequest;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.ProductResponse;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.mappers.ProductRestMapper;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/products")
public class CreateOneProductRestController {
    private final CreateOneProductUseCase createOneProductUseCase;
    public CreateOneProductRestController(CreateOneProductUseCase createOneProductUseCase) {
        this.createOneProductUseCase = createOneProductUseCase;
    }
    @PostMapping
    public ResponseEntity<ProductResponse> createOneProduct(
        @RequestBody @Valid CreateOneProductRequest createOneProductRequest
    ) throws ProductDuplicateException {
        Product product = ProductRestMapper.createOneRequestToDomain(createOneProductRequest);
        Product savedProduct = this.createOneProductUseCase.execute(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{productId").buildAndExpand(savedProduct.getId()).toUri();
        return ResponseEntity.created(uri).body(ProductRestMapper.domainToResponse(savedProduct));
    }
}
