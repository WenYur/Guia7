package com.cursosena.VeciCocina.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursosena.VeciCocina.Entities.Ingrediente;
import com.cursosena.VeciCocina.Repository.IngredienteRepository;

@Service
public class IngredienteService {

    @Autowired
    IngredienteRepository ingredienteRepository;

    public List<Ingrediente> getAllIngredientes(){
        return ingredienteRepository.findAll();
    }

    public Ingrediente createIngrediente (Ingrediente ingrediente){
        return ingredienteRepository.save(ingrediente);
    }

       public Ingrediente buscarPorId(Integer id) {
        return ingredienteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void deleteIngrediente(Integer id){
        ingredienteRepository.deleteById(id);
    }

}