/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ReservaWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Reserva;

/**
 *
 * @author pabli
 */
public class eliminarReservaAction extends ActionSupport {
    
    private int idReserva;
    
    public eliminarReservaAction() {
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    
    
    
    public String execute() throws Exception {
        ReservaWS cliente = new ReservaWS();
        cliente.remove(String.valueOf(this.getIdReserva()));

        GenericType<List<Reserva>> genericType2 = new GenericType<List<Reserva>>() {
        };
        List<Reserva> listaReservas = new ArrayList();
        listaReservas = (List<Reserva>) cliente.findAll_XML(genericType2);
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.put("listaReservas", listaReservas);
        return SUCCESS;
    }
    
}
