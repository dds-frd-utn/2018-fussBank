/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.borbotones.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author agustin
 */
@Entity
@Table(name = "movimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m")
    , @NamedQuery(name = "Movimiento.findById", query = "SELECT m FROM Movimiento m WHERE m.id = :id")
    , @NamedQuery(name = "Movimiento.findByCreado", query = "SELECT m FROM Movimiento m WHERE m.creado = :creado")
    , @NamedQuery(name = "Movimiento.findByProcesado", query = "SELECT m FROM Movimiento m WHERE m.procesado = :procesado")
    , @NamedQuery(name = "Movimiento.findByTipo", query = "SELECT m FROM Movimiento m WHERE m.tipo = :tipo")
    , @NamedQuery(name = "Movimiento.findByEstado", query = "SELECT m FROM Movimiento m WHERE m.estado = :estado")
    , @NamedQuery(name = "Movimiento.findByImporte", query = "SELECT m FROM Movimiento m WHERE m.importe = :importe")
    , @NamedQuery(name = "Movimiento.findByCuenta", query = "SELECT m FROM Movimiento m WHERE m.cuenta.id = :id")})
public class Movimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creado;
    @Column(name = "procesado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date procesado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "importe")
    private double importe;
    @NotNull     
    @ManyToOne
    @JoinColumn(name = "id_cuenta")
    private Cuenta cuenta;

    public Movimiento() {
    }

    public Movimiento(Integer id) {
        this.id = id;
    }

    public Movimiento(Integer id, Date creado, int tipo, int estado, double importe) {
        this.id = id;
        this.creado = creado;
        this.tipo = tipo;
        this.estado = estado;
        this.importe = importe;
        }
    
    public Movimiento(int tipo, int estado, double importe) {
        this.tipo = tipo;
        this.estado = estado;
        this.importe = importe;
        }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreado() {
        return creado;
    }

    public void setCreado(Date creado) {
        this.creado = creado;
    }

    public Date getProcesado() {
        return procesado;
    }

    public void setProcesado(Date procesado) {
        this.procesado = procesado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Cuenta getMovimiento() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimiento)) {
            return false;
        }
        Movimiento other = (Movimiento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.borbotones.entities.Movimiento[ id=" + id + " ]";
    }
    
}
