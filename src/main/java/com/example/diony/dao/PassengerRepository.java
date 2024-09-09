package com.example.diony.dao;

import com.example.diony.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Passenger findByFirstNameAndLastNameAndPhoneNumberAndEmail(String firstName, String lastName, String phoneNumber, String email);
}