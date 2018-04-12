/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.borbotones.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utn.frd.borbotones.entities.Contacto;

/**
 *
 * @author agustin
 */
@Stateless
public class ContactoFacade extends AbstractFacade<Contacto> {

    @PersistenceContext(unitName = "utn.frd_borbotones_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactoFacade() {
        super(Contacto.class);
    }
    
}
