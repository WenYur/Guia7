package com.cursosena.VeciCocina.Repository;

import com.cursosena.VeciCocina.Entities.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetaRepository extends JpaRepository<Receta, Integer> {
    
}
