package com.saatairlines.backend.service.concretes;

import com.saatairlines.backend.core.dtos.RouteDto;
import com.saatairlines.backend.core.mapper.RouteDtoMapper;
import com.saatairlines.backend.core.utilities.DataResult;
import com.saatairlines.backend.core.utilities.Result;
import com.saatairlines.backend.core.utilities.SuccessDataResult;
import com.saatairlines.backend.core.utilities.SuccessResult;
import com.saatairlines.backend.model.Route;
import com.saatairlines.backend.repository.RouteDao;
import com.saatairlines.backend.service.abstracts.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteManager implements RouteService {

    private RouteDao routeDao;
    private RouteDtoMapper routeDtoMapper;

    @Autowired
    public RouteManager(RouteDao routeDao, RouteDtoMapper routeDtoMapper){

        this.routeDao = routeDao;
        this.routeDtoMapper = routeDtoMapper;
    }

    @Override
    public Result add(RouteDto routeDto) {
        this.routeDao.save(this.routeDtoMapper.apply(routeDto));
        return new SuccessResult("Ekleme başarılı.");
    }

    @Override
    public DataResult<List<Route>> getAll() {
        return new SuccessDataResult<List<Route>>(this.routeDao.findAll(),"Tümü listelendi.");
    }

    @Override
    public DataResult<Route> getById(long id) {
        return new SuccessDataResult<Route>(this.routeDao.getById(id),"İstenilen veri getirildi.");
    }

    @Override
    public Result update(RouteDto routeDto, long routeId) {
        Route route = this.routeDtoMapper.apply(routeDto);
        route.setId(routeId);
        this.routeDao.save(route);
        return new SuccessResult("Güncelleme başarılı.");
    }

    @Override
    public Result delete(long id) {
        this.routeDao.deleteById(id);
        return new SuccessResult("Silme başarılı.");
    }
}
