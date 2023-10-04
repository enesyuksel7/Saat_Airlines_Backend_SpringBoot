package com.saatairlines.backend.core.mapper;

import com.saatairlines.backend.core.dtos.RouteDto;
import com.saatairlines.backend.model.Airport;
import com.saatairlines.backend.model.Route;
import com.saatairlines.backend.repository.AirportDao;
import com.saatairlines.backend.service.abstracts.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class RouteDtoMapper{

    private AirportService airportService;

    @Autowired
    public RouteDtoMapper(AirportService airportService){
        this.airportService = airportService;
    }

    public Route apply(RouteDto routeDto) {
        Route route = new Route();
        route.setSource(this.airportService.getById(routeDto.getSourceId()).getData());
        route.setDestination(this.airportService.getById(routeDto.getDestinationId()).getData());
        route.setDistanceinmiles(routeDto.getDistanceInMiles());
        return route;
    }
}
