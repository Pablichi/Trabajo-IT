/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ClienteWS;
import WS.PaqueteTuristicoWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Cliente;
import modelo.PaqueteTuristico;

/**
 *
 * @author pabli
 */
public class crearValoracionFormAction extends ActionSupport {
    
    public crearValoracionFormAction() {
    }
    
    public String execute() throws Exception {
        ClienteWS clienteDAO = new ClienteWS();
        GenericType<List<Cliente>> genericType = new GenericType<List<Cliente>>(){
        };
        List <Cliente> data = new ArrayList<Cliente>();
        data = (List<Cliente>) clienteDAO.findAll_XML(genericType);
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaClientes", data);
        
        PaqueteTuristicoWS paqueteDAO = new PaqueteTuristicoWS();
        GenericType<List<PaqueteTuristico>> genericType2 = new GenericType<List<PaqueteTuristico>>(){
        };
        List <PaqueteTuristico> data2 = new ArrayList<PaqueteTuristico>();
        data2 = (List<PaqueteTuristico>) paqueteDAO.findAll_XML(genericType2);
        session.put("listaPaquetes", data2);
        
        return SUCCESS;
    }
    
}
