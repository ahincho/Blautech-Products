package com.blautech.ecommerce.products.application.ports.in;

import java.util.List;

public interface CheckProductsExistByIdsUseCase {
    boolean execute(List<Long> productIds);
}
