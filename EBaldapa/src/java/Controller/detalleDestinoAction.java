/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.DestinoWS;
import com.opensymphony.xwork2.ActionSupport;
import javax.ws.rs.core.GenericType;
import modelo.Destino;

/**
 *
 * @author DaniMaja
 */
public class detalleDestinoAction extends ActionSupport {
    
    private int idDestino;
 
    private Destino destino;

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }
    
    public detalleDestinoAction() {
    }
    
    public String execute() throws Exception {
        
        DestinoWS cliente = new DestinoWS();
        GenericType<Destino> genericType = new GenericType<Destino>(){
        };
        Destino data = new Destino();
        data = (Destino) cliente.find_XML(genericType, Integer.toString(idDestino));     
         
        destino = data;
       
        return SUCCESS;
    }
}
