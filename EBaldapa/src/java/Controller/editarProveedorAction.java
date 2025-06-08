/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ProveedorServiciosWS;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.GenericType;
import modelo.ProveedorServicios;

/**
 *
 * @author pabli
 */
public class editarProveedorAction extends ActionSupport {
    
    
    private int idProveedor;
    private String nombreProveedor;
    private String tipoProveedor;
    private String contactoProveedor;
    private String paisProveedor;
    private String comentariosProveedor;

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getTipoProveedor() {
        return tipoProveedor;
    }

    public void setTipoProveedor(String tipoProveedor) {
        this.tipoProveedor = tipoProveedor;
    }

    public String getContactoProveedor() {
        return contactoProveedor;
    }

    public void setContactoProveedor(String contactoProveedor) {
        this.contactoProveedor = contactoProveedor;
    }

    public String getPaisProveedor() {
        return paisProveedor;
    }

    public void setPaisProveedor(String paisProveedor) {
        this.paisProveedor = paisProveedor;
    }

    public String getComentariosProveedor() {
        return comentariosProveedor;
    }

    public void setComentariosProveedor(String comentariosProveedor) {
        this.comentariosProveedor = comentariosProveedor;
    }
    
    
    
    public editarProveedorAction() {
    }
    
    public String execute() throws Exception {
        ProveedorServicios proveedorT = new ProveedorServicios();
        
        proveedorT.setId(idProveedor);
        proveedorT.setNombreEmpresa(nombreProveedor);
        proveedorT.setPais(paisProveedor);
        proveedorT.setTipoServicios(tipoProveedor);
        proveedorT.setContacto(contactoProveedor);
        proveedorT.setComentariosReputacion(comentariosProveedor);
        
        ProveedorServiciosWS proveedorDAO = new ProveedorServiciosWS();
        
        Object obj_paquete = proveedorT;
        proveedorDAO.edit_XML(obj_paquete, String.valueOf(idProveedor));
        
        
        GenericType<List<ProveedorServicios>> genericTypeListado = new GenericType<List<ProveedorServicios>>(){
        };
        List <ProveedorServicios> dataListado = new ArrayList<ProveedorServicios>();
        dataListado = (List<ProveedorServicios>) proveedorDAO.findAll_XML(genericTypeListado);     
         
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaProveedores", dataListado);
        
        return SUCCESS;
    }
    
}
