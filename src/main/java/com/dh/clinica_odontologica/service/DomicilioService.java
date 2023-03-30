package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.Domicilio;

import java.util.List;


public interface DomicilioService {
    Domicilio agregar (Domicilio domicilio);
    Domicilio buscarPorId (Long id);
    List<Domicilio> buscarTodos();
    void borrar (Long id);
    void actualizar (Domicilio domicilio);
}
