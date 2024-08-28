package com.example.diony.services;

import com.example.diony.entity.Bilet;
import com.example.diony.dao.BiletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BiletService {

    @Autowired
    private BiletRepository biletRepository;

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
}
