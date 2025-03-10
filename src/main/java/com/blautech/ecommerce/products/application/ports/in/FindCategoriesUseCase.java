package com.blautech.ecommerce.products.application.ports.in;

import com.blautech.ecommerce.products.domain.models.Category;
import com.blautech.ecommerce.products.domain.models.CategoryFilters;
import com.blautech.ecommerce.products.domain.models.PaginationResult;

public interface FindCategoriesUseCase {
    PaginationResult<Category> execute(CategoryFilters categoryFilters);
}
