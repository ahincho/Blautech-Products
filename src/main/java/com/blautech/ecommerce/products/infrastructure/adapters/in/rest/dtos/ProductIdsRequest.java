package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos;

import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.annotations.ValidProductIds;

import jakarta.validation.constraints.NotEmpty;

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
    @ValidProductIds
    private List<Long> ids;
}
