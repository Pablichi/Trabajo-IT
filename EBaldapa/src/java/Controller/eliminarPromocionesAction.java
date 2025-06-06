/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.PromocionWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Promocion;

/**
 *
 * @author DaniMaja
 */
public class eliminarPromocionesAction extends ActionSupport {
    
    private int idPromocion;

    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }
    
    public eliminarPromocionesAction() {
    }
    
    public String execute() throws Exception {
        PromocionWS promocion = new PromocionWS();
        promocion.remove(String.valueOf(this.getIdPromocion()));

        GenericType<List<Promocion>> genericType2 = new GenericType<List<Promocion>>() {
        };
        List<Promocion> listaPromociones = new ArrayList();
        listaPromociones = (List<Promocion>) promocion.findAll_XML(genericType2);
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("listaPromociones", listaPromociones);
        return SUCCESS;
     }
}
