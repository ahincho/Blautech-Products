package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.mappers;

import com.blautech.ecommerce.products.domain.models.*;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.CategoryQueryRequest;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.CategoryResponse;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.PaginationResultResponse;

import java.util.List;

public class CategoryRestMapper {
    private CategoryRestMapper() {}
    public static CategoryResponse domainToResponse(Category category) {
        return CategoryResponse.builder()
            .id(category.getId())
            .name(category.getName())
            .description(category.getDescription())
            .image(category.getImage())
            .build();
    }
    public static CategoryFilters queryRequestToDomain(CategoryQueryRequest categoryQueryRequest) {
        return CategoryFilters.builder()
            .page(
                Page.builder()
                    .number(categoryQueryRequest.getPage())
                    .size(categoryQueryRequest.getSize())
                    .build()
            )
            .build();
    }
    public static List<CategoryResponse> domainListToResponseList(List<Category> categories) {
        return categories.stream()
            .map(CategoryRestMapper::domainToResponse)
            .toList();
    }
    public static PaginationResultResponse<CategoryResponse> domainPageToResponsePage(PaginationResult<Category> paginationResult) {
        return PaginationResultResponse.<CategoryResponse>builder()
            .totalItems(paginationResult.getTotalItems())
            .totalPages(paginationResult.getTotalPages())
            .currentPage(paginationResult.getCurrentPage())
            .pageSize(paginationResult.getPageSize())
            .hasNextPage(paginationResult.getHasNextPage())
            .items(domainListToResponseList(paginationResult.getItems()))
            .build();
    }
}
