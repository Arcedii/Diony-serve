package com.example.diony.Controllers;


import com.example.diony.entity.Pasager;
import com.example.diony.services.PasagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pasageri")
public class PasagerController {

    @Autowired
    private PasagerService pasagerService;

    @PostMapping("/adauga")
    public Pasager adaugaPasager(@RequestBody Pasager pasager) {
        return pasagerService.adaugaPasager(pasager);
    }

    @PutMapping("/modifica/{id}")
    public ResponseEntity<Pasager> modificaPasager(@PathVariable Long id, @RequestBody Pasager pasager) {
        Pasager updatedPasager = pasagerService.modificaPasager(id, pasager);
        if (updatedPasager == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedPasager);
    }

    @DeleteMapping("/sterge/{id}")
    public ResponseEntity<Void> stergePasager(@PathVariable Long id) {
        pasagerService.stergePasager(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Pasager> getPasagerById(@PathVariable Long id) {
        Pasager pasager = pasagerService.getPasagerById(id);
        if (pasager == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pasager);
    }

    @GetMapping("/get")
    public List<Pasager> getToatePasagerele() {
        return pasagerService.getToatePasagerele();
    }
}
