package com.cursosena.VeciCocina.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cursosena.VeciCocina.Entities.Factura;
import com.cursosena.VeciCocina.Entities.Pago;
import com.cursosena.VeciCocina.Entities.Usuario;
import com.cursosena.VeciCocina.Services.PagoService;
import com.cursosena.VeciCocina.Services.FacturaService;
import com.cursosena.VeciCocina.Services.UsuarioService;

import java.util.List;


@RestController
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping
    public List<Pago> getAllPagos() {
        return pagoService.getAllPagos();
    }

    @PostMapping
    public Pago createPago(@RequestBody Pago pago){
        return pagoService.createPago(pago);
    }

    @PatchMapping("/{pagoId}/factura/{facturaId}")
    public ResponseEntity<Pago> asignarFactura(
        @PathVariable Integer pagoId,
        @PathVariable Integer facturaId) {

    Pago pago = pagoService.buscarPorId(pagoId);
    Factura factura = facturaService.buscarPorId(facturaId);
    // 🔗 Asignar la relación
    pago.setFactura(factura);
    pagoService.createPago(pago);
    return ResponseEntity.ok(pago);
    }

    @PatchMapping("/{pagoId}/usuario/{usuarioId}")
    public ResponseEntity<Pago> asignarUsuario(
        @PathVariable Integer pagoId,
        @PathVariable Integer usuarioId) {

    Pago pago = pagoService.buscarPorId(pagoId);
    Usuario usuario = usuarioService.buscarPorId(usuarioId);
    // 🔗 Asignar la relación
    pago.setUsuario(usuario);
    pagoService.createPago(pago);
    return ResponseEntity.ok(pago);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        pagoService.deletePago(id);

    }
}
