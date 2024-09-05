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
}