package com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.implementations;

import com.blautech.ecommerce.products.application.ports.out.ProductPersistencePort;
import com.blautech.ecommerce.products.domain.models.PaginationResult;
import com.blautech.ecommerce.products.domain.models.Product;
import com.blautech.ecommerce.products.domain.models.ProductFilters;
import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.entities.ProductEntity;
import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.mappers.ProductJpaMapper;
import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.repositories.ProductJpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductSqlPersistenceAdapter implements ProductPersistencePort {
    private final ProductJpaRepository productJpaRepository;
    public ProductSqlPersistenceAdapter(ProductJpaRepository productJpaRepository) {
        this.productJpaRepository = productJpaRepository;
    }
    @Override
    @Transactional
    public Product createOneProduct(Product product) {
        ProductEntity productEntity = ProductJpaMapper.domainToEntity(product);
        ProductEntity savedProductEntity = productJpaRepository.save(productEntity);
        return ProductJpaMapper.entityToDomain(savedProductEntity);
    }
    @Override
    public PaginationResult<Product> findProducts(ProductFilters productFilters) {
        return null;
    }
    @Override
    public List<Product> findProductsByIds(List<Long> productIds) {
        return List.of();
    }
    @Override
    public Optional<Product> findOneProductById(Long productId) {
        return Optional.empty();
    }
    @Override
    public boolean existsProductsByIds(List<Long> productIds) {
        return false;
    }
    @Override
    public boolean existsOneProductById(Long productId) {
        return false;
    }
    @Override
    public boolean existsOneProductByName(String productName) {
        return this.productJpaRepository.existsByName(productName);
    }
    @Override
    public void updateOneProductById(Long productId, Product product) {

    }
    @Override
    public void deleteOneProductById(Long productId) {

    }
}
