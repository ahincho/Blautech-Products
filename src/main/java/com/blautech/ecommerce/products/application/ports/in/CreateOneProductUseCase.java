package com.blautech.ecommerce.products.application.ports.in;

import com.blautech.ecommerce.products.domain.exceptions.ProductDuplicateException;
import com.blautech.ecommerce.products.domain.models.Product;

public interface CreateOneProductUseCase {
    Product execute(Product product) throws ProductDuplicateException;
}
