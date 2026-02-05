package com.cursosena.VeciCocina.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.CascadeType;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Usuario;
    private String Nombre;
    private String Apellido;
    private String Ubicacion;
    private String Metodo_de_Pago;
    private String Email;

    @OneToOne
    @JoinColumn(name = "transporte_id")
    private Transporte transporte;

    @ManyToOne
    @JoinColumn(name = "receta_id")
    private Receta receta;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    //@JsonManagedReference
    @JsonIgnore
    private List<Pago> pagos;

    public Integer getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(Integer id_Usuario) {
        Id_Usuario = id_Usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }

    public String getMetodo_de_Pago() {
        return Metodo_de_Pago;
    }

    public void setMetodo_de_Pago(String metodo_de_Pago) {
        Metodo_de_Pago = metodo_de_Pago;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public Usuario(Integer id_Usuario, String nombre, String apellido, String ubicacion, String metodo_de_Pago,
            String email, Transporte transporte, Receta receta, List<Pago> pagos) {
        Id_Usuario = id_Usuario;
        Nombre = nombre;
        Apellido = apellido;
        Ubicacion = ubicacion;
        Metodo_de_Pago = metodo_de_Pago;
        Email = email;
        this.transporte = transporte;
        this.receta = receta;
        this.pagos = pagos;
    }
}
