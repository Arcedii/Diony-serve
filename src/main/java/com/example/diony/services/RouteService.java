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
        return routeRepository.findByDinAndDestinatia(from, to);
    }

    public Route findById(Long id) {
        return routeRepository.findById(id).orElse(null);
    }

    public Route updateRoute(Long id, Route route) {
        Route existingRoute = findById(id);
        if (existingRoute != null) {
            existingRoute.setDin(route.getDin());
            existingRoute.setDestinatia(route.getDestinatia());
            existingRoute.setOraPlecarii(route.getOraPlecarii());
            existingRoute.setLoculPlecarii(route.getLoculPlecarii());
            existingRoute.setPret(route.getPret());
            existingRoute.setOraSosirii(route.getOraSosirii());
            existingRoute.setLoculSosirii(route.getLoculSosirii());

            // Обновляем список остановок
            existingRoute.getTransitLocations().clear();
            if (route.getTransitLocations() != null) {
                existingRoute.getTransitLocations().addAll(route.getTransitLocations());
            }

            return saveRoute(existingRoute);
        }
        return null;
    }
}