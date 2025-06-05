/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.PaqueteTuristicoWS;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;
import modelo.PaqueteTuristico;

/**
 *
 * @author pabli
 */
public class detallePaqueteAction extends ActionSupport {
    
    private int idPaquete;
    private PaqueteTuristico paquete;

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }
    
    
    public detallePaqueteAction() {
    }
    
    public String execute() throws Exception {
        PaqueteTuristicoWS cliente = new PaqueteTuristicoWS();
        GenericType<PaqueteTuristico> genericType = new GenericType<PaqueteTuristico>(){
        };
        PaqueteTuristico data = new PaqueteTuristico();
        data = (PaqueteTuristico) cliente.find_XML(genericType, Integer.toString(idPaquete));     
         
        paquete = data;
        
        return SUCCESS;
    }

    public PaqueteTuristico getPaquete() {
        return paquete;
    }

    public void setPaquete(PaqueteTuristico paquete) {
        this.paquete = paquete;
    }
    
}
