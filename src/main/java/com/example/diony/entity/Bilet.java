package com.example.diony.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bilete")
public class Bilet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromLocation;
    private String toLocation;
    private LocalDate departureDate;
    private LocalDate returnDate;
    private int passengers;

    private String departureTime;  // Время отправления
    private String departurePlace; // Место отправления
    private String price;          // Цена

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    @JsonIgnore // Убедись, что это не блокирует передачу данных, если используется неправильно
    private Passenger passenger;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private String returnRouteFrom;   // Пункт отправления маршрута возврата
    private String returnRouteTo;     // Пункт назначения маршрута возврата
    private LocalDate returnRouteDate;     // Дата возврата
    private String returnDepartureTime; // Время отправления маршрута возврата

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        System.out.println("CreatedAt set to: " + this.createdAt);
    }


    // Getters и Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDeparturePlace() {
        return departurePlace;
    }

    public void setDeparturePlace(String departurePlace) {
        this.departurePlace = departurePlace;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    // Добавьте геттер
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Добавьте сеттер (опционально, так как createdAt не должно изменяться после создания)
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


    public String getReturnRouteFrom() {
        return returnRouteFrom;
    }

    public void setReturnRouteFrom(String returnRouteFrom) {
        this.returnRouteFrom = returnRouteFrom;
    }

    public String getReturnRouteTo() {
        return returnRouteTo;
    }

    public void setReturnRouteTo(String returnRouteTo) {
        this.returnRouteTo = returnRouteTo;
    }

    public LocalDate getReturnRouteDate() {
        return returnRouteDate;
    }

    public void setReturnRouteDate(LocalDate returnRouteDate) {
        this.returnRouteDate = returnRouteDate;
    }

    public String getReturnDepartureTime() {
        return returnDepartureTime;
    }

    public void setReturnDepartureTime(String returnDepartureTime) {
        this.returnDepartureTime = returnDepartureTime;
    }
}
