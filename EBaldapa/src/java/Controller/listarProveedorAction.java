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
 * @author DaniMaja
 */
public class listarProveedorAction extends ActionSupport {
    
    public listarProveedorAction() {
    }
    
    public String execute() throws Exception {
        ProveedorServiciosWS proveedor = new ProveedorServiciosWS();
        GenericType<List<ProveedorServicios>> genericType = new GenericType<List<ProveedorServicios>>(){
        };
        List <ProveedorServicios> data = new ArrayList<ProveedorServicios>();
        data = (List<ProveedorServicios>) proveedor.findAll_XML(genericType);
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaProveedores", data);
        return SUCCESS;
    }
    
}
