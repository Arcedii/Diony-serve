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

    // Метод для создания билета
    public Bilet createBilet(Bilet bilet) {
        return biletRepository.save(bilet);
    }

    // Метод для получения всех билетов
    public List<Bilet> getAllBilete() {
        return biletRepository.findAll();
    }

    // Метод для поиска билета по ID
    public Bilet getBiletById(Long id) {
        Optional<Bilet>
                bilet = biletRepository.findById(id);
        return bilet.orElse(null);
    }

    // Метод для обновления билета
    public Bilet updateBilet(Long id, Bilet newBilet) {
        Bilet existingBilet = getBiletById(id);
        if (existingBilet != null) {
            // Обновляем поля, связанные с маршрутом
            existingBilet.setFromLocation(newBilet.getFromLocation());
            existingBilet.setToLocation(newBilet.getToLocation());
            existingBilet.setDepartureDate(newBilet.getDepartureDate());
            existingBilet.setReturnDate(newBilet.getReturnDate());
            existingBilet.setDepartureTime(newBilet.getDepartureTime());
            existingBilet.setDeparturePlace(newBilet.getDeparturePlace());
            existingBilet.setPrice(newBilet.getPrice());
            existingBilet.setPassengers(newBilet.getPassengers());
            existingBilet.setPassenger(newBilet.getPassenger());

            return biletRepository.save(existingBilet);
        }
        return null;
    }


    // Метод для удаления билета по ID
    public void deleteBilet(Long id) {
        biletRepository.deleteById(id);
    }
}