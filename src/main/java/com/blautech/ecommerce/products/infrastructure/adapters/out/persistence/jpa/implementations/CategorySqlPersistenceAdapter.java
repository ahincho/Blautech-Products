package com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.implementations;

import com.blautech.ecommerce.products.application.ports.out.CategoryPersistencePort;
import com.blautech.ecommerce.products.domain.models.Category;
import com.blautech.ecommerce.products.domain.models.CategoryFilters;
import com.blautech.ecommerce.products.domain.models.PaginationResult;
import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.entities.CategoryEntity;
import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.mappers.CategoryJpaMapper;
import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.repositories.CategoryJpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class CategorySqlPersistenceAdapter implements CategoryPersistencePort {
    private final CategoryJpaRepository categoryJpaRepository;
    public CategorySqlPersistenceAdapter(CategoryJpaRepository categoryJpaRepository) {
        this.categoryJpaRepository = categoryJpaRepository;
    }
    @Override
    public PaginationResult<Category> findCategories(CategoryFilters categoryFilters) {
        Pageable pageable = CategoryJpaMapper.domainPageToEntityPage(categoryFilters);
        Page<CategoryEntity> categoryEntityPage = this.categoryJpaRepository.findAll(pageable);
        return CategoryJpaMapper.entityPageToDomainPage(categoryEntityPage);
    }
}
