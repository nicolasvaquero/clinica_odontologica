package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.Domicilio;
import com.dh.clinica_odontologica.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioServiceImpl implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;


    @Override
    public Domicilio agregar(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public Domicilio buscarPorId(Long id) {
        return domicilioRepository.findById(id).orElse(null);
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return domicilioRepository.findAll();
    }

    @Override
    public void borrar(Long id) {
        domicilioRepository.delete(buscarPorId(id));
    }

    @Override
    public void actualizar(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
    }
}
