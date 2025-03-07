package com.blautech.ecommerce.products.application.services;

import com.blautech.ecommerce.products.application.ports.in.DeleteOneProductUseCase;
import com.blautech.ecommerce.products.application.ports.out.ProductPersistencePort;
import com.blautech.ecommerce.products.domain.exceptions.ProductNotFoundException;

import org.springframework.stereotype.Service;

@Service
public class DeleteOneProductDefaultService implements DeleteOneProductUseCase {
    private final ProductPersistencePort productPersistencePort;
    public DeleteOneProductDefaultService(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }
    @Override
    public void execute(Long productId) throws ProductNotFoundException {
        if (!this.productPersistencePort.existsOneProductById(productId)) {
            throw new ProductNotFoundException(String.format("Product with id '%s' not found", productId));
        }
        this.productPersistencePort.deleteOneProductById(productId);
    }
}
