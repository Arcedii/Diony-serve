package com.example.diony.services;


import com.example.diony.dao.RouteRepository;
import com.example.diony.entity.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Route> findAllRoutes() {
        return routeRepository.findAll();
    }

    public Route saveRoute(Route route) {
        return routeRepository.save(route);
    }


    public void deleteRouteById(Long id) {
        routeRepository.deleteById(id);
    }

    public List<Route> findRoutes(String from, String to) {
        return routeRepository.findByField1AndField2(from, to);
    }

    public Route findById(Long id) {
        return routeRepository.findById(id).orElse(null);
    }

    public Route updateRoute(Long id, Route route) {
        Route existingRoute = findById(id);
        if (existingRoute != null) {
            existingRoute.setField1(route.getField1());
            existingRoute.setField2(route.getField2());
            existingRoute.setField3(route.getField3());
            existingRoute.setField4(route.getField4());
            existingRoute.setField5(route.getField5());
            existingRoute.setStops(route.getStops()); // Обновляем остановки
            return saveRoute(existingRoute);
        }
        return null;
    }

}