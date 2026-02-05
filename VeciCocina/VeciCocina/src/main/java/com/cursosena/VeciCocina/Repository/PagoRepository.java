package com.cursosena.VeciCocina.Repository;

import com.cursosena.VeciCocina.Entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository<Pago, Integer> {
    
}