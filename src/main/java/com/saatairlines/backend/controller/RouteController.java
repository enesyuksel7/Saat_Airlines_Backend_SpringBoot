package com.saatairlines.backend.controller;

import com.saatairlines.backend.core.dtos.RouteDto;
import com.saatairlines.backend.core.utilities.DataResult;
import com.saatairlines.backend.core.utilities.Result;
import com.saatairlines.backend.model.Airport;
import com.saatairlines.backend.model.Route;
import com.saatairlines.backend.service.abstracts.AirportService;
import com.saatairlines.backend.service.abstracts.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/route")
@CrossOrigin
public class RouteController {
    private RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService){
        this.routeService = routeService;
    }

    @GetMapping("/getall")
    public DataResult<List<Route>> getAll(){
        return this.routeService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<Route> getById(@PathVariable long id){
        return this.routeService.getById(id);
    }

    @PostMapping("/add")
    public Result add(@RequestBody RouteDto routeDto){
        return this.routeService.add(routeDto);
    }

    @PutMapping("/update")
    public Result update(@RequestBody RouteDto routeDto, @RequestParam long routeId){
        return this.routeService.update(routeDto, routeId);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable long id){
        return this.routeService.delete(id);
    }

}

