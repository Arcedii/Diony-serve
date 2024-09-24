package com.example.diony.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String din; // например, Din
    private String destinatia; // например, Destinatia
    private String oraPlecarii; // например, Ora plecării
    private String loculPlecarii; // например, Locul plecării
    private String pret; // например, Pret

    @ElementCollection
    @CollectionTable(name = "route_stops", joinColumns = @JoinColumn(name = "route_id"))
    @Column(name = "stop")
    private List<String> stops; // Список остановок

    // Геттеры и сеттерыц
    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDin() {
        return din;
    }

    public void setDin(String din) {
        this.din = din;
    }

    public String getDestinatia() {
        return destinatia;
    }

    public void setDestinatia(String destinatia) {
        this.destinatia = destinatia;
    }

    public String getOraPlecarii() {
        return oraPlecarii;
    }

    public void setOraPlecarii(String oraPlecarii) {
        this.oraPlecarii = oraPlecarii;
    }

    public String getLoculPlecarii() {
        return loculPlecarii;
    }

    public void setLoculPlecarii(String loculPlecarii) {
        this.loculPlecarii = loculPlecarii;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public List<String> getStops() {
        return stops;
    }

    public void setStops(List<String> stops) {
        this.stops = stops;
    }
}