/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.borbotones.rest.services;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utn.frd.borbotones.entities.Movimiento;
import utn.frd.borbotones.sessions.MovimientoFacade;

/**
 *
 * @author agustin
 */
@Path("/estadosMovimientos")
public class EstadoMovimientoRest {
    @EJB
    private MovimientoFacade ejbMovimientoFacade;
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movimiento> findAll(){
        return ejbMovimientoFacade.findAll();
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movimiento> findByTipo(@PathParam("id")long id){
        return ejbMovimientoFacade.findByTipo(id);
    }
    
    
    
    
    
}
