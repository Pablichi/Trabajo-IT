/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.DestinoWS;
import WS.ValoracionWS;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Valoracion;

/**
 *
 * @author DaniMaja
 */
public class eliminarValoracionAction extends ActionSupport {
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public eliminarValoracionAction() {
    }
    
    // Eliminamos el destino de la base de datos,
    // y actualizamos la variable que contiene la lista
    
    public String execute() throws Exception {
        
        ValoracionWS valoracion = new ValoracionWS();
        valoracion.remove(String.valueOf(this.getId()));

        GenericType<List<Valoracion>> genericType2 = new GenericType<List<Valoracion>>() {
        };
        List<Valoracion> listaValoraciones = new ArrayList();
        listaValoraciones = (List<Valoracion>) valoracion.findAll_XML(genericType2);
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("listaValoraciones", listaValoraciones);
        return SUCCESS;
        
    }


    
}
