package com.example.diony.services;

import com.example.diony.dao.PasagerRepository;
import com.example.diony.entity.Bilet;
import com.example.diony.dao.BiletRepository;
import com.example.diony.entity.Pasager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BiletService {

    @Autowired
    private BiletRepository biletRepository;

    @Autowired
    private PasagerRepository pasagerRepository;

    public Bilet adaugaBilet(Bilet bilet) {
        return biletRepository.save(bilet);
    }

    public Bilet modificaBilet(Long id, Bilet biletDetalii) {
        Optional<Bilet> bilet = biletRepository.findById(id);
        if (bilet.isPresent()) {
            Bilet biletExist = bilet.get();
            biletExist.setDataCumparare(biletDetalii.getDataCumparare());
            biletExist.setPasager(biletDetalii.getPasager());
            biletExist.setRuta(biletDetalii.getRuta());
            return biletRepository.save(biletExist);
        } else {
            return null;
        }
    }

    public void stergeBilet(Long id) {
        biletRepository.deleteById(id);
    }

    public Bilet getBiletById(Long id) {
        return biletRepository.findById(id).orElse(null);
    }

    public List<Bilet> getToateBiletele() {
        return biletRepository.findAll();
    }

    public List<Bilet> getBileteByPasagerId(Long pasagerId) {
        return biletRepository.findByPasagerId(pasagerId);
    }

    public List<Bilet> getTicketsByPassengerId(Long pasagerId) {
        Pasager
                pasager = pasagerRepository.findById(pasagerId).orElse(null);
        if (pasager != null) {
            return biletRepository.findByPasager(pasager);
        } else {
            return null; // или выбросьте исключение
        }
    }
}