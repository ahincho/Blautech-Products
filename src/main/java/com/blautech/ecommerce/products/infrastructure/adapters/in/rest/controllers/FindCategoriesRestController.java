package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.controllers;

import com.blautech.ecommerce.products.application.ports.in.FindCategoriesUseCase;
import com.blautech.ecommerce.products.domain.models.Category;
import com.blautech.ecommerce.products.domain.models.CategoryFilters;
import com.blautech.ecommerce.products.domain.models.PaginationResult;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.CategoryQueryRequest;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.CategoryResponse;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.PaginationResultResponse;
import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.mappers.CategoryRestMapper;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class FindCategoriesRestController {
    private final FindCategoriesUseCase findCategoriesUseCase;
    public FindCategoriesRestController(FindCategoriesUseCase findCategoriesUseCase) {
        this.findCategoriesUseCase = findCategoriesUseCase;
    }
    @GetMapping
    public ResponseEntity<PaginationResultResponse<CategoryResponse>> findCategories(
        @ModelAttribute @Valid CategoryQueryRequest categoryQueryRequest
    ) {
        CategoryFilters categoryFilters = CategoryRestMapper.queryRequestToDomain(categoryQueryRequest);
        PaginationResult<Category> categoryPaginationResult = this.findCategoriesUseCase.execute(categoryFilters);
        if (categoryPaginationResult.getItems().isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(CategoryRestMapper.domainPageToResponsePage(categoryPaginationResult));
    }
}
