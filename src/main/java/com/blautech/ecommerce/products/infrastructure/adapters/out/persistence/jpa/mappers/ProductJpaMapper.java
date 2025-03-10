package com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.mappers;

import com.blautech.ecommerce.products.domain.models.PaginationResult;
import com.blautech.ecommerce.products.domain.models.Product;
import com.blautech.ecommerce.products.domain.models.ProductFilters;
import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.entities.ProductEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

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
    public static Pageable domainPageToEntityPage(ProductFilters productFilters) {
        return PageRequest.of(
            productFilters.getPage().getNumber(),
            productFilters.getPage().getSize(),
            Sort.by(Sort.Direction.ASC, "id")
        );
    }
    public static List<Product> entityListToDomainList(List<ProductEntity> productEntities) {
        return productEntities.stream()
            .map(ProductJpaMapper::entityToDomain)
            .toList();
    }
    public static PaginationResult<Product> entityPaginationToDomainPagination(Page<ProductEntity> productEntityPage) {
        return PaginationResult.<Product>builder()
            .totalItems(productEntityPage.getTotalElements())
            .totalPages(productEntityPage.getTotalPages())
            .currentPage(productEntityPage.getNumber())
            .pageSize(productEntityPage.getSize())
            .hasNextPage(productEntityPage.hasNext())
            .items(entityListToDomainList(productEntityPage.getContent()))
            .build();
    }
}
