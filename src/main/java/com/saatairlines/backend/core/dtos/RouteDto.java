package com.saatairlines.backend.core.dtos;

import lombok.Data;

@Data
public class RouteDto {
    long sourceId;
    long destinationId;
    int distanceInMiles;
}
