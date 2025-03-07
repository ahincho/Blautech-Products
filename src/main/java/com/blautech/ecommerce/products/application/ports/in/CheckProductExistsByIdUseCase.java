package com.blautech.ecommerce.products.application.ports.in;

public interface CheckProductExistsByIdUseCase {
    boolean execute(Long productId);
}
