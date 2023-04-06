package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.Domicilio;
import com.dh.clinica_odontologica.entity.DTO.DomicilioDTO;
import com.dh.clinica_odontologica.repository.DomicilioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DomicilioServiceImpl implements DomicilioService {


    private DomicilioRepository domicilioRepository;

    @Autowired
    public DomicilioServiceImpl(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }
    @Autowired
    ObjectMapper mapper;

    private void guardar(DomicilioDTO domicilioDTO){
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        domicilioRepository.save(domicilio);
    }
    @Override
    public void agregar(DomicilioDTO domicilio) {
        guardar(domicilio);
    }

    @Override
    public DomicilioDTO buscarPorId(Long id) {
        Domicilio domicilio = this.domicilioRepository.findById(id).orElse(null);
        DomicilioDTO domicilioDTO= null;
        if(domicilio!=null){
            domicilioDTO = mapper.convertValue(domicilioDTO,DomicilioDTO.class);
        }
        return domicilioDTO;
    }

    @Override
    public Set<DomicilioDTO> buscarTodos() {
        List<Domicilio> domicilios= this.domicilioRepository.findAll();
        Set<DomicilioDTO> domicilioDTOS = new HashSet<>();
        for(Domicilio domicilio:domicilios){
            domicilioDTOS.add(mapper.convertValue(domicilio,DomicilioDTO.class));
        }
        return domicilioDTOS;
    }

    @Override
    public void borrar(Long id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    public void actualizar(DomicilioDTO domicilioDTO) {
        guardar(domicilioDTO);
    }


}
