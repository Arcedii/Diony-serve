package com.example.diony.services;

import com.example.diony.entity.Passenger;
import com.example.diony.dao.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    // Метод для создания нового пассажира
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    // Метод для получения всех пассажиров
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    // Метод для поиска пассажира по ID
    public Passenger getPassengerById(Long id) {
        Optional<Passenger>
                passenger = passengerRepository.findById(id);
        return passenger.orElse(null);
    }

    // Метод для обновления пассажира
    public Passenger updatePassenger(Long id, Passenger newPassenger) {
        Passenger existingPassenger = getPassengerById(id);
        if (existingPassenger != null) {
            existingPassenger.setFirstName(newPassenger.getFirstName()); // пример, добавьте нужные поля
            existingPassenger.setLastName(newPassenger.getLastName());
            existingPassenger.setPhoneNumber(newPassenger.getPhoneNumber());
            existingPassenger.setEmail(newPassenger.getEmail());
            return passengerRepository.save(existingPassenger);
        }
        return null;
    }

    // Метод для удаления пассажира по ID
    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }

    // Метод для поиска пассажира по имени, фамилии, телефону и email
    public Passenger findPassengerByDetails(String firstName, String lastName, String phoneNumber, String email) {
        return passengerRepository.findByFirstNameAndLastNameAndPhoneNumberAndEmail(firstName, lastName, phoneNumber, email);
    }

    // Метод для получения пассажиров с билетами
    public List<Passenger> getPassengersWithTickets() {
        return passengerRepository.findAll(); // Пример, если билеты загружаются лениво
    }
}