package com.example.diony.services;

import com.example.diony.entity.Passenger;
import com.example.diony.dao.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    // Метод для поиска пассажира по имени, фамилии, телефону и email
    public Passenger findPassengerByDetails(String firstName, String lastName, String phoneNumber, String email) {
        return passengerRepository.findByFirstNameAndLastNameAndPhoneNumberAndEmail(firstName, lastName, phoneNumber, email);
    }

    // Метод для создания нового пассажира
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }
}