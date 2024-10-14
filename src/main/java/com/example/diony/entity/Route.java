package com.example.diony.entity;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String din;

    @NotNull
    private String destinatia;

    @NotNull
    private String oraPlecarii;

    @NotNull
    private String loculPlecarii;

    @NotNull
    private String pret;

    @NotNull
    private String oraSosirii;

    @NotNull
    private String loculSosirii;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "route_id")
    private List<TransitLocation> transitLocations;

    @NotNull
    private boolean visible = true; // По умолчанию true

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

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}