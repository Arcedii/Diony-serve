package com.example.diony.services;


import com.example.diony.entity.Route;
import com.example.diony.dao.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public Route adaugaRoute(Route route) {
        return routeRepository.save(route);
    }

    public Route modificaRoute(Long id, Route routeDetalii) {
        Optional<Route> route = routeRepository.findById(id);
        if (route.isPresent()) {
            Route routeExist = route.get();
            routeExist.setOrasPlecare(routeDetalii.getOrasPlecare());
            routeExist.setOrasVenire(routeDetalii.getOrasVenire());
            routeExist.setLocPlecare(routeDetalii.getLocPlecare());
            routeExist.setLocVenire(routeDetalii.getLocVenire());
            routeExist.setOraPlecare(routeDetalii.getOraPlecare());
            routeExist.setOraVenire(routeDetalii.getOraVenire());
            routeExist.setNumarOreDrum(routeDetalii.getNumarOreDrum());
            routeExist.setPretBilet(routeDetalii.getPretBilet());
            return routeRepository.save(routeExist);
        } else {
            return null;
        }
    }

    public void stergeRoute(Long id) {
        routeRepository.deleteById(id);
    }

    public Route getRouteById(Long id) {
        return routeRepository.findById(id).orElse(null);
    }

    public List<Route> getToateRutele() {
        return routeRepository.findAll();
    }
}
