/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.PaqueteTuristicoWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.PaqueteTuristico;

/**
 *
 * @author pabli
 */
public class eliminarPaqueteAction extends ActionSupport {
    
    private int idPaquete;

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }
    
    public eliminarPaqueteAction() {
    }
    
    public String execute() throws Exception {
        PaqueteTuristicoWS cliente = new PaqueteTuristicoWS();
        cliente.remove(Integer.toString(this.getIdPaquete()));

        GenericType<List<PaqueteTuristico>> genericType2 = new GenericType<List<PaqueteTuristico>>() {
        };
        List<PaqueteTuristico> listaPaquetes = new ArrayList();
        listaPaquetes = (List<PaqueteTuristico>) cliente.findAll_XML(genericType2);
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("listaPaquetes", listaPaquetes);
        return SUCCESS;
    }
    
}
