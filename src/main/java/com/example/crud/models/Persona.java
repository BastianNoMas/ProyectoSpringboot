package com.example.crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;
    
    @Column
    @Getter
    @Setter
    private String nombre;
        
    @Column
    @Getter
    @Setter
    private String telefono;
    
    @Column
    @Getter
    @Setter
    private String correoElectronico;

    @Column
    @Getter
    @Setter
    private String comuna;

    @Column
    @Getter
    @Setter
    private String direccion;
}
