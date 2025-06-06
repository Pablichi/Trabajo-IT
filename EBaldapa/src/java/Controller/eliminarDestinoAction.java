/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.DestinoWS;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Destino;

/**
 *
 * @author DaniMaja
 */
public class eliminarDestinoAction extends ActionSupport {
    
    private int idDestino;

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }
    
    
    public eliminarDestinoAction() {
    }
    
    // Eliminamos el destino de la base de datos,
    // y actualizamos la variable que contiene la lista
    
    public String execute() throws Exception {
        
        DestinoWS destino = new DestinoWS();
        destino.remove(String.valueOf(this.getIdDestino()));

        GenericType<List<Destino>> genericType2 = new GenericType<List<Destino>>() {
        };
        List<Destino> listaDestinos = new ArrayList();
        listaDestinos = (List<Destino>) destino.findAll_XML(genericType2);
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("listaDestinos", listaDestinos);
        return SUCCESS;
        
    }
    
}
