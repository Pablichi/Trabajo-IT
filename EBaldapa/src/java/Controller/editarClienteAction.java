/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ClienteWS;
import WS.CuentaWS;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.GenericType;
import modelo.Cliente;
import modelo.Cuenta;

/**
 *
 * @author DaniMaja
 */


public class editarClienteAction extends ActionSupport {
    
    
    private String nombreCliente;
    private String emailCliente;
    private int telefonoCliente;
    private String direccionCliente;

    private int idCuentaCliente;
    
    private int idCliente;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public int getIdCuentaCliente() {
        return idCuentaCliente;
    }

    public void setIdCuentaCliente(int idCuentaCliente) {
        this.idCuentaCliente = idCuentaCliente;
    }
    
    public editarClienteAction() {
    }
    
    public String execute() throws Exception {
        
        Cliente clienteT = new Cliente();
        
        clienteT.setId(idCliente);
        clienteT.setNombre(nombreCliente);
        clienteT.setEmail(emailCliente);
        clienteT.setTelefono(telefonoCliente);
        clienteT.setDireccion(direccionCliente);
        
        ClienteWS clienteDAO = new ClienteWS();
        
        CuentaWS cuentaws = new CuentaWS();
                GenericType<Cuenta> genericType = new GenericType<Cuenta>(){
        };
        Cuenta data = new Cuenta();
        data = (Cuenta) cuentaws.find_XML(genericType, Integer.toString(idCuentaCliente));     
         
        clienteT.setIdCuenta(data);
        Object obj_paquete = clienteT;
        System.out.println(this.direccionCliente);
        System.out.println(this.emailCliente);
        System.out.println(this.idCliente);
        System.out.println(this.idCuentaCliente);
        System.out.println(this.nombreCliente);
        System.out.println(this.telefonoCliente);
        
        clienteDAO.edit_XML(obj_paquete, Integer.toString(idCliente));
        
        ClienteWS clienteListado = new ClienteWS();
        GenericType<List<Cliente>> genericTypeListado = new GenericType<List<Cliente>>(){
        };
        List <Cliente> dataListado = new ArrayList<Cliente>();
        dataListado = (List<Cliente>) clienteListado.findAll_XML(genericTypeListado);     
         
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaClientes", dataListado);
        
        return SUCCESS;
    }
    
}
