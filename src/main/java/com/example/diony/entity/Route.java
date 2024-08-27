package com.example.diony.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Oras orasPlecare;

    @Enumerated(EnumType.STRING)
    private Oras orasVenire;

    private String locPlecare;
    private String locVenire;

    private LocalDateTime oraPlecare;
    private LocalDateTime oraVenire;
    private Integer numarOreDrum;

    private BigDecimal pretBilet;

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Oras getOrasPlecare() { return orasPlecare; }
    public void setOrasPlecare(Oras orasPlecare) { this.orasPlecare = orasPlecare; }

    public Oras getOrasVenire() { return orasVenire; }
    public void setOrasVenire(Oras orasVenire) { this.orasVenire = orasVenire; }

    public String getLocPlecare() { return locPlecare; }
    public void setLocPlecare(String locPlecare) { this.locPlecare = locPlecare; }

    public String getLocVenire() { return locVenire; }
    public void setLocVenire(String locVenire) { this.locVenire = locVenire; }

    public LocalDateTime getOraPlecare() { return oraPlecare; }
    public void setOraPlecare(LocalDateTime oraPlecare) { this.oraPlecare = oraPlecare; }

    public LocalDateTime getOraVenire() { return oraVenire; }
    public void setOraVenire(LocalDateTime oraVenire) { this.oraVenire = oraVenire; }

    public Integer getNumarOreDrum() { return numarOreDrum; }
    public void setNumarOreDrum(Integer numarOreDrum) { this.numarOreDrum = numarOreDrum; }

    public BigDecimal getPretBilet() { return pretBilet; }
    public void setPretBilet(BigDecimal pretBilet) { this.pretBilet = pretBilet; }
}