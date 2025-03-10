package com.blautech.ecommerce.products.application.services;

import com.blautech.ecommerce.products.application.ports.in.FindOneProductUseCase;
import com.blautech.ecommerce.products.application.ports.out.ProductPersistencePort;
import com.blautech.ecommerce.products.domain.exceptions.ProductNotFoundException;
import com.blautech.ecommerce.products.domain.models.Product;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindOneProductDefaultService implements FindOneProductUseCase {
    private final ProductPersistencePort productPersistencePort;
    public FindOneProductDefaultService(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }
    @Override
    public Product execute(Long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = this.productPersistencePort.findOneProductById(productId);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(String.format("Product with id '%s' not found", productId));
        }
        return optionalProduct.get();
    }
}
