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

}

