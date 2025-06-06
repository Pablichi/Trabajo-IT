/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ProveedorServiciosWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.ProveedorServicios;

/**
 *
 * @author pabli
 */
public class eliminarProveedorAction extends ActionSupport {
    
    private int idProveedor;

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    
    
    public eliminarProveedorAction() {
    }
    
    public String execute() throws Exception {
        
        ProveedorServiciosWS cliente = new ProveedorServiciosWS();
        cliente.remove(String.valueOf(this.getIdProveedor()));

        GenericType<List<ProveedorServicios>> genericType2 = new GenericType<List<ProveedorServicios>>() {
        };
        List<ProveedorServicios> listaProveedores = new ArrayList();
        listaProveedores = (List<ProveedorServicios>) cliente.findAll_XML(genericType2);
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("listaProveedores", listaProveedores);
        return SUCCESS;
    }
    
}
