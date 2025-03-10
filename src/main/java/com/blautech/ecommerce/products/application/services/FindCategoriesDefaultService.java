package com.blautech.ecommerce.products.application.services;

import com.blautech.ecommerce.products.application.ports.in.FindCategoriesUseCase;
import com.blautech.ecommerce.products.application.ports.out.CategoryPersistencePort;
import com.blautech.ecommerce.products.domain.models.Category;
import com.blautech.ecommerce.products.domain.models.CategoryFilters;
import com.blautech.ecommerce.products.domain.models.PaginationResult;

import org.springframework.stereotype.Service;

@Service
public class FindCategoriesDefaultService implements FindCategoriesUseCase {
    private final CategoryPersistencePort categoryPersistencePort;
    public FindCategoriesDefaultService(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }
    @Override
    public PaginationResult<Category> execute(CategoryFilters categoryFilters) {
        return this.categoryPersistencePort.findCategories(categoryFilters);
    }
}
