package com.example.diony.Controllers;


import com.example.diony.BiletRequest;
import com.example.diony.entity.Bilet;
import com.example.diony.entity.Passenger;
import com.example.diony.services.BiletService;
import com.example.diony.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bilete")
public class BiletController {

    @Autowired
    private BiletService biletService;

    @Autowired
    private PassengerService
            passengerService;

    // Создание билета с проверкой пассажира
    @PostMapping
    public ResponseEntity<Bilet> createBilet(@RequestBody BiletRequest biletRequest) {
        Passenger passenger = biletRequest.getPassenger();
        Bilet bilet = biletRequest.getBilet();

        // Проверка существования пассажира
        Passenger existingPassenger = passengerService.findPassengerByDetails(
                passenger.getFirstName(),
                passenger.getLastName(),
                passenger.getPhoneNumber(),
                passenger.getEmail()
        );

        if (existingPassenger != null) {
            bilet.setPassenger(existingPassenger);
        } else {
            Passenger newPassenger = passengerService.createPassenger(passenger);
            bilet.setPassenger(newPassenger);
        }

        // Устанавливаем данные маршрута возврата
        bilet.setReturnRouteFrom(biletRequest.getBilet().getReturnRouteFrom());
        bilet.setReturnRouteTo(biletRequest.getBilet().getReturnRouteTo());
        bilet.setReturnRouteDate(biletRequest.getBilet().getReturnRouteDate());
        bilet.setReturnDepartureTime(biletRequest.getBilet().getReturnDepartureTime());

        Bilet createdBilet = biletService.createBilet(bilet);
        return ResponseEntity.ok(createdBilet);
    }


}
