package com.cursosena.VeciCocina.Repository;

import com.cursosena.VeciCocina.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}