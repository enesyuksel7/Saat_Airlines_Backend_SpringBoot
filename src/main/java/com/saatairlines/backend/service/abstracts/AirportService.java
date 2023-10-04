package com.saatairlines.backend.service.abstracts;

import com.saatairlines.backend.core.utilities.DataResult;
import com.saatairlines.backend.core.utilities.Result;
import com.saatairlines.backend.model.Airport;

import java.util.List;

public interface AirportService{

    DataResult<List<Airport>> getAll();

    DataResult<Airport> getById(long id);

    Result add(Airport entity);

    Result update(Airport entity);

    Result delete(long id);

}
