package com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.repositories;

import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.entities.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    boolean existsByName(String name);
}
