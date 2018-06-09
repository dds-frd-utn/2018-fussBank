/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utn.frd.bunkerbank.rest.services;

import java.util.List;
import java.util.Date;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ejb.EJB;
import utn.frd.bunkerbank.entities.sessions.CuentaFacade;
import utn.frd.bunkerbank.entities.sessions.ClienteFacade;//agregado
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import utn.frd.bunkerbank.entities.Cuenta;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
//agrego la libreria saldo.
import utn.frd.bunkerbank.entities.Saldo;//falta agregar una clase saldo ojo//
/**
 *
 * @author Raquel
 */
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
    @Path("/{id_c}")//added 
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
