package com.dh.clinica_odontologica.entity.DTO;

import com.dh.clinica_odontologica.entity.Domicilio;

public class PacienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private Integer dni;

    private Domicilio domicilio;


    public PacienteDTO() {
    }

    public PacienteDTO(Long id, String nombre, String apellido, Integer dni, Domicilio domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
    }

    public PacienteDTO(String nombre, String apellido, Integer dni, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
