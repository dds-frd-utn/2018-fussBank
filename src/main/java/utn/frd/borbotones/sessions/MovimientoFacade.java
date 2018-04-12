/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.borbotones.sessions;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utn.frd.borbotones.entities.Movimiento;

/**
 *
 * @author agustin
 */
@Stateless
public class MovimientoFacade extends AbstractFacade<Movimiento> {

    @PersistenceContext(unitName = "utn.frd_borbotones_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MovimientoFacade() {
        super(Movimiento.class);
    }
    
    public List<Movimiento> findByCuenta(long id){
        return em.createNamedQuery("Movimiento.findByCuenta",Movimiento.class)
                .setParameter("id", id)
                .setMaxResults(10)
                .getResultList();
    }
    
}
