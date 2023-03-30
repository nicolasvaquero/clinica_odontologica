package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.Odontologo;

import java.util.List;


public interface OdontologoService {
    Odontologo agregar (Odontologo odontologo);
    Odontologo buscarPorId (Long id);
    List<Odontologo> buscarTodos();
    void borrar (Long id);
    void actualizar (Odontologo odontologo);
}
