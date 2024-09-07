package com.example.diony.services;

import com.example.diony.entity.Bilet;
import com.example.diony.dao.BiletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiletService {

    @Autowired
    private BiletRepository biletRepository;

    // Метод для создания билета
    public Bilet createBilet(Bilet bilet) {
        return biletRepository.save(bilet);
    }

    // Метод для получения всех билетов
    public List<Bilet> getAllBilete() {
        return biletRepository.findAll();
    }
}