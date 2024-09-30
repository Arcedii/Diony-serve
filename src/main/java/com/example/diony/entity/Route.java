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
    private String oraSosirii;  // Поле для времени прибытия
    private String loculSosirii;  // Поле для места прибытия

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "route_id")
    private List<TransitLocation> transitLocations;

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

    public String getOraSosirii() {
        return oraSosirii;
    }

    public void setOraSosirii(String oraSosirii) {
        this.oraSosirii = oraSosirii;
    }

    public String getLoculSosirii() {
        return loculSosirii;
    }

    public void setLoculSosirii(String loculSosirii) {
        this.loculSosirii = loculSosirii;
    }

    public List<TransitLocation> getTransitLocations() {
        return transitLocations;
    }

    public void setTransitLocations(List<TransitLocation> transitLocations) {
        this.transitLocations = transitLocations;
    }
}