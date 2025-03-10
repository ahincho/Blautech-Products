package com.blautech.ecommerce.products.infrastructure.adapters.in.rest.mappers;

import com.blautech.ecommerce.products.infrastructure.adapters.in.rest.dtos.CheckResponse;

public class CommonRestMapper {
    private CommonRestMapper() {}
    public static CheckResponse boleanToCheckResponse(Boolean bool) {
        return CheckResponse.builder()
            .success(bool)
            .build();
    }
}
