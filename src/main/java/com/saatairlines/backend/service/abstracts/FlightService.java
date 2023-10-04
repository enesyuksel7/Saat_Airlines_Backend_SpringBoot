package com.saatairlines.backend.service.abstracts;

import com.saatairlines.backend.core.dtos.FlightDto;
import com.saatairlines.backend.core.utilities.DataResult;
import com.saatairlines.backend.core.utilities.Result;
import com.saatairlines.backend.model.Airport;
import com.saatairlines.backend.model.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService {

    DataResult<List<Flight>> getAll();

    DataResult<Flight> getById(long id);

    Result add(FlightDto flightDto);

    Result update(FlightDto flightDto, long flightId);

    Result delete(long id);

    Result setStatus(Date date, long flightId);
}
