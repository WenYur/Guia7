package com.cursosena.VeciCocina.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.cursosena.VeciCocina.Entities.Tienda;
import com.cursosena.VeciCocina.Entities.Transporte;
import com.cursosena.VeciCocina.Services.TransporteService;
import com.cursosena.VeciCocina.Services.TiendaService;

import java.util.List;


@RestController
@RequestMapping("/transportes")
public class TransporteController {

    @Autowired
    private TransporteService transporteService;

    @Autowired
    private TiendaService tiendaService;


    @GetMapping
    public List<Transporte> getAllTransportes() {
        return transporteService.getAllTransportes();
    }

    @PostMapping
    public Transporte createTransporte(@RequestBody Transporte transporte){
        return transporteService.createTransporte(transporte);
    }

    @PatchMapping("/{transporteId}/tienda/{tiendaId}")
    public ResponseEntity<Transporte> asignarTienda(
        @PathVariable Integer transporteId,
        @PathVariable Integer tiendaId) {

    Transporte transporte = transporteService.buscarPorId(transporteId);
    Tienda tienda = tiendaService.buscarPorId(tiendaId);
    // 🔗 Relación ManyToMany
    transporte.getTiendas().add(tienda);
    transporteService.createTransporte(transporte);
    return ResponseEntity.ok(transporte);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        transporteService.deleteTransporte(id);

    }
}
