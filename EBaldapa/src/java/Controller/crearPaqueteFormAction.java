/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.DestinoWS;
import WS.ProveedorServiciosWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Destino;
import modelo.ProveedorServicios;

/**
 *
 * @author DaniMaja
 */
public class crearPaqueteFormAction extends ActionSupport {
    
    public crearPaqueteFormAction() {
    }
    
    public String execute() throws Exception {
       
        // en el formulario de creacion de paquetes deben de aparecer dos combos, uno de lista de destinos y otro de lista de proveedores
        
        DestinoWS destino = new DestinoWS();
        GenericType<List<Destino>> genericType = new GenericType<List<Destino>>(){
        };
        List <Destino> data = new ArrayList<Destino>();
        data = (List<Destino>) destino.findAll_XML(genericType);
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaDestinos", data);
        
        ProveedorServiciosWS proveedor = new ProveedorServiciosWS();
        GenericType<List<ProveedorServicios>> genericType2 = new GenericType<List<ProveedorServicios>>(){
        };
        List <ProveedorServicios> data2 = new ArrayList<ProveedorServicios>();
        data2 = (List<ProveedorServicios>) proveedor.findAll_XML(genericType2);
        session.put("listaProveedores", data2);
        
        return SUCCESS;
    }
    
}
