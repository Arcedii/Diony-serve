package com.example.diony.Controllers;


import com.example.diony.entity.Route;
import com.example.diony.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

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
    public List<Route> searchRoutes(
            @RequestParam String from,
            @RequestParam String to,
            @RequestParam(required = false) String returnDate) {

        boolean isReturn = (returnDate != null && !returnDate.isEmpty());
        return routeService.findAndCalculateRoutes(from, to, isReturn);
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

        // ОБНОВЛЯЕМ visible
        existingRoute.setVisible(updatedRoute.isVisible());

        Route savedRoute = routeService.saveRoute(existingRoute);
        return ResponseEntity.ok(savedRoute);
    }
    // Новый метод для обновления исключенных дат
    @PutMapping("/{id}/excluded-dates")
    public ResponseEntity<Route> updateExcludedDates(
            @PathVariable Long id,
            @RequestBody List<String> newExcludedDates) {

        List<LocalDate> parsedDates = newExcludedDates.stream()
                .map(date -> LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE))
                .collect(Collectors.toList());

        Route route = routeService.findById(id);
        if (route == null) {
            return ResponseEntity.notFound().build();
        }

        route.setExcludedDates(parsedDates);
        Route updatedRoute = routeService.saveRoute(route);

        return ResponseEntity.ok(updatedRoute);
    }



    // Метод для получения исключённых дат
    @GetMapping("/{id}/excluded-dates")
    public ResponseEntity<List<String>> getExcludedDates(@PathVariable Long id) {
        Route route = routeService.findById(id);
        if (route == null) {
            return ResponseEntity.notFound().build();
        }

        List<String> excludedDates = route.getExcludedDates().stream()
                .map(LocalDate::toString)
                .collect(Collectors.toList());

        return ResponseEntity.ok(excludedDates);
    }


}

