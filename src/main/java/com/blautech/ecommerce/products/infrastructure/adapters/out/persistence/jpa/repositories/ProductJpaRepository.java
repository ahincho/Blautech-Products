package com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.repositories;

import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.entities.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByIdIn(List<Long> ids);
    @Query("SELECT COUNT(p) FROM product p WHERE p.id IN :ids")
    long countByIdIn(@Param("ids") List<Long> ids);
    boolean existsByName(String name);
}
