package com.blautech.ecommerce.products.application.ports.out;

import com.blautech.ecommerce.products.domain.models.Category;
import com.blautech.ecommerce.products.domain.models.CategoryFilters;
import com.blautech.ecommerce.products.domain.models.PaginationResult;

public interface CategoryPersistencePort {
    PaginationResult<Category> findCategories(CategoryFilters categoryFilters);
}
