package com.saatairlines.backend.service.concretes;

import com.saatairlines.backend.core.dtos.FlightDto;
import com.saatairlines.backend.core.mapper.FlightDtoMapper;
import com.saatairlines.backend.core.utilities.DataResult;
import com.saatairlines.backend.core.utilities.Result;
import com.saatairlines.backend.core.utilities.SuccessDataResult;
import com.saatairlines.backend.core.utilities.SuccessResult;
import com.saatairlines.backend.model.Flight;
import com.saatairlines.backend.model.FlightStatusEnum;
import com.saatairlines.backend.repository.FlightDao;
import com.saatairlines.backend.service.abstracts.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightManager implements FlightService {
    private FlightDao flightDao;
    private FlightDtoMapper flightDtoMapper;

    @Autowired
    public FlightManager(FlightDao flightDao, FlightDtoMapper flightDtoMapper){

        this.flightDao = flightDao;
        this.flightDtoMapper = flightDtoMapper;
    }
    @Override
    public DataResult<List<Flight>> getAll() {
        return new SuccessDataResult<List<Flight>>(this.flightDao.findAll(), "Tüm veriler getirildi.");
    }

    @Override
    public DataResult<Flight> getById(long id) {
        return new SuccessDataResult<Flight>(this.flightDao.getById(id), "İstenilen veri getirildi.");
    }

    @Override
    public Result add(FlightDto flightDto) {

        this.flightDao.save(this.flightDtoMapper.apply(flightDto));
        return new SuccessResult("Ekleme başarılı");
    }

    @Override
    public Result update(FlightDto flightDto, long flightId) {
        Flight flight = this.flightDtoMapper.apply(flightDto);
        flight.setId(flightId);
        this.flightDao.save(flight);
        return new SuccessResult("Ekleme başarılı");
    }

    @Override
    public Result delete(long id) {
        this.flightDao.deleteById(id);
        return new SuccessResult("Silme başarılı.");
    }

    @Override
    public Result setStatus(Date date, long flightId) {

        Flight flight = getById(flightId).getData();

        if(flight.getDepartureTime().before(date)){
            flight.setStatus(FlightStatusEnum.SCHEDULED.toString());
        }
        else if(flight.getArrivalTime().after(date)){
            flight.setStatus(FlightStatusEnum.ARRIVED.toString());
        }
        else{
            flight.setStatus(FlightStatusEnum.DEPARTED.toString());
        }
        this.flightDao.save(flight);
        return new SuccessResult();
    }
}
