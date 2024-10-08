package com.example.crud.services;

import com.example.crud.models.Persona;
import com.example.crud.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private Repository repositorio;

    @Override
    public List<Persona> getAllPersonas() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Persona> getPersonaById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public Persona savePersona(Persona persona) {
        return repositorio.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        repositorio.deleteById(id);
    }
}
