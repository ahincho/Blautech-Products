package com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.mappers;

import com.blautech.ecommerce.products.domain.models.Product;
import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.entities.ProductEntity;

public class ProductJpaMapper {
    private ProductJpaMapper() {}
    public static ProductEntity domainToEntity(Product product) {
        return ProductEntity.builder()
            .id(product.getId() == null ? null : product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .quantity(product.getQuantity())
            .image(product.getImage())
            .createdAt(product.getCreatedAt() == null ? null : product.getCreatedAt())
            .updatedAt(product.getUpdatedAt() == null ? null : product.getUpdatedAt())
            .build();
    }
    public static Product entityToDomain(ProductEntity productEntity) {
        return Product.builder()
            .id(productEntity.getId())
            .name(productEntity.getName())
            .description(productEntity.getDescription())
            .price(productEntity.getPrice())
            .quantity(productEntity.getQuantity())
            .image(productEntity.getImage())
            .createdAt(productEntity.getCreatedAt())
            .updatedAt(productEntity.getUpdatedAt())
            .build();
    }
}
