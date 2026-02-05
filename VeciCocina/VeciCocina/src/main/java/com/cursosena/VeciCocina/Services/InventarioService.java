package com.cursosena.VeciCocina.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cursosena.VeciCocina.Entities.Inventario;
import com.cursosena.VeciCocina.Repository.InventarioRepository;

@Service
public class InventarioService {

    @Autowired
    InventarioRepository inventarioRepository;

    public List<Inventario> getAllInventarios(){
        return inventarioRepository.findAll();
    }

    public Inventario createInventario (Inventario inventario){
        return inventarioRepository.save(inventario);
    }

    public Inventario buscarPorId(Integer id) {
    return inventarioRepository.findById(id).orElse(null);
    }

    public void deleteInventario (Integer id){
        inventarioRepository.deleteById(id);
    }

}
