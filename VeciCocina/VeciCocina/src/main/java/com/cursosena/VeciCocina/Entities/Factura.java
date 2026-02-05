package com.cursosena.VeciCocina.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@Entity
public class Factura {

    // #region Atributos
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id_Factura;
    private int Total;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("facturas")
    @JoinColumn(name = "inventario_id")
    private Inventario inventario;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Pago> pagos;

    // #endregion

    // #region Get Set


    public Integer getId_Factura() {
        return Id_Factura;
    }

    public void setId_Factura(Integer id_Factura) {
        Id_Factura = id_Factura;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    // #endregion

    // #region Constructor
    public Factura(Integer id_Factura, int total, Inventario inventario, List<Pago> pagos) {
        Id_Factura = id_Factura;
        Total = total;
        this.inventario = inventario;
        this.pagos = pagos;
    }
    // #endregion
}
