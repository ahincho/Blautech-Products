package com.blautech.ecommerce.products.application.services;

import com.blautech.ecommerce.products.application.ports.in.CheckProductExistsByIdUseCase;
import com.blautech.ecommerce.products.application.ports.out.ProductPersistencePort;

import org.springframework.stereotype.Service;

@Service
public class CheckProductExistsByIdDefaultService implements CheckProductExistsByIdUseCase {
    private final ProductPersistencePort productPersistencePort;
    public CheckProductExistsByIdDefaultService(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }
    @Override
    public boolean execute(Long productId) {
        return this.productPersistencePort.existsOneProductById(productId);
    }
}
