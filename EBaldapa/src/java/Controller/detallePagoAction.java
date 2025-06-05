 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.PagoWS;
import com.opensymphony.xwork2.ActionSupport;
import javax.ws.rs.core.GenericType;
import modelo.Pago;

/**
 *
 * @author DaniMaja
 */
public class detallePagoAction extends ActionSupport {
    
    
    private int idPago;
 
    private Pago pago;

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
    
    
    public detallePagoAction() {
    }
    
    public String execute() throws Exception {
        PagoWS cliente = new PagoWS();
        GenericType<Pago> genericType = new GenericType<Pago>(){
        };
        Pago data = new Pago();
        data = (Pago) cliente.find_XML(genericType, Integer.toString(idPago));     
         
        pago = data;
       
        return SUCCESS;
    }

    
}