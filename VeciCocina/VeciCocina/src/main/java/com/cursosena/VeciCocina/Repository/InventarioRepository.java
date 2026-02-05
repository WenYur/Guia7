package com.cursosena.VeciCocina.Repository;

import com.cursosena.VeciCocina.Entities.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Integer> {
    
}