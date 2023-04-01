package com.dh.clinica_odontologica.service;

import com.dh.clinica_odontologica.entity.Odontologo;
import com.dh.clinica_odontologica.entity.OdontologoDTO;
import com.dh.clinica_odontologica.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class OdontologoServiceImpl implements OdontologoService {


    OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;


    @Autowired
    public OdontologoServiceImpl(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    private void guardar(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);

        odontologoRepository.save(odontologo);
    }

    @Override
    public void agregar(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);

        odontologoRepository.save(odontologo);
    }

    @Override
    public OdontologoDTO buscarPorId(Long id) {
        Odontologo odontologo = this.odontologoRepository.findById(id).orElse(null);
        OdontologoDTO odontologoDTO= null;
        if(odontologo!=null){
            odontologoDTO = mapper.convertValue(odontologo,OdontologoDTO.class);
        }
        return odontologoDTO;
    }

    @Override
    public Set<OdontologoDTO> buscarTodos() {
        List<Odontologo> odontologos= this.odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTO = new HashSet<>();
        for(Odontologo odontologo:odontologos){
            odontologoDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));
        }
        return odontologoDTO;
    }

    @Override
    public void borrar(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public void actualizar(OdontologoDTO odontologoDTO) {
        guardar(odontologoDTO);
    }
}