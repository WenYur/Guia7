package com.cursosena.VeciCocina.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursosena.VeciCocina.Entities.Transporte;
import com.cursosena.VeciCocina.Repository.TransporteRepository;

@Service
public class TransporteService {

    @Autowired
    TransporteRepository transporteRepository;

    public List<Transporte> getAllTransportes(){
        return transporteRepository.findAll();
    }

    public Transporte createTransporte (Transporte transporte){
        return transporteRepository.save(transporte);
    }

    public Transporte buscarPorId(Integer id) {
        return transporteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void deleteTransporte(Integer id){
        transporteRepository.deleteById(id);
    }

}