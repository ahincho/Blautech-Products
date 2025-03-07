package com.blautech.ecommerce.products.application.services;

import com.blautech.ecommerce.products.application.ports.in.FindProductsByIdsUseCase;
import com.blautech.ecommerce.products.application.ports.out.ProductPersistencePort;
import com.blautech.ecommerce.products.domain.models.Product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindProductsByIdsDefaultService implements FindProductsByIdsUseCase {
    private final ProductPersistencePort productPersistencePort;
    public FindProductsByIdsDefaultService(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }
    @Override
    public List<Product> execute(List<Long> productIds) {
        return this.productPersistencePort.findProductsByIds(productIds);
    }
}
