package com.blautech.ecommerce.products.application.services;

import com.blautech.ecommerce.products.application.ports.in.CreateOneProductUseCase;
import com.blautech.ecommerce.products.application.ports.out.ProductPersistencePort;
import com.blautech.ecommerce.products.domain.exceptions.ProductDuplicateException;
import com.blautech.ecommerce.products.domain.models.Product;

import org.springframework.stereotype.Service;

@Service
public class CreateOneProductDefaultService implements CreateOneProductUseCase {
    private final ProductPersistencePort productPersistencePort;
    public CreateOneProductDefaultService(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }
    @Override
    public Product execute(Product product) throws ProductDuplicateException {
        if (this.productPersistencePort.existsOneProductByName(product.getName())) {
            throw new ProductDuplicateException("Product with name '" + product.getName() + "' already exists");
        }
        return this.productPersistencePort.createOneProduct(product);
    }
}
