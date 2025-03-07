package com.blautech.ecommerce.products.application.ports.in;

import com.blautech.ecommerce.products.domain.exceptions.ProductNotFoundException;
import com.blautech.ecommerce.products.domain.models.Product;

import java.util.List;

public interface FindProductsByIdsUseCase {
    List<Product> execute(List<Long> productIds) throws ProductNotFoundException;
}
