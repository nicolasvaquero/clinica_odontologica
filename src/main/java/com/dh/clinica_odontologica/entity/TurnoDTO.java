package com.dh.clinica_odontologica.entity;

public class TurnoDTO {
    private Long id;
    private Odontologo odontologo;
    private  Paciente paciente;


    public TurnoDTO(Long id, Odontologo odontologo, Paciente paciente) {
        this.id = id;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
