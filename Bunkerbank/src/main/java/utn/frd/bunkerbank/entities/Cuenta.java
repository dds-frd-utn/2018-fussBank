/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// A esta calse la he modificado
package utn.frd.bunkerbank.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;//agruege esta libreria.
import java.util.Set;//tambien.
import javax.persistence.Basic;
import javax.persistence.CascadeType;//agregado
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import static javax.persistence.GenerationType.SEQUENCE;//
import static javax.persistence.GenerationType.TABLE;//agregadas ambas esta y la anterior//
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.ManyToOne;//agregado
import javax.persistence.JoinColumn;//agregado
import javax.persistence.OneToMany;//agregado tambien//
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Raquel
 */
@Entity
@Table(name = "cuenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c")
    , @NamedQuery(name = "Cuenta.findById", query = "SELECT c FROM Cuenta c WHERE c.id = :id")
    , @NamedQuery(name = "Cuenta.findByNumero", query = "SELECT c FROM Cuenta c WHERE c.numero = :numero")
    , @NamedQuery(name = "Cuenta.findByApertura", query = "SELECT c FROM Cuenta c WHERE c.apertura = :apertura")
    , @NamedQuery(name = "Cuenta.findByIdCliente", query = "SELECT c FROM Cuenta c WHERE c.idCliente = :idCliente")})
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=TABLE)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private long numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apertura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date apertura;
    @NotNull
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;  
    @OneToMany(targetEntity=Movimiento.class,mappedBy="cuenta")
    private Set<Movimiento> movimientos;
    //@Basic(optional = false)
    //@NotNull
    //@Column(name = "id_cliente")
    //private int idCliente;

    public Cuenta() {
    }

    public Cuenta(Integer id) {
        this.id = id;
    }

    public Cuenta(Integer id, long numero, Date apertura, Cliente cliente) {
        this.id = id;
        this.numero = numero;
        this.apertura = apertura;
        this.cliente = cliente;//cambie id cliente por cliente
    }
    
    public Cuenta(long numero,Integer id){
        this.numero=numero;
        this.id = id;
    }//agregue esta función

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
    
    public Cliente getCuenta() {//agregado tambien obtengo cuenta del cliente
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public float getSaldo(){///tambien agregado
        float saldo;
        saldo = 0;
        for(Movimiento element : movimientos){
            if(element.getTipo() == 1){
                saldo += element.getImporte();
            }
            else{
                saldo -= element.getImporte();
            }
            
        }
        return saldo;
    }

    //public int getIdCliente() {
    //    return idCliente;
    //}
    public Set<Movimiento> getMovimientos(){//agregado
        return movimientos;
    }

    //public void setIdCliente(int idCliente) {
      //  this.idCliente = idCliente;
    //}
    public void setMovimientos(Set<Movimiento> movimientos){//agregado
        this.movimientos = movimientos;
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
        return "utn.frd.bunkerbank.entities.Cuenta[ id=" + id + " ]";
    }
    
}
