/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.borbotones.rest.services;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ejb.EJB;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import utn.frd.borbotones.entities.Cliente;
import utn.frd.borbotones.entities.Movimiento;
import utn.frd.borbotones.sessions.MovimientoFacade;

/**
 *
 * @author agustin
 */
@Path("/cliente/{id}/cuentas/movimientos")
public class MovimientosRest {
    @EJB 
    private MovimientoFacade ejbMovimientoFacade;
    
    @GET
    @Path("/{id_c}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movimiento> findById(@PathParam("id_c")long id){
        return ejbMovimientoFacade.findByCuenta(id);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Movimiento movimiento){
        ejbMovimientoFacade.create(movimiento);
    }
    
    @PUT
    @Path("/cliente/{id}/cuentas/movimientos/{id_m}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id_m")long id, Movimiento movimiento){
        ejbMovimientoFacade.edit(movimiento);
    }
    
}
