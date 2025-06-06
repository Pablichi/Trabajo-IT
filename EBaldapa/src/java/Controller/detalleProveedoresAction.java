/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ProveedorServiciosWS;
import com.opensymphony.xwork2.ActionSupport;
import javax.ws.rs.core.GenericType;
import modelo.ProveedorServicios;

/**
 *
 * @author pabli
 */
public class detalleProveedoresAction extends ActionSupport {
    
    private int idProveedor;
    
    private ProveedorServicios proveedor;

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public ProveedorServicios getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorServicios proveedor) {
        this.proveedor = proveedor;
    }
    
    
    
    public detalleProveedoresAction() {
    }
    
    public String execute() throws Exception {
        ProveedorServiciosWS cliente = new ProveedorServiciosWS();
        GenericType<ProveedorServicios> genericType = new GenericType<ProveedorServicios>(){
        };
        ProveedorServicios data = new ProveedorServicios();
        data = (ProveedorServicios) cliente.find_XML(genericType, Integer.toString(idProveedor));     
         
        proveedor = data;
       
        return SUCCESS;
    }
    
}
