package com.cursosena.VeciCocina.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cursosena.VeciCocina.Entities.Ingrediente;
import com.cursosena.VeciCocina.Entities.Inventario;
import com.cursosena.VeciCocina.Entities.Tienda;
import com.cursosena.VeciCocina.Services.IngredienteService;
import com.cursosena.VeciCocina.Services.InventarioService;
import com.cursosena.VeciCocina.Services.TiendaService;

import java.util.List;


@RestController
@RequestMapping("/inventarios")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private IngredienteService ingredienteService;

     @Autowired
    private TiendaService tiendaService;

    @GetMapping
    public List<Inventario> getAllInventarios() {
        return inventarioService.getAllInventarios();
    }

    @PostMapping
    public Inventario createInventario(@RequestBody Inventario inventario){
        return inventarioService.createInventario(inventario);
    }

    @PatchMapping("/{inventarioId}/ingrediente/{ingredienteId}")
    public ResponseEntity<Inventario> asignarIngrediente(
        @PathVariable Integer inventarioId,
        @PathVariable Integer ingredienteId) {

    Inventario inventario = inventarioService.buscarPorId(inventarioId);
    Ingrediente ingrediente = ingredienteService.buscarPorId(ingredienteId);
    // 🔗 Asignar la relación
    inventario.setIngrediente(ingrediente);
    inventarioService.createInventario(inventario);
    return ResponseEntity.ok(inventario);
    }

    @PatchMapping("/{inventarioId}/tienda/{tiendaId}")
    public ResponseEntity<Inventario> asignarTienda(
        @PathVariable Integer inventarioId,
        @PathVariable Integer tiendaId) {

    Inventario inventario = inventarioService.buscarPorId(inventarioId);
    Tienda tienda = tiendaService.buscarPorId(tiendaId);
    // 🔗 Asignar la relación
    inventario.setTienda(tienda);
    inventarioService.createInventario(inventario);
    return ResponseEntity.ok(inventario);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        inventarioService.deleteInventario(id);

    }
}
