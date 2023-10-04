package com.saatairlines.backend.service.concretes;

import com.saatairlines.backend.core.utilities.DataResult;
import com.saatairlines.backend.core.utilities.Result;
import com.saatairlines.backend.core.utilities.SuccessDataResult;
import com.saatairlines.backend.core.utilities.SuccessResult;
import com.saatairlines.backend.model.Airport;
import com.saatairlines.backend.repository.AirportDao;
import com.saatairlines.backend.service.abstracts.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportManager implements AirportService {
    private AirportDao airportDao;

    @Autowired
    public AirportManager(AirportDao airportDao){
        this.airportDao = airportDao;
    }

    @Override
    public DataResult<List<Airport>> getAll() {
        return new SuccessDataResult<List<Airport>>(this.airportDao.findAll(), "Tüm veriler getirildi.");
    }

    @Override
    public DataResult<Airport> getById(long id) {
        return new SuccessDataResult<Airport>(this.airportDao.getById(id), "İstenilen veri getirildi.");
    }

    @Override
    public Result add(Airport entity) {
        this.airportDao.save(entity);
        return new SuccessResult("Ekleme başarılı");
    }

    @Override
    public Result update(Airport entity) {
        this.airportDao.save(entity);
        return new SuccessResult("Güncelleme başarılı");
    }

    @Override
    public Result delete(long id) {
        this.airportDao.deleteById(id);
        return new SuccessResult("Silme başarılı.");
    }
}
