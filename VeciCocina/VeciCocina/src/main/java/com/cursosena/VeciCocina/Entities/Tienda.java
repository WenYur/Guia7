package com.cursosena.VeciCocina.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@Entity
public class Tienda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Tienda;
    private String NombreTienda;
    private String Ubicacion;
    private String Id_Pago;
    private int Distancia;

    @ManyToMany(mappedBy = "tiendas")
    @JsonIgnore
    private List<Transporte> transportes;

    @OneToMany(mappedBy = "tienda", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Inventario> inventarios;

    public Integer getId_Tienda() {
        return Id_Tienda;
    }

    public void setId_Tienda(Integer id_Tienda) {
        Id_Tienda = id_Tienda;
    }

    public String getNombreTienda() {
        return NombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        NombreTienda = nombreTienda;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getId_Pago() {
        return Id_Pago;
    }

    public void setId_Pago(String id_Pago) {
        Id_Pago = id_Pago;
    }

    public int getDistancia() {
        return Distancia;
    }

    public void setDistancia(int distancia) {
        Distancia = distancia;
    }

    public List<Transporte> getTransportes() {
        return transportes;
    }

    public void setTransportes(List<Transporte> transportes) {
        this.transportes = transportes;
    }

    public List<Inventario> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    public Tienda(Integer id_Tienda, String nombreTienda, String ubicacion, String id_Pago, int distancia,
            List<Transporte> transportes, List<Inventario> inventarios) {
        Id_Tienda = id_Tienda;
        NombreTienda = nombreTienda;
        Ubicacion = ubicacion;
        Id_Pago = id_Pago;
        Distancia = distancia;
        this.transportes = transportes;
        this.inventarios = inventarios;
    }
}
