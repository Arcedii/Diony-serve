package com.example.diony.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bilete")
public class Bilet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataCumparare;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pasager_id")
    private Pasager pasager;

    @OneToOne
    @JoinColumn(name = "ruta_id")
    private Route ruta;

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataCumparare() { return dataCumparare; }
    public void setDataCumparare(LocalDateTime dataCumparare) { this.dataCumparare = dataCumparare; }

    public Pasager getPasager() { return pasager; }
    public void setPasager(Pasager pasager) { this.pasager = pasager; }

    public Route getRuta() { return ruta; }
    public void setRuta(Route ruta) { this.ruta = ruta; }
}

