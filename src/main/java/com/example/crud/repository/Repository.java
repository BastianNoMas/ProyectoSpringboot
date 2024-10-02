package com.example.crud.repository;

import com.example.crud.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Repository extends JpaRepository <Persona, Long> {
    
}
