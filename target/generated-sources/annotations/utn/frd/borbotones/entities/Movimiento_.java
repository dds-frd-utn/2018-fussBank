package utn.frd.borbotones.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import utn.frd.borbotones.entities.Cuenta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-27T18:05:06")
@StaticMetamodel(Movimiento.class)
public class Movimiento_ { 

    public static volatile SingularAttribute<Movimiento, Integer> tipo;
    public static volatile SingularAttribute<Movimiento, Integer> estado;
    public static volatile SingularAttribute<Movimiento, Date> creado;
    public static volatile SingularAttribute<Movimiento, Date> procesado;
    public static volatile SingularAttribute<Movimiento, Cuenta> cuenta;
    public static volatile SingularAttribute<Movimiento, Integer> id;
    public static volatile SingularAttribute<Movimiento, Double> importe;

}