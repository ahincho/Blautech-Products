package com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.mappers;

import com.blautech.ecommerce.products.domain.models.Category;
import com.blautech.ecommerce.products.domain.models.CategoryFilters;
import com.blautech.ecommerce.products.domain.models.PaginationResult;
import com.blautech.ecommerce.products.domain.models.ProductFilters;
import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.entities.CategoryEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class CategoryJpaMapper {
    private CategoryJpaMapper() {}
    public static Category entityToDomain(CategoryEntity categoryEntity) {
        return Category.builder()
            .id(categoryEntity.getId())
            .name(categoryEntity.getName())
            .description(categoryEntity.getDescription())
            .image(categoryEntity.getImage())
            .build();
    }
    public static List<Category> entityListToDomainList(List<CategoryEntity> categoryEntities) {
        return categoryEntities.stream()
            .map(CategoryJpaMapper::entityToDomain)
            .toList();
    }
    public static PaginationResult<Category> entityPageToDomainPage(Page<CategoryEntity> categoryEntityPage) {
        return PaginationResult.<Category>builder()
            .totalItems(categoryEntityPage.getTotalElements())
            .totalPages(categoryEntityPage.getTotalPages())
            .currentPage(categoryEntityPage.getNumber())
            .pageSize(categoryEntityPage.getSize())
            .hasNextPage(categoryEntityPage.hasNext())
            .items(
                categoryEntityPage.getContent().stream()
                    .map(CategoryJpaMapper::entityToDomain)
                    .toList()
            )
            .build();
    }
    public static Pageable domainPageToEntityPage(CategoryFilters categoryFilters) {
        return PageRequest.of(
            categoryFilters.getPage().getNumber(),
            categoryFilters.getPage().getSize(),
            Sort.by(Sort.Direction.ASC, "id")
        );
    }
}
