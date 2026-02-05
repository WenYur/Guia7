package com.cursosena.VeciCocina.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cursosena.VeciCocina.Entities.Factura;
import com.cursosena.VeciCocina.Entities.Inventario;
import com.cursosena.VeciCocina.Services.FacturaService;
import com.cursosena.VeciCocina.Services.InventarioService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<Factura> getAllFacturas() {
        return facturaService.getAllFacturas();
    }

    @PostMapping
    public Factura createFactura(@RequestBody Factura factura){
        return facturaService.createFactura(factura);
    }

    /*@PatchMapping("/{facturaId}/inventario/{inventarioId}")
    public ResponseEntity<Factura> asignarInventario(
        @PathVariable Integer facturaId,
        @PathVariable Integer inventarioId) {

    Factura factura = facturaService.buscarPorId(facturaId);
    Inventario inventario = inventarioService.buscarPorId(inventarioId);
    // 🔗 Asignar la relación
    factura.setInventario(inventario);
    facturaService.createFactura(factura);
    return ResponseEntity.ok(factura);
    }*/
   @PatchMapping("/{facturaId}/inventario/{inventarioId}")
    public ResponseEntity<?> asignarInventario(
        @PathVariable Integer facturaId,
        @PathVariable Integer inventarioId) {

    Factura factura = facturaService.buscarPorId(facturaId);
    if (factura == null) {
        return ResponseEntity.status(404).body("Factura no encontrada");
    }

    Inventario inventario = inventarioService.buscarPorId(inventarioId);
    if (inventario == null) {
        return ResponseEntity.status(404).body("Inventario no encontrado");
    }

    factura.setInventario(inventario);
    facturaService.createFactura(factura);

    return ResponseEntity.ok(factura);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        facturaService.deleteFactura(id);
    }
}
