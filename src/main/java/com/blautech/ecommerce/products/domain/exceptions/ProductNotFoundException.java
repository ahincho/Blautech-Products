package com.blautech.ecommerce.products.domain.exceptions;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
