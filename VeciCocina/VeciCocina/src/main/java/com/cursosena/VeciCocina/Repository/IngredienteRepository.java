package com.cursosena.VeciCocina.Repository;

import com.cursosena.VeciCocina.Entities.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
    
}
