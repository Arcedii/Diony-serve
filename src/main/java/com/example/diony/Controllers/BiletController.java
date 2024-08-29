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

    @PostMapping("/adauga")
    public Bilet adaugaBilet(@RequestBody Bilet bilet) {
        return biletService.adaugaBilet(bilet);
    }

    @PutMapping("/modifica/{id}")
    public ResponseEntity<Bilet> modificaBilet(@PathVariable Long id, @RequestBody Bilet bilet) {
        Bilet updatedBilet = biletService.modificaBilet(id, bilet);
        if (updatedBilet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedBilet);
    }

    @DeleteMapping("/sterge/{id}")
    public ResponseEntity<Void> stergeBilet(@PathVariable Long id) {
        biletService.stergeBilet(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Bilet> getBiletById(@PathVariable Long id) {
        Bilet bilet = biletService.getBiletById(id);
        if (bilet == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bilet);
    }

    @GetMapping("/get")
    public List<Bilet> getToateBiletele() {
        return biletService.getToateBiletele();
    }

    @GetMapping("/pasager/{pasagerId}")
    public ResponseEntity<List<Bilet>> getTicketsByPassengerId(@PathVariable Long pasagerId) {
        List<Bilet> bilete = biletService.getTicketsByPassengerId(pasagerId);
        if (bilete == null || bilete.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(bilete);
    }
}
