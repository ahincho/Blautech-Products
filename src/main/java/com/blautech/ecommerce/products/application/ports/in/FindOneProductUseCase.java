package com.blautech.ecommerce.products.application.ports.in;

import com.blautech.ecommerce.products.domain.exceptions.ProductNotFoundException;
import com.blautech.ecommerce.products.domain.models.Product;

public interface FindOneProductUseCase {
    Product execute(Long productId) throws ProductNotFoundException;
}
