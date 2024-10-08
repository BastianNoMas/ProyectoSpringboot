package com.example.crud.controllers;

import com.example.crud.models.Persona;
import com.example.crud.services.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PersonaService personaService;
    
    @GetMapping("/")
    public String index() {
        return "index";  // Ahora retorna la vista "index.html"
    }

    @GetMapping("/home")
    public String home(Model model) {
        List<Persona> personas = personaService.getAllPersonas();
        model.addAttribute("personas", personas);  // Pasa la lista de personas a la vista
        model.addAttribute("persona", new Persona());  // Objeto vacío para el formulario de creación
        return "home";  // Retorna la vista "home.html"
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Persona persona) {
        personaService.savePersona(persona);
        return "redirect:/";  // Redirige a la página principal después de guardar
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Persona persona = personaService.getPersonaById(id).orElse(null);
        model.addAttribute("persona", persona);
        List<Persona> personas = personaService.getAllPersonas();
        model.addAttribute("personas", personas);  // Actualiza la lista de personas
        return "home";  // Cargar la misma página para editar
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        personaService.deletePersona(id);
        return "redirect:/";  // Redirige a la página principal después de eliminar
    }
}
