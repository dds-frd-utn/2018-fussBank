/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.borbotones.rest.services;

import java.util.Date;
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
import utn.frd.borbotones.entities.Movimiento;
import utn.frd.borbotones.sessions.CuentaFacade;
import utn.frd.borbotones.sessions.MovimientoFacade;

/**
 *
 * @author agustin
 */
@Path("/cliente/{id}/cuentas/movimientos")
public class MovimientosRest {
    @EJB 
    private MovimientoFacade ejbMovimientoFacade;
    @EJB
    private CuentaFacade ejbCuentaFacade;
    
    @GET
    @Path("/{id_c}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Movimiento> findById(@PathParam("id_c")long id){
        return ejbMovimientoFacade.findByCuenta(id);
    }
    
    @POST
    @Path("/{id_c}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Movimiento movimiento,@PathParam("id_c")int id){
        movimiento.setCuenta(ejbCuentaFacade.find(id));
        Date creado = new Date();
        movimiento.setCreado(creado);
        ejbMovimientoFacade.create(movimiento);
    }
    
    @PUT
    @Path("/cliente/{id}/cuentas/movimientos/{id_m}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id_m")long id, Movimiento movimiento){
        ejbMovimientoFacade.edit(movimiento);
    }
    
}
