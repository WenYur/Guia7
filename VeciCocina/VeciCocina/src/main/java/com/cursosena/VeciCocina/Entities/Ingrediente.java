package com.cursosena.VeciCocina.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@Entity
public class Ingrediente {
// #region Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Ingrediente;
    private String NombreIngrediente;
    private int ValorIngrediente;
    private int Cantidad;
    private String FaltaComprar;

    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Inventario> inventarios;

    @ManyToMany
    @JoinTable(
        name = "Ingrediente_Receta",
        joinColumns = @JoinColumn(name = "ingrediente_id"),
        inverseJoinColumns = @JoinColumn(name = "receta_id")
        )
    private List<Receta> recetas;
// #endregion Atributos


// #region Get Set
        public Integer getId_Ingrediente() {
        return Id_Ingrediente;
    }


    public void setId_Ingrediente(Integer id_Ingrediente) {
        Id_Ingrediente = id_Ingrediente;
    }


    public String getNombreIngrediente() {
        return NombreIngrediente;
    }


    public void setNombreIngrediente(String nombreIngrediente) {
        NombreIngrediente = nombreIngrediente;
    }


    public int getValorIngrediente() {
        return ValorIngrediente;
    }


    public void setValorIngrediente(int valorIngrediente) {
        ValorIngrediente = valorIngrediente;
    }


    public int getCantidad() {
        return Cantidad;
    }


    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }


    public String getFaltaComprar() {
        return FaltaComprar;
    }


    public void setFaltaComprar(String faltaComprar) {
        FaltaComprar = faltaComprar;
    }


    public List<Inventario> getInventarios() {
        return inventarios;
    }


    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }


    public List<Receta> getRecetas() {
        return recetas;
    }


    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }
    
// #endregion Get Set

// #region Constructor

    public Ingrediente(Integer id_Ingrediente, String nombreIngrediente, int valorIngrediente, int cantidad,
            String faltaComprar, List<Inventario> inventarios, List<Receta> recetas) {
        Id_Ingrediente = id_Ingrediente;
        NombreIngrediente = nombreIngrediente;
        ValorIngrediente = valorIngrediente;
        Cantidad = cantidad;
        FaltaComprar = faltaComprar;
        this.inventarios = inventarios;
        this.recetas = recetas;
    }
// #endregion Constructor


}
