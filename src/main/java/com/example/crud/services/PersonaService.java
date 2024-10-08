package com.example.crud.services;

import com.example.crud.models.Persona;
import java.util.List;
import java.util.Optional;

public interface PersonaService {
    List<Persona> getAllPersonas();
    Optional<Persona> getPersonaById(Long id);
    Persona savePersona(Persona persona);
    void deletePersona(Long id);
}
