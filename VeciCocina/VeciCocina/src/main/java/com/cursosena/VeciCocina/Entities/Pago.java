package com.cursosena.VeciCocina.Entities;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@Entity
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Pago;
    private String Estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    //@JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "factura_id")
    //@JsonBackReference
    private Factura factura;

    public Integer getId_Pago() {
        return Id_Pago;
    }

    public void setId_Pago(Integer id_Pago) {
        Id_Pago = id_Pago;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Pago(Integer id_Pago, String estado, Usuario usuario, Factura factura) {
        Id_Pago = id_Pago;
        Estado = estado;
        this.usuario = usuario;
        this.factura = factura;
    }
    
}


