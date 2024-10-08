package com.example.crud.controllers;

import com.example.crud.models.Persona;
import com.example.crud.repository.Repository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private Repository repositorio;

    // Página principal donde se mostrará el CRUD
    @GetMapping("/")
    public String home(Model model) {
        List<Persona> personas = repositorio.findAll();
        model.addAttribute("personas", personas);  // Pasa la lista de personas a la vista
        model.addAttribute("persona", new Persona());  // Objeto vacío para el formulario de creación
        return "home";  // Retorna la vista "home.html"
    }

    // Guardar una nueva persona
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Persona persona) {
        repositorio.save(persona);
        return "redirect:/";  // Redirige a la página principal después de guardar
    }

    // Editar persona

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Persona persona = repositorio.findById(id).orElse(null);
        model.addAttribute("persona", persona);
        List<Persona> personas = repositorio.findAll();
        model.addAttribute("personas", personas);  // Actualiza la lista de personas
        return "home";  // Cargar la misma página para editar
    }

    // Eliminar persona


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        repositorio.deleteById(id);
        return "redirect:/";  // Redirige a la página principal después de eliminar
    }
}
