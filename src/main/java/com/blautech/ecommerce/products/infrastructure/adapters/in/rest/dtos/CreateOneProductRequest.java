package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOneProductRequest {
    @NotBlank
    @Size(min = 1, max = 256)
    private String name;
    @Size(min = 1, max = 256)
    private String description;
    @Positive
    private Double price;
    @Positive
    private Integer quantity;
    @Size(min = 1, max = 256)
    private String image;
}
