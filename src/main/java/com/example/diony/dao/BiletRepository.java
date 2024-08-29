package com.example.diony.dao;


import com.example.diony.entity.Bilet;
import com.example.diony.entity.Pasager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiletRepository extends JpaRepository<Bilet, Long> {
    List<Bilet> findByPasagerId(Long pasagerId);
    List<Bilet> findByPasager(Pasager pasager);
}

