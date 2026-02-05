package com.cursosena.VeciCocina.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cursosena.VeciCocina.Entities.Tienda;
import com.cursosena.VeciCocina.Services.TiendaService;
import com.cursosena.VeciCocina.Services.PagoService;

import java.util.List;


@RestController
@RequestMapping("/tiendas")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

     @Autowired
    private PagoService pagoService;


    @GetMapping
    public List<Tienda> getAllTiendas() {
        return tiendaService.getAllTiendas();
    }

    @PostMapping
    public Tienda createTienda(@RequestBody Tienda tienda){
        return tiendaService.createTienda(tienda);
    }

    /*@PatchMapping("/{tiendaId}/pago/{pagoId}")
    public ResponseEntity<Tienda> asignarPago(
        @PathVariable Integer tiendaId,
        @PathVariable Integer pagoId) {

    Tienda tienda = tiendaService.buscarPorId(tiendaId);
    Pago pago = pagoService.buscarPorId(pagoId);
    // 🔗 Asignar la relación
    tienda.setPago(pago);
    tiendaService.createTienda(tienda);
    return ResponseEntity.ok(tienda);
    }*/

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        tiendaService.deleteTienda(id);

    }
}
