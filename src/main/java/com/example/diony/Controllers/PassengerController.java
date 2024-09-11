package com.example.diony.Controllers;

import com.example.diony.entity.Passenger;
import com.example.diony.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        Passenger createdPassenger = passengerService.createPassenger(passenger);
        return ResponseEntity.ok(createdPassenger);
    }

    // Метод для получения пассажиров с билетами
    @GetMapping("/with-tickets")
    public ResponseEntity<List<Passenger>> getPassengersWithTickets() {
        List<Passenger> passengers = passengerService.getPassengersWithTickets();
        return ResponseEntity.ok(passengers);
    }

}
