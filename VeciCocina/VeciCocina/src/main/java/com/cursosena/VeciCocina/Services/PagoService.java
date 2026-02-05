package com.cursosena.VeciCocina.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cursosena.VeciCocina.Entities.Pago;
import com.cursosena.VeciCocina.Repository.PagoRepository;

@Service
public class PagoService {

    @Autowired
    PagoRepository pagoRepository;

    public List<Pago> getAllPagos(){
        return pagoRepository.findAll();
    }

    public Pago createPago (Pago pago){
        return pagoRepository.save(pago);
    }

    public Pago buscarPorId(Integer id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    public void deletePago(Integer id){
        pagoRepository.deleteById(id);
    }

}
