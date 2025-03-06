package com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.implementations;

import com.blautech.ecommerce.products.application.ports.out.ProductPersistencePort;
import com.blautech.ecommerce.products.domain.models.Product;
import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.entities.ProductEntity;
import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.mappers.ProductJpaMapper;
import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.repositories.ProductJpaRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public boolean existsOneProductByName(String name) {
        return this.productJpaRepository.existsByName(name);
    }
}
