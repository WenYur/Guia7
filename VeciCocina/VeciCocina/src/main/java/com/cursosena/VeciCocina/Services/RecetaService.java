package com.cursosena.VeciCocina.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursosena.VeciCocina.Entities.Receta;
import com.cursosena.VeciCocina.Repository.RecetaRepository;

@Service
public class RecetaService {

    @Autowired
    RecetaRepository recetaRepository;

    public List<Receta> getAllRecetas(){
        return recetaRepository.findAll();
    }

    public Receta createReceta (Receta receta){
        return recetaRepository.save(receta);
    }

    public Receta buscarPorId(Integer id) {
        return recetaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void deleteReceta(Integer id){
        recetaRepository.deleteById(id);
    }

}
