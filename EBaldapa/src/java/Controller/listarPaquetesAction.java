/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.PaqueteTuristicoWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.PaqueteTuristico;

/**
 *
 * @author pabli
 */
public class listarPaquetesAction extends ActionSupport {
    
    public listarPaquetesAction() {
    }
    
    public String execute() throws Exception {
        PaqueteTuristicoWS cliente = new PaqueteTuristicoWS();
        GenericType<List<PaqueteTuristico>> genericType = new GenericType<List<PaqueteTuristico>>(){
        };
        List <PaqueteTuristico> data = new ArrayList<PaqueteTuristico>();
        data = (List<PaqueteTuristico>) cliente.findAll_XML(genericType);     
         
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaPaquetes", data);
        return SUCCESS;
    }
    
}
