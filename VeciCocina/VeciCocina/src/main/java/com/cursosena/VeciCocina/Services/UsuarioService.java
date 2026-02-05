package com.cursosena.VeciCocina.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursosena.VeciCocina.Entities.Pago;
import com.cursosena.VeciCocina.Entities.Usuario;
import com.cursosena.VeciCocina.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
 public Usuario guardarUsuario(Usuario usuario) {

        // 🔑 ENLAZAR AMBOS LADOS DE LA RELACIÓN
        if (usuario.getPagos() != null) {
            for (Pago pago : usuario.getPagos()) {
                pago.setUsuario(usuario);
            }
        }

        return usuarioRepository.save(usuario);
    }
    
    public List<Usuario> getAllUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario createUsuario (Usuario usuario){
        return usuarioRepository.save(usuario);
    }
       
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void deleteUsuario(Integer id){
        usuarioRepository.deleteById(id);
    }

}
