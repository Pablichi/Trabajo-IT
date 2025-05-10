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
public class listarValoracionesAction extends ActionSupport {
    
    
    public listarValoracionesAction() {
    }
    
    public String execute() throws Exception {
        ValoracionWS valoracion = new ValoracionWS();
        GenericType<List<Valoracion>> genericType = new GenericType<List<Valoracion>>(){
        };
        List <Valoracion> data = new ArrayList<Valoracion>();
        data = (List<Valoracion>) valoracion.findAll_XML(genericType);     
         
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaValoraciones", data);
        return SUCCESS;
    }
    
}
