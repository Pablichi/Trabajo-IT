/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.PagoWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Pago;

/**
 *
 * @author DaniMaja
 */
public class eliminarPagoAction extends ActionSupport {
    
    private int pagoId;

    public int getPagoId() {
        return pagoId;
    }

    public void setPagoId(int pagoId) {
        this.pagoId = pagoId;
    }
    
    public eliminarPagoAction() {
    }
    
    public String execute() throws Exception {
        
        PagoWS pago = new PagoWS();
        pago.remove(String.valueOf(this.getPagoId()));

        GenericType<List<Pago>> genericType2 = new GenericType<List<Pago>>() {
        };
        List<Pago> listaPagos = new ArrayList();
        listaPagos = (List<Pago>) pago.findAll_XML(genericType2);
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("listaPagos", listaPagos);
        return SUCCESS;
        
    }
    
}