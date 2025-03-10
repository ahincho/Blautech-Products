package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos;

import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.annotations.ValidProductIds;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductIdsRequest {
    @NotEmpty(message = "Ids list cannot be empty")
    @Size(min = 1, max = 25, message = "Ids list must be between 1 and 25 elements")
    @ValidProductIds
    private List<Long> ids;
}
