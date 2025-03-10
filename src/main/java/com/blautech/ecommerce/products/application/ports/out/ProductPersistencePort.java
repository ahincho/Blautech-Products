package com.blautech.ecommerce.products.application.ports.out;

import com.blautech.ecommerce.products.domain.models.PaginationResult;
import com.blautech.ecommerce.products.domain.models.Product;
import com.blautech.ecommerce.products.domain.models.ProductFilters;

import java.util.List;
import java.util.Optional;

public interface ProductPersistencePort {
    Product createOneProduct(Product product);
    PaginationResult<Product> findProducts(ProductFilters productFilters);
    List<Product> findProductsByIds(List<Long> productIds);
    Optional<Product> findOneProductById(Long productId);
    boolean existsProductsByIds(List<Long> productIds);
    boolean existsOneProductById(Long productId);
    boolean existsOneProductByName(String productName);
    void updateOneProductById(Long productId, Product product);
    void deleteOneProductById(Long productId);
}
