/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ReservaWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Reserva;

/**
 *
 * @author pabli
 */
public class crearPagoFormAction extends ActionSupport {
    
    public crearPagoFormAction() {
    }
    
    public String execute() throws Exception {
        ReservaWS reservaDAO = new ReservaWS();
        GenericType<List<Reserva>> genericType = new GenericType<List<Reserva>>(){
        };
        List <Reserva> data = new ArrayList<Reserva>();
        data = (List<Reserva>) reservaDAO.findAll_XML(genericType);
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaReservas", data);
        
 
        return SUCCESS;
    }
    
}
