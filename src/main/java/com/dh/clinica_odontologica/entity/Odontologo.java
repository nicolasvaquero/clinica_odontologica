package com.dh.clinica_odontologica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Odontologos")
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String numeroMatricula;
    private String nombre;
    private String apellido;
    @OneToMany(mappedBy = "odontologo")
    @JsonIgnore
    private Set<Turno> turnos;

    public Odontologo() {
    }

    public Odontologo(Long id, String numeroMatricula, String nombre, String apellido, Set<Turno> turnos) {
        this.id = id;
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.turnos = turnos;
    }


    public Odontologo(String numeroMatricula, String nombre, String apellido) {
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Set<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }
}
