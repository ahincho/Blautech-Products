package com.blautech.ecommerce.products.application.ports.in;

import com.blautech.ecommerce.products.domain.exceptions.ProductNotFoundException;

public interface DeleteOneProductUseCase {
    void execute(Long productId) throws ProductNotFoundException;
}
