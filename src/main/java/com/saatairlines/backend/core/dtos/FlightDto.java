package com.saatairlines.backend.core.dtos;

import com.saatairlines.backend.model.Flight;
import lombok.Data;

import java.util.Date;

@Data
public class FlightDto {
    String flightNumber;
    long routeId;
    float price;
    Date departureTime;
    Date arrivalTime;
    int capacity;
}
