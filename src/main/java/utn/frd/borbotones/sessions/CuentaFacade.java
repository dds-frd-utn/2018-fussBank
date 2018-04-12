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
import utn.frd.borbotones.entities.Cuenta;

/**
 *
 * @author agustin
 */
@Stateless
public class CuentaFacade extends AbstractFacade<Cuenta> {

    @PersistenceContext(unitName = "utn.frd_borbotones_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuentaFacade() {
        super(Cuenta.class);
    }
    
    public List<Cuenta> findByCliente(long id){
        return em.createNamedQuery("Cuenta.findByCliente",Cuenta.class)
                .setParameter("id", id)
                .getResultList();
    }
    
}
