package com.cursosena.VeciCocina.Repository;

import com.cursosena.VeciCocina.Entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    
}
