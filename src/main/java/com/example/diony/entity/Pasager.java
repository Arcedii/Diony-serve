package com.example.diony.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pasageri")
public class Pasager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prenume;
    private String nume;
    private String telefon;
    private String email;

    @OneToMany(mappedBy = "pasager", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bilet> bilete = new ArrayList<>();

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPrenume() { return prenume; }
    public void setPrenume(String prenume) { this.prenume = prenume; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getTelefon() { return telefon; }
    public void setTelefon(String telefon) { this.telefon = telefon; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Bilet> getBilete() { return bilete; }
    public void setBilete(List<Bilet> bilete) { this.bilete = bilete; }

    // Metoda pentru a adăuga un bilet în lista
    public void adaugaBilet(Bilet bilet) {
        bilete.add(bilet);
        bilet.setPasager(this);
    }

    // Metoda pentru a elimina un bilet din lista
    public void eliminaBilet(Bilet bilet) {
        bilete.remove(bilet);
        bilet.setPasager(null);
    }
}
