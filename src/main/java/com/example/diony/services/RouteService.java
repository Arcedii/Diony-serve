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
        System.out.println("Сохраняем маршрут с visible = " + route.isVisible()); // Логируем значение перед сохранением
        return routeRepository.save(route);
    }


    public void deleteRouteById(Long id) {
        routeRepository.deleteById(id);
    }

    public List<Route> findRoutes(String from, String to) {
        return routeRepository.findByDinAndDestinatia(from, to);
    }

    public List<Route> findAndCalculateRoutes(String from, String to, boolean isReturn) {
        List<Route> routes = routeRepository.findByDinAndDestinatia(from, to);

        // Логируем исходные цены до изменений
        routes.forEach(route ->
                System.out.println("Исходная цена маршрута: " + route.getPret())
        );

        if (isReturn) {
            routes.forEach(route -> {
                double originalPrice = Double.parseDouble(route.getPret());

                // Умножаем и округляем до целого числа
                int updatedPrice = (int) Math.round(originalPrice * 2);
                route.setPret(String.valueOf(updatedPrice));

                // Логируем обновленную цену
                System.out.println("Удвоенная цена маршрута (int): " + updatedPrice);
            });
        }

        return routes;
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