/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.borbotones.rest.services;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utn.frd.borbotones.entities.Cuenta;
import utn.frd.borbotones.entities.Saldo;
import utn.frd.borbotones.sessions.ClienteFacade;
import utn.frd.borbotones.sessions.CuentaFacade;

/**
 *
 * @author agustin
 */
@Path("/cliente/{id}/cuentas")
public class CuentaRest {
    
    @EJB
    private CuentaFacade ejbCuentaFacade;
    @EJB
    private ClienteFacade ejbClienteFacade;
        
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Cuenta> findByCliente(@PathParam("id") long id){
        return ejbCuentaFacade.findByCliente(id);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON}) 
    public void create(@PathParam("id") long id, Cuenta cuenta){
        cuenta.setCliente( ejbClienteFacade.find(id) );
        Date creado = new Date();
        cuenta.setApertura(creado);
        ejbCuentaFacade.create(cuenta);       
    }
    
    @GET
    @Path("/{id_c}")
    @Produces({MediaType.APPLICATION_JSON})
    public Cuenta findById(@PathParam("id_c")int id){
        return ejbCuentaFacade.find(id);
    }
    
    @GET
    @Path("/{id_c}/saldo")
    @Produces({MediaType.APPLICATION_JSON})
    public Saldo getSaldos(@PathParam("id_c") int id){
        Cuenta cuenta = ejbCuentaFacade.find(id);
        float saldo = cuenta.getSaldo();
        Saldo saldoHld = new Saldo();
        saldoHld.setSaldo(saldo);
        return saldoHld;
        
    }
    
}
