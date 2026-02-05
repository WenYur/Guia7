package com.cursosena.VeciCocina.Entities;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@Entity
public class Transporte {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_transporte;
    private String TipoTransporte;
    private String Ubicacion;
    private String EstadoEntrega;
    private Long Telefono;

    @OneToOne(mappedBy = "transporte", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("transporte")
    private Usuario usuario;
    
    @ManyToMany
    @JoinTable(
        name = "Transporte_Tienda",
        joinColumns = @JoinColumn(name = "transporte_id"),
        inverseJoinColumns = @JoinColumn(name = "tienda_id")
        )
    private List<Tienda> tiendas;

    public Integer getId_transporte() {
        return Id_transporte;
    }

    public void setId_transporte(Integer id_transporte) {
        Id_transporte = id_transporte;
    }

    public String getTipoTransporte() {
        return TipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        TipoTransporte = tipoTransporte;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getEstadoEntrega() {
        return EstadoEntrega;
    }

    public void setEstadoEntrega(String estadoEntrega) {
        EstadoEntrega = estadoEntrega;
    }

    public Long getTelefono() {
        return Telefono;
    }

    public void setTelefono(Long telefono) {
        Telefono = telefono;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Tienda> getTiendas() {
        return tiendas;
    }

    public void setTiendas(List<Tienda> tiendas) {
        this.tiendas = tiendas;
    }

    public Transporte(Integer id_transporte, String tipoTransporte, String ubicacion, String estadoEntrega,
            Long telefono, Usuario usuario, List<Tienda> tiendas) {
        Id_transporte = id_transporte;
        TipoTransporte = tipoTransporte;
        Ubicacion = ubicacion;
        EstadoEntrega = estadoEntrega;
        Telefono = telefono;
        this.usuario = usuario;
        this.tiendas = tiendas;
    }
}
