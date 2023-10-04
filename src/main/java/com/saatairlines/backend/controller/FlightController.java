package com.saatairlines.backend.controller;

import com.saatairlines.backend.core.dtos.FlightDto;
import com.saatairlines.backend.core.utilities.DataResult;
import com.saatairlines.backend.core.utilities.Result;
import com.saatairlines.backend.model.Flight;
import com.saatairlines.backend.model.Route;
import com.saatairlines.backend.service.abstracts.FlightService;
import com.saatairlines.backend.service.abstracts.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/flight")
@CrossOrigin
public class FlightController {
    private FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    @GetMapping("/getall")
    public DataResult<List<Flight>> getAll(){
        return this.flightService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Flight> getById(@PathVariable long id){
        return this.flightService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody FlightDto flightDto){
        return this.flightService.add(flightDto);
    }

    @PutMapping("/update")
    public Result update(@RequestBody FlightDto flightDto, @RequestParam long flightId){
        return this.flightService.update(flightDto, flightId);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable long id){
        return this.flightService.delete(id);
    }

    @PutMapping("/setstatus")
    public Result setStatus(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date, @RequestParam long flightId){
        return this.flightService.setStatus(date, flightId);
    }

}
