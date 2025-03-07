package com.blautech.ecommerce.products.application.ports.in;

import com.blautech.ecommerce.products.domain.exceptions.ProductDuplicateException;
import com.blautech.ecommerce.products.domain.exceptions.ProductNotFoundException;
import com.blautech.ecommerce.products.domain.models.Product;

public interface UpdateOneProductUseCase {
    void execute(Long productId, Product product) throws ProductNotFoundException, ProductDuplicateException;
}
