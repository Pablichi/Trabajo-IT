/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ClienteWS;
import com.opensymphony.xwork2.ActionSupport;
import javax.ws.rs.core.GenericType;
import modelo.Cliente;

/**
 *
 * @author DaniMaja
 */
public class detalleClienteAction extends ActionSupport {
    
        
    private int idCliente;
 
    private Cliente cliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public detalleClienteAction() {
    }
    
    public String execute() throws Exception {
        ClienteWS clientews = new ClienteWS();
        GenericType<Cliente> genericType = new GenericType<Cliente>(){
        };
        Cliente data = new Cliente();
        data = (Cliente) clientews.find_XML(genericType, Integer.toString(idCliente));     
        System.out.println(data.getNombre());
        cliente = data;
       
        return SUCCESS;
    }
    
}
