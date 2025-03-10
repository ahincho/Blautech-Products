package com.blautech.ecommerce.products.application.services;

import com.blautech.ecommerce.products.application.ports.in.FindProductsByIdsUseCase;
import com.blautech.ecommerce.products.application.ports.out.ProductPersistencePort;
import com.blautech.ecommerce.products.domain.exceptions.ProductNotFoundException;
import com.blautech.ecommerce.products.domain.models.Product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FindProductsByIdsDefaultService implements FindProductsByIdsUseCase {
    private final ProductPersistencePort productPersistencePort;
    public FindProductsByIdsDefaultService(ProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }
    @Override
    public List<Product> execute(List<Long> productIds) throws ProductNotFoundException {
        List<Product> products = this.productPersistencePort.findProductsByIds(productIds);
        Set<Long> foundIds = products.stream()
            .map(Product::getId)
            .collect(Collectors.toSet());
        List<Long> notFoundIds = productIds.stream()
            .filter(id -> !foundIds.contains(id))
            .toList();
        if (!notFoundIds.isEmpty()) {
            throw new ProductNotFoundException(String.format("Products not found for IDs: %s", notFoundIds));
        }
        return products;
    }
}
