/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.PromocionWS;
import com.opensymphony.xwork2.ActionSupport;
import javax.ws.rs.core.GenericType;
import modelo.Promocion;

/**
 *
 * @author pabli
 */
public class detallePromocionAction extends ActionSupport {
    
    private int idPromocion;
    private Promocion promocion;

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }
    
    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }
    
    
    public detallePromocionAction() {
    }
    
    public String execute() throws Exception {
        PromocionWS cliente = new PromocionWS();
        GenericType<Promocion> genericType = new GenericType<Promocion>(){
        };
        Promocion data = new Promocion();
        data = (Promocion) cliente.find_XML(genericType, Integer.toString(idPromocion));     
         
        promocion = data;
       
        return SUCCESS;
    }
    
}
