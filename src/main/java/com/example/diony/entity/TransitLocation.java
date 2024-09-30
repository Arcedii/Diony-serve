package com.example.diony.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "transit_locations")
public class TransitLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private String time;

    // Конструкторы
    public TransitLocation() {}

    public TransitLocation(String location, String time) {
        this.location = location;
        this.time = time;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
