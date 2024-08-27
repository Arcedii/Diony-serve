package com.example.diony.Controllers;


import com.example.diony.entity.Route;
import com.example.diony.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rute")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/adauga")
    public Route adaugaRoute(@RequestBody Route route) {
        return routeService.adaugaRoute(route);
    }

    @PutMapping("/modifica/{id}")
    public ResponseEntity<Route> modificaRoute(@PathVariable Long id, @RequestBody Route route) {
        Route updatedRoute = routeService.modificaRoute(id, route);
        if (updatedRoute == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedRoute);
    }

    @DeleteMapping("/sterge/{id}")
    public ResponseEntity<Void> stergeRoute(@PathVariable Long id) {
        routeService.stergeRoute(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Route> getRouteById(@PathVariable Long id) {
        Route route = routeService.getRouteById(id);
        if (route == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(route);
    }

    @GetMapping("/get")
    public List<Route> getToateRutele() {
        return routeService.getToateRutele();
    }
}
