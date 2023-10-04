package com.saatairlines.backend.controller;

import com.saatairlines.backend.core.utilities.DataResult;
import com.saatairlines.backend.core.utilities.Result;
import com.saatairlines.backend.model.Airport;
import com.saatairlines.backend.service.abstracts.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airport")
@CrossOrigin
public class AirportController {
    private AirportService airportService;

    @Autowired
    public AirportController(AirportService airportService){
        this.airportService = airportService;
    }

    @GetMapping("/getall")
    public DataResult<List<Airport>> getAll(){
        return this.airportService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Airport> getById(@PathVariable long id){
        return this.airportService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Airport airport){
        return this.airportService.add(airport);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Airport airport){
        return this.airportService.update(airport);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable long id){
        return this.airportService.delete(id);
    }

}
