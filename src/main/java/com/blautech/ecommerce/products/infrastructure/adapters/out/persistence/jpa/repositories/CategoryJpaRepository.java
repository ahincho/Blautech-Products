package com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.repositories;

import com.blautech.ecommerce.products.infrastructure.adapters.out.persistence.jpa.entities.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Integer> {

}
