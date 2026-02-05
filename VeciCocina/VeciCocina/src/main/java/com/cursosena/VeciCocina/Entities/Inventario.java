package com.cursosena.VeciCocina.Entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

@NoArgsConstructor 

@Entity
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Inventario;
    private int Cantidad_Disponible;

    @ManyToOne
    @JoinColumn(name = "tienda_id")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "ingrediente_id")
    private Ingrediente ingrediente;

    @OneToMany(mappedBy = "inventario")
    @JsonIgnoreProperties("inventario")
    private List<Factura> facturas;

    public Integer getId_Inventario() {
        return Id_Inventario;
    }

    public void setId_Inventario(Integer id_Inventario) {
        Id_Inventario = id_Inventario;
    }

    public int getCantidad_Disponible() {
        return Cantidad_Disponible;
    }

    public void setCantidad_Disponible(int cantidad_Disponible) {
        Cantidad_Disponible = cantidad_Disponible;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public Inventario(Integer id_Inventario, int cantidad_Disponible, Tienda tienda, Ingrediente ingrediente,
            List<Factura> facturas) {
        Id_Inventario = id_Inventario;
        Cantidad_Disponible = cantidad_Disponible;
        this.tienda = tienda;
        this.ingrediente = ingrediente;
        this.facturas = facturas;
    }
}
