package com.example.diony.Controllers;


import com.example.diony.entity.Route;
import com.example.diony.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.findAllRoutes();
    }

    @PostMapping
    public Route addRoute(@RequestBody Route route) {
        return routeService.saveRoute(route);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id) {
        routeService.deleteRouteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Route> searchRoutes(@RequestParam String from, @RequestParam String to) {
        return routeService.findRoutes(from, to);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable Long id) {
        Route route = routeService.findById(id);
        if (route != null) {
            return ResponseEntity.ok(route);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Route> updateRoute(@PathVariable Long id, @RequestBody Route updatedRoute) {
        Route existingRoute = routeService.findById(id);
        if (existingRoute == null) {
            return ResponseEntity.notFound().build();
        }

        existingRoute.setDin(updatedRoute.getDin());
        existingRoute.setDestinatia(updatedRoute.getDestinatia());
        existingRoute.setLoculPlecarii(updatedRoute.getLoculPlecarii()); // Здесь меняем
        existingRoute.setLoculSosirii(updatedRoute.getLoculSosirii()); // Здесь меняем
        existingRoute.setPret(updatedRoute.getPret());
        existingRoute.setOraPlecarii(updatedRoute.getOraPlecarii());
        existingRoute.setOraSosirii(updatedRoute.getOraSosirii());

        // Обновляем список остановок
        existingRoute.getTransitLocations().clear();
        if (updatedRoute.getTransitLocations() != null) {
            existingRoute.getTransitLocations().addAll(updatedRoute.getTransitLocations());
        }

        Route savedRoute = routeService.saveRoute(existingRoute);
        return ResponseEntity.ok(savedRoute);
    }
}

