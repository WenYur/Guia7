package com.cursosena.VeciCocina.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursosena.VeciCocina.Entities.Tienda;
import com.cursosena.VeciCocina.Repository.TiendaRepository;

@Service
public class TiendaService {

    @Autowired
    TiendaRepository tiendaRepository;

    public List<Tienda> getAllTiendas(){
        return tiendaRepository.findAll();
    }

    public Tienda createTienda (Tienda tienda){
        return tiendaRepository.save(tienda);
    }
        public Tienda buscarPorId(Integer id) {
        return tiendaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void deleteTienda(Integer id){
        tiendaRepository.deleteById(id);
    }

}