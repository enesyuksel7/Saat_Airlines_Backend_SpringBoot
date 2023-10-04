package com.saatairlines.backend.core.mapper;

import com.saatairlines.backend.core.dtos.FlightDto;
import com.saatairlines.backend.core.dtos.RouteDto;
import com.saatairlines.backend.model.Flight;
import com.saatairlines.backend.model.FlightStatusEnum;
import com.saatairlines.backend.model.Route;
import com.saatairlines.backend.service.abstracts.AirportService;
import com.saatairlines.backend.service.abstracts.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class FlightDtoMapper {

    private RouteService routeService;

    @Autowired
    public FlightDtoMapper(RouteService routeService){
        this.routeService = routeService;
    }

    public Flight apply(FlightDto flightDto) {

        Flight flight = new Flight();

        if(flightDto.getDepartureTime().after(new Date())){
            flight.setStatus(FlightStatusEnum.SCHEDULED.toString());
        }
        else if(flightDto.getDepartureTime().before(new Date()) && flightDto.getArrivalTime().after(new Date())){
            flight.setStatus(FlightStatusEnum.DEPARTED.toString());
        }
        else if(flightDto.getArrivalTime().before(new Date())){
            flight.setStatus(FlightStatusEnum.ARRIVED.toString());
        }

        flight.setFlightNumber(flightDto.getFlightNumber());
        flight.setRoute(this.routeService.getById(flightDto.getRouteId()).getData());
        flight.setPrice(flightDto.getPrice());
        flight.setDepartureTime(flightDto.getDepartureTime());
        flight.setArrivalTime(flightDto.getArrivalTime());
        flight.setCapacity(flightDto.getCapacity());
        return flight;
    }
}
