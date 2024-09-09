package com.example.diony;

import com.example.diony.entity.Bilet;
import com.example.diony.entity.Passenger;

public class BiletRequest {
    private Bilet
            bilet;
    private Passenger
            passenger;

    // Геттеры и сеттеры
    public Bilet getBilet() {
        return bilet;
    }

    public void setBilet(Bilet bilet) {
        this.bilet = bilet;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
