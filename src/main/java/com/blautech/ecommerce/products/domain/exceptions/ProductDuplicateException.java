package com.blautech.ecommerce.products.domain.exceptions;

public class ProductDuplicateException extends Exception {
    public ProductDuplicateException(String message) {
        super(message);
    }
}
