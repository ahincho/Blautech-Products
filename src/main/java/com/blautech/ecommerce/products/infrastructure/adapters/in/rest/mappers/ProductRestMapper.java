package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.mappers;

import com.blautech.ecommerce.products.domain.models.Page;
import com.blautech.ecommerce.products.domain.models.PaginationResult;
import com.blautech.ecommerce.products.domain.models.Product;
import com.blautech.ecommerce.products.domain.models.ProductFilters;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.CreateOneProductRequest;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.PaginationResultResponse;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.ProductQueryRequest;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.ProductResponse;

import java.time.LocalDateTime;
import java.util.List;

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
    public static ProductFilters queryRequestToDomain(ProductQueryRequest productQueryRequest) {
        return ProductFilters.builder()
            .page(
                Page.builder()
                    .number(productQueryRequest.getPage())
                    .size(productQueryRequest.getSize())
                    .build()
            )
            .build();
    }
    public static List<ProductResponse> domainListToResponseList(List<Product> products) {
        return products.stream()
            .map(ProductRestMapper::domainToResponse)
            .toList();
    }
    public static PaginationResultResponse<ProductResponse> domainPageToResponsePage(PaginationResult<Product> paginationResult) {
        return PaginationResultResponse.<ProductResponse>builder()
            .totalItems(paginationResult.getTotalItems())
            .totalPages(paginationResult.getTotalPages())
            .currentPage(paginationResult.getCurrentPage())
            .pageSize(paginationResult.getPageSize())
            .hasNextPage(paginationResult.getHasNextPage())
            .items(domainListToResponseList(paginationResult.getItems()))
            .build();
    }
}
