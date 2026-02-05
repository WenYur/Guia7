package com.cursosena.VeciCocina.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cursosena.VeciCocina.Entities.Factura;
//import com.cursosena.VeciCocina.Entities.Pago;
import com.cursosena.VeciCocina.Repository.FacturaRepository;
//import com.cursosena.VeciCocina.Repository.PagoRepository;

@Service
public class FacturaService {

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    //private PagoRepository pagoRepository;

    public List<Factura> getAllFacturas(){
        return facturaRepository.findAll();
    }

    public Factura createFactura (Factura factura){
        return facturaRepository.save(factura);
    }

    public Factura buscarPorId(Integer id) {
        return facturaRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
    
    public void deleteFactura(Integer id){
        facturaRepository.deleteById(id);
    }

}
