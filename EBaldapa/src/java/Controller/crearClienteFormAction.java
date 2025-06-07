/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.CuentaWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Cuenta;


/**
 *
 * @author pabli
 */
public class crearClienteFormAction extends ActionSupport {
    
    public crearClienteFormAction() {
    }
    
    public String execute() throws Exception {
        CuentaWS cuentaDAO = new CuentaWS();
        GenericType<List<Cuenta>> genericType = new GenericType<List<Cuenta>>(){
        };
        List <Cuenta> data = new ArrayList<Cuenta>();
        data = (List<Cuenta>) cuentaDAO.findAll_XML(genericType);
        System.out.println(data);
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaCuentas", data);
        
 
        return SUCCESS;
    }
    
}
