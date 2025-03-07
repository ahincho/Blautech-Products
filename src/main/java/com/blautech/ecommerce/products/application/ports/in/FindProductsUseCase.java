package com.blautech.ecommerce.products.application.ports.in;

import com.blautech.ecommerce.products.domain.models.PaginationResult;
import com.blautech.ecommerce.products.domain.models.Product;
import com.blautech.ecommerce.products.domain.models.ProductFilters;

public interface FindProductsUseCase {
    PaginationResult<Product> execute(ProductFilters productFilters);
}
