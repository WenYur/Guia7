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
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Receta;    
    private String NombreReceta;
    private String TipoReceta;

    @OneToMany(mappedBy = "receta",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Usuario> usuarios;

    @ManyToMany(mappedBy = "recetas")
    @JsonIgnore
    private List<Ingrediente> ingredientes;

    public Integer getId_Receta() {
        return Id_Receta;
    }

    public void setId_Receta(Integer id_Receta) {
        Id_Receta = id_Receta;
    }

    public String getNombreReceta() {
        return NombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        NombreReceta = nombreReceta;
    }

    public String getTipoReceta() {
        return TipoReceta;
    }

    public void setTipoReceta(String tipoReceta) {
        TipoReceta = tipoReceta;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Receta(Integer id_Receta, String nombreReceta, String tipoReceta, List<Usuario> usuarios,
            List<Ingrediente> ingredientes) {
        Id_Receta = id_Receta;
        NombreReceta = nombreReceta;
        TipoReceta = tipoReceta;
        this.usuarios = usuarios;
        this.ingredientes = ingredientes;
    }

   

}
