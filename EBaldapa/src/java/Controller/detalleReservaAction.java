/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ReservaWS;
import com.opensymphony.xwork2.ActionSupport;
import javax.ws.rs.core.GenericType;
import modelo.Reserva;

/**
 *
 * @author pabli
 */
public class detalleReservaAction extends ActionSupport {
    
    private int idReserva;
    private Reserva reserva;

    
    public detalleReservaAction() {
    }
    
    public String execute() throws Exception {
        ReservaWS cliente = new ReservaWS();
        GenericType<Reserva> genericType = new GenericType<Reserva>(){
        };
        Reserva data = new Reserva();
        data = (Reserva) cliente.find_XML(genericType, Integer.toString(idReserva));     
         
        reserva = data;
        return SUCCESS;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    
    
}
