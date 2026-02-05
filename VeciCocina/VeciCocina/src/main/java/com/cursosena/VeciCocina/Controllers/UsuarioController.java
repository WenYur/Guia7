package com.cursosena.VeciCocina.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cursosena.VeciCocina.Entities.Usuario;
import com.cursosena.VeciCocina.Entities.Receta;
import com.cursosena.VeciCocina.Entities.Transporte;
import com.cursosena.VeciCocina.Services.UsuarioService;
import com.cursosena.VeciCocina.Services.RecetaService;
import com.cursosena.VeciCocina.Services.TransporteService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RecetaService recetaService;
       
    @Autowired
    private TransporteService transporteService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        //return usuarioService.createUsuario(usuario);
        return usuarioService.guardarUsuario(usuario);
    }

    @PatchMapping("/{usuarioId}/receta/{recetaId}")
    public ResponseEntity<Usuario> asignarReceta(
        @PathVariable Integer usuarioId,
        @PathVariable Integer recetaId) {

    Usuario usuario = usuarioService.buscarPorId(usuarioId);
    Receta receta = recetaService.buscarPorId(recetaId);
    // 🔗 Asignar la relación
    usuario.setReceta(receta);
    usuarioService.createUsuario(usuario);
    return ResponseEntity.ok(usuario);
    }

    @PatchMapping("/{usuarioId}/transporte/{transporteId}")
    public ResponseEntity<Usuario> asignarTransporte(
        @PathVariable Integer usuarioId,
        @PathVariable Integer transporteId) {

    Usuario usuario = usuarioService.buscarPorId(usuarioId);
    Transporte transporte = transporteService.buscarPorId(transporteId);
    // 🔗 Asignar la relación
    usuario.setTransporte(transporte);
    usuarioService.createUsuario(usuario);
    return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        usuarioService.deleteUsuario(id);

    }
}
