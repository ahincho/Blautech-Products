package com.blautech.ecommerce.products.application.services;

import com.blautech.ecommerce.products.application.ports.in.CheckProductsExistByIdsUseCase;
import com.blautech.ecommerce.products.application.ports.out.ProductPersistencePort;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckProductsExistByIdsDefaultService implements CheckProductsExistByIdsUseCase {
    private final ProductPersistencePort productPersistencePort;
    public CheckProductsExistByIdsDefaultService(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }
    @Override
    public boolean execute(List<Long> productIds) {
        return this.productPersistencePort.existsProductsByIds(productIds);
    }
}
