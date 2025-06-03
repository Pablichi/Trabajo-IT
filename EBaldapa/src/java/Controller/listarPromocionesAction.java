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
public class listarPromocionesAction extends ActionSupport {
    
    public listarPromocionesAction() {
    }
    
    public String execute() throws Exception {

        PromocionWS promocion = new PromocionWS();
        GenericType<List<Promocion>> genericType = new GenericType<List<Promocion>>(){
        };
        List <Promocion> data = new ArrayList<Promocion>();
        data = (List<Promocion>) promocion.findAll_XML(genericType);
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaPromociones", data);
        return SUCCESS;
    }
 
}
