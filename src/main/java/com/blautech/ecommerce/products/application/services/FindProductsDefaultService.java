package com.blautech.ecommerce.products.application.services;

import com.blautech.ecommerce.products.application.ports.in.FindProductsUseCase;
import com.blautech.ecommerce.products.application.ports.out.ProductPersistencePort;
import com.blautech.ecommerce.products.domain.models.PaginationResult;
import com.blautech.ecommerce.products.domain.models.Product;
import com.blautech.ecommerce.products.domain.models.ProductFilters;

import org.springframework.stereotype.Service;

@Service
public class FindProductsDefaultService implements FindProductsUseCase {
    private final ProductPersistencePort productPersistencePort;
    public FindProductsDefaultService(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }
    @Override
    public PaginationResult<Product> execute(ProductFilters productFilters) {
        return this.productPersistencePort.findProducts(productFilters);
    }
}
