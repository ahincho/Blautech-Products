package com.blautech.ecommerce.products.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private Integer id;
    private String name;
    private String description;
    private String image;
}
