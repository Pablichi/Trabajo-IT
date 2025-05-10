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
public class listarDestinosAction extends ActionSupport {
    
    public listarDestinosAction() {
    }
    
    
    // con esta clase hacemos un select * en la base de datos de la tabla destino
    // y volcamos el resultado en data que pasaremos a la sesion
    
    public String execute() throws Exception {
        
        DestinoWS destino = new DestinoWS();
        GenericType<List<Destino>> genericType = new GenericType<List<Destino>>(){
        };
        List <Destino> data = new ArrayList<Destino>();
        data = (List<Destino>) destino.findAll_XML(genericType);
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaDestinos", data);
        return SUCCESS;
    }
    
}
