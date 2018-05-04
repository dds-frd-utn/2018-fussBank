package utn.frd.borbotones.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import utn.frd.borbotones.entities.Cliente;
import utn.frd.borbotones.entities.Movimiento;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-04T11:21:35")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, Cliente> cliente;
    public static volatile SingularAttribute<Cuenta, Long> numero;
    public static volatile SingularAttribute<Cuenta, Integer> id;
    public static volatile SetAttribute<Cuenta, Movimiento> movimientos;
    public static volatile SingularAttribute<Cuenta, Date> apertura;

}