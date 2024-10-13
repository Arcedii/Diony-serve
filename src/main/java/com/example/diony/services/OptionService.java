package com.example.diony.services;

import com.example.diony.dao.OptionRepository;
import com.example.diony.entity.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService {

    @Autowired
    private OptionRepository
            optionRepository;

    // Метод для получения всех опций
    public List<Option> getAllOptions() {
        return optionRepository.findAll();
    }

    // Метод для добавления новой опции
    public Option addOption(Option option) {
        return optionRepository.save(option);
    }

    // Метод для удаления опции по ID
    public void deleteOption(Long id) {
        optionRepository.deleteById(id);
    }
}
