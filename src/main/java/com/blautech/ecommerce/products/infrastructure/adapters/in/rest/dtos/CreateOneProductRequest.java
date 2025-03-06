package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOneProductRequest {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private String image;
}
