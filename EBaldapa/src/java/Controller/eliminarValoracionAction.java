/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
    
    private int idValoracion;

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }
    public eliminarValoracionAction() {
    }
    
    public String execute() throws Exception {
        
        ValoracionWS valoracion = new ValoracionWS();
        valoracion.remove(String.valueOf(this.getIdValoracion()));

        GenericType<List<Valoracion>> genericType2 = new GenericType<List<Valoracion>>() {
        };
        List<Valoracion> listaValoraciones = new ArrayList();
        listaValoraciones = (List<Valoracion>) valoracion.findAll_XML(genericType2);
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("listaValoraciones", listaValoraciones);
        return SUCCESS;
        
    }


    
}
