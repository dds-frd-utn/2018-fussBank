/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.borbotones.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author agustin
 */
@Entity
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
    , @NamedQuery(name = "Cuenta.findById", query = "SELECT c FROM Cuenta c WHERE c.id = :id")
    , @NamedQuery(name = "Cuenta.findByNumero", query = "SELECT c FROM Cuenta c WHERE c.numero = :numero")
    , @NamedQuery(name = "Cuenta.findByApertura", query = "SELECT c FROM Cuenta c WHERE c.apertura = :apertura")
    , @NamedQuery(name = "Cuenta.findByCliente", query = "SELECT c FROM Cuenta c WHERE c.cliente.id = :id")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private long numero;
    //@Basic(optional = false)
    //@NotNull
    @Column(name = "apertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date apertura;
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_cliente")
    private Cliente cliente;  
    @OneToMany
    private List<Movimiento> movimientos;
    
    public Cuenta() {
    }

    public Cuenta(Integer id) {
        this.id = id;
    }

    public Cuenta(Integer id, long numero, Date apertura,Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.apertura = apertura;
        this.cliente = cliente;
        
    }
    
    public Cuenta(long numero, int id_cliente){
        this.numero=numero;
                        
    }
    /**modifico el constructor? cambio cliente por id cliente?**/
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getApertura() {
        return apertura;
    }

    public void setApertura(Date apertura) {
        this.apertura = apertura;
    }

    public Cliente getCuenta() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<Movimiento> getMovimientos(){
        return movimientos;
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
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utn.frd.borbotones.entities.Cuenta[ id=" + id + " ]";
    }
    
}
