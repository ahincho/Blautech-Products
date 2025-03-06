package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.mappers;

import com.blautech.ecommerce.products.domain.models.Product;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.CreateOneProductRequest;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.ProductResponse;

import java.time.LocalDateTime;

public class ProductRestMapper {
    private ProductRestMapper() {}
    public static Product createOneRequestToDomain(
        CreateOneProductRequest createOneProductRequest
    ) {
        return Product.builder()
            .id(null)
            .name(createOneProductRequest.getName())
            .description(createOneProductRequest.getDescription())
            .price(createOneProductRequest.getPrice())
            .quantity(createOneProductRequest.getQuantity())
            .image(createOneProductRequest.getImage())
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();
    }
    public static ProductResponse domainToResponse(Product product) {
        return ProductResponse.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .quantity(product.getQuantity())
            .image(product.getImage())
            .createdAt(product.getCreatedAt())
            .updatedAt(product.getUpdatedAt())
            .build();
    }
}
