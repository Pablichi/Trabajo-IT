/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ClienteWS;
import WS.CuentaWS;
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
 * @author pabli
 */
public class crearClienteAction extends ActionSupport {
    
    private String nombreCliente;
    private String emailCliente;
    private int telefonoCliente;
    private String direccionCliente;

    private int idCuentaCliente;
    

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

    
    public crearClienteAction() {
    }
    
    public String execute() throws Exception {
        Cliente clienteT = new Cliente();
        
        int idRandom = new Random().nextInt(1000000)+1;
        clienteT.setId(idRandom);
        clienteT.setNombre(nombreCliente);
        clienteT.setEmail(emailCliente);
        clienteT.setTelefono(telefonoCliente);
        clienteT.setDireccion(direccionCliente);
        
        ClienteWS clientews = new ClienteWS();
        
        CuentaWS cuentaws = new CuentaWS();
                GenericType<Cuenta> genericType = new GenericType<Cuenta>(){
        };
        Cuenta data = new Cuenta();
        data = (Cuenta) cuentaws.find_XML(genericType, Integer.toString(idCuentaCliente));     
         

        clienteT.setIdCuenta(data);

        Object obj_paquete = clienteT;
        clientews.create_XML(obj_paquete);
        
        
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
