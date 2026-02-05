package com.cursosena.VeciCocina.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cursosena.VeciCocina.Entities.Receta;
import com.cursosena.VeciCocina.Services.RecetaService;


import java.util.List;


@RestController
@RequestMapping("/recetas")
public class RecetaController {

    @Autowired
    private RecetaService recetaService;

    @GetMapping
    public List<Receta> getAllRecetas() {
        return recetaService.getAllRecetas();
    }

    @PostMapping
    public Receta createReceta(@RequestBody Receta receta){
        return recetaService.createReceta(receta);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        recetaService.deleteReceta(id);

    }
}
