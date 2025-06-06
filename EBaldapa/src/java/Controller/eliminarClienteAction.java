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
public class eliminarClienteAction extends ActionSupport {
    
    private int idCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public eliminarClienteAction() {
    }
    
    public String execute() throws Exception {
        ClienteWS cliente = new ClienteWS();

        cliente.remove(String.valueOf(this.getIdCliente()));

        GenericType<List<Cliente>> genericType2 = new GenericType<List<Cliente>>() {
        };
        
        List<Cliente> listaClientes = new ArrayList();
        listaClientes = (List<Cliente>) cliente.findAll_XML(genericType2);
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("listaClientes", listaClientes);
        return SUCCESS;
    }
}
