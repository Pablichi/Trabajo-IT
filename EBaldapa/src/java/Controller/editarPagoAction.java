/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.PagoWS;
import WS.ReservaWS;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.GenericType;
import modelo.Pago;
import modelo.Reserva;

/**
 *
 * @author pabli
 */
public class editarPagoAction extends ActionSupport {
    
    private int idPago;
    private String fechaPago;
    private float totalPago;
    private String estadoPago;
    private String metodoPago;
    private int idReserva;

    public float getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(float totalPago) {
        this.totalPago = totalPago;
    }
    
    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    
    
    
    public editarPagoAction() {
    }
    
    public String execute() throws Exception {
        Pago pagoT = new Pago();
        
        pagoT.setId(idPago);
        pagoT.setTotal(totalPago);
        pagoT.setEstado(estadoPago);
        pagoT.setMetodoPago(metodoPago);
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_parseada = format.parse(fechaPago);
        
        pagoT.setFechaPago(fecha_parseada);
        
        PagoWS pagoDAO = new PagoWS();
        
        ReservaWS reservaDAO = new ReservaWS();
                GenericType<Reserva> genericType = new GenericType<Reserva>(){
        };
        Reserva data = new Reserva();
        data = (Reserva) reservaDAO.find_XML(genericType, Integer.toString(idReserva));     
         

        pagoT.setIdReserva(data);
        Object obj_paquete = pagoT;
        pagoDAO.edit_XML(obj_paquete, String.valueOf(idPago));
        
        
        GenericType<List<Pago>> genericTypeListado = new GenericType<List<Pago>>(){
        };
        List <Pago> dataListado = new ArrayList<Pago>();
        dataListado = (List<Pago>) pagoDAO.findAll_XML(genericTypeListado);     
         
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaPagos", dataListado);
        
        return SUCCESS;
    }
    
}
