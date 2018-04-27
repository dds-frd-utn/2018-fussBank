package utn.frd.borbotones.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import utn.frd.borbotones.entities.Cuenta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-27T18:05:06")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SetAttribute<Cliente, Cuenta> cuentas;
    public static volatile SingularAttribute<Cliente, Long> id;
    public static volatile SingularAttribute<Cliente, Integer> cuil;
    public static volatile SingularAttribute<Cliente, String> nombre;

}