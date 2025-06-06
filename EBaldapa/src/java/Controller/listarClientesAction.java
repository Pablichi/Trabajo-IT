/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ClienteWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Cliente;

/**
 *
 * @author DaniMaja
 */
public class listarClientesAction extends ActionSupport {
    
    public listarClientesAction() {
    }
    
    public String execute() throws Exception {
        
        ClienteWS destino = new ClienteWS();
        GenericType<List<Cliente>> genericType = new GenericType<List<Cliente>>(){
        };
        List <Cliente> data = new ArrayList<Cliente>();
        data = (List<Cliente>) destino.findAll_XML(genericType);
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaClientes", data);
        return SUCCESS;
    }
    
}
