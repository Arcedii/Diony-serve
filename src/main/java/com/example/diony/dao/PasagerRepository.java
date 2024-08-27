package com.example.diony.dao;

import com.example.diony.entity.Pasager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasagerRepository extends JpaRepository<Pasager, Long> {
}
