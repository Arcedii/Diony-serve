package com.example.diony.Controllers;


import com.example.diony.entity.Bilet;
import com.example.diony.services.BiletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bilete")
public class BiletController {

    @Autowired
    private BiletService biletService;

    // Маршрут для создания билета
    @PostMapping
    public ResponseEntity<Bilet> createBilet(@RequestBody Bilet bilet) {
        Bilet createdBilet = biletService.createBilet(bilet);
        return ResponseEntity.ok(createdBilet);
    }

    // Маршрут для получения всех билетов
    @GetMapping
    public ResponseEntity<List<Bilet>> getAllBilete() {
        List<Bilet> bilete = biletService.getAllBilete();
        return ResponseEntity.ok(bilete);
    }

}
