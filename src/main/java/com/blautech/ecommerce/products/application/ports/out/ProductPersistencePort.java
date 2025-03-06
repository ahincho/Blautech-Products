package com.blautech.ecommerce.products.application.ports.out;

import com.blautech.ecommerce.products.domain.models.Product;

public interface ProductPersistencePort {
    Product createOneProduct(Product product);
    boolean existsOneProductByName(String name);
}
