/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ValoracionWS;
import com.opensymphony.xwork2.ActionSupport;
import javax.ws.rs.core.GenericType;
import modelo.Valoracion;

/**
 *
 * @author DaniMaja
 */
public class detalleValoracionAction extends ActionSupport {
    
    private int idValoracion;
    private Valoracion valoracion;

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public Valoracion getValoracion() {
        return valoracion;
    }

    public void setValoracion(Valoracion valoracion) {
        this.valoracion = valoracion;
    }
    
    public detalleValoracionAction() {
    }
    
    public String execute() throws Exception {
           
        ValoracionWS cliente = new ValoracionWS();
        GenericType<Valoracion> genericType = new GenericType<Valoracion>(){
        };
        Valoracion data = new Valoracion();
        data = (Valoracion) cliente.find_XML(genericType, Integer.toString(idValoracion));     
         
        valoracion = data;
        return SUCCESS;
        
    }
    
}
