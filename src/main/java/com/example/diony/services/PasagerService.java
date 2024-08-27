package com.example.diony.services;

import com.example.diony.entity.Pasager;
import com.example.diony.dao.PasagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasagerService {

    @Autowired
    private PasagerRepository pasagerRepository;

    public Pasager adaugaPasager(Pasager pasager) {
        return pasagerRepository.save(pasager);
    }

    public Pasager modificaPasager(Long id, Pasager pasagerDetalii) {
        Optional<Pasager> pasager = pasagerRepository.findById(id);
        if (pasager.isPresent()) {
            Pasager pasagerExist = pasager.get();
            pasagerExist.setNume(pasagerDetalii.getNume());
            pasagerExist.setPrenume(pasagerDetalii.getPrenume());
            pasagerExist.setTelefon(pasagerDetalii.getTelefon());
            pasagerExist.setEmail(pasagerDetalii.getEmail());
            return pasagerRepository.save(pasagerExist);
        } else {
            return null;
        }
    }

    public void stergePasager(Long id) {
        pasagerRepository.deleteById(id);
    }

    public Pasager getPasagerById(Long id) {
        return pasagerRepository.findById(id).orElse(null);
    }

    public List<Pasager> getToatePasagerele() {
        return pasagerRepository.findAll();
    }
}
