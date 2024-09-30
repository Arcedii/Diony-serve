package com.example.diony.dao;

import com.example.diony.entity.TransitLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransitLocationRepository extends JpaRepository<TransitLocation, Long> {
}

