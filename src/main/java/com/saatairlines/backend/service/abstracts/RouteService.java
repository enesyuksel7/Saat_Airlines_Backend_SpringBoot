package com.saatairlines.backend.service.abstracts;

import com.saatairlines.backend.core.dtos.RouteDto;
import com.saatairlines.backend.core.utilities.DataResult;
import com.saatairlines.backend.core.utilities.Result;
import com.saatairlines.backend.model.Airport;
import com.saatairlines.backend.model.Route;

import java.util.List;

public interface RouteService {
    Result add(RouteDto routeDto);

    DataResult<List<Route>> getAll();

    DataResult<Route> getById(long id);

    Result update(RouteDto routeDto, long routeId);

    Result delete(long id);
}
