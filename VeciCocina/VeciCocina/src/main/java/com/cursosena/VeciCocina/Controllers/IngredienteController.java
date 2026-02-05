package com.cursosena.VeciCocina.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cursosena.VeciCocina.Entities.Ingrediente;
import com.cursosena.VeciCocina.Entities.Receta;
import com.cursosena.VeciCocina.Services.IngredienteService;
import com.cursosena.VeciCocina.Services.RecetaService;
import java.util.List;


@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @Autowired
    private RecetaService recetaService;

    @GetMapping
    public List<Ingrediente> getAllIngredientes() {
        return ingredienteService.getAllIngredientes();
    }

    @PostMapping
    public Ingrediente createIngrediente(@RequestBody Ingrediente ingrediente){
        return ingredienteService.createIngrediente(ingrediente);
    }

    @PatchMapping("/{ingredienteId}/receta/{recetaId}")
    public ResponseEntity<Ingrediente> asignarReceta(
        @PathVariable Integer ingredienteId,
        @PathVariable Integer recetaId) {

    Ingrediente ingrediente = ingredienteService.buscarPorId(ingredienteId);
    Receta receta = recetaService.buscarPorId(recetaId);
    // 🔗 Relación ManyToMany
    ingrediente.getRecetas().add(receta);
    ingredienteService.createIngrediente(ingrediente);
    return ResponseEntity.ok(ingrediente);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        ingredienteService.deleteIngrediente(id);

    }
}
