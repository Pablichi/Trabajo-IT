/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.PagoWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Pago;

/**
 *
 * @author DaniMaja
 */
public class listarPagosAction extends ActionSupport {
    
    public listarPagosAction() {
    }
    
    public String execute() throws Exception {
        PagoWS valoracion = new PagoWS();
        GenericType<List<Pago>> genericType = new GenericType<List<Pago>>(){
        };
        List <Pago> data = new ArrayList<Pago>();
        data = (List<Pago>) valoracion.findAll_XML(genericType);     
         
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaPagos", data);
        return SUCCESS;
    }
    
}
