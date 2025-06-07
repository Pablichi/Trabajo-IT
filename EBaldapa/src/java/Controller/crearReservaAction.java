/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ClienteWS;
import WS.PaqueteTuristicoWS;
import WS.ReservaWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Cliente;
import modelo.PaqueteTuristico;
import modelo.Reserva;

/**
 *
 * @author pabli
 */
public class crearReservaAction extends ActionSupport {
    
    private int personasReserva;
    private String fechaReserva;
    private String estadoReserva;
    private int precioReserva;
    
    private int idCliente;
    private int idPaquete;

    public int getPersonasReserva() {
        return personasReserva;
    }

    public void setPersonasReserva(int personasReserva) {
        this.personasReserva = personasReserva;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public int getPrecioReserva() {
        return precioReserva;
    }

    public void setPrecioReserva(int precioReserva) {
        this.precioReserva = precioReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }
    
    
    
    
    
    public crearReservaAction() {
    }
    
    public String execute() throws Exception {
        System.out.println(idCliente);
        Reserva reservaT = new Reserva();
        
        int idRandom = new Random().nextInt(1000000)+1;
        
        reservaT.setId(idRandom);
        reservaT.setNumeroPersonas(personasReserva);
        reservaT.setPrecioTotal(precioReserva);
        reservaT.setEstado(estadoReserva);
    
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_parseada = format.parse(fechaReserva);
        
        reservaT.setFechaReserva(fecha_parseada);
        
        ReservaWS reservaDAO = new ReservaWS();
        
        ClienteWS clienteDAO = new ClienteWS();
                GenericType<Cliente> genericType = new GenericType<Cliente>(){
        };
        Cliente data = new Cliente();
        data = (Cliente) clienteDAO.find_XML(genericType, Integer.toString(idCliente));     
        
        reservaT.setIdCliente(data);
        
        PaqueteTuristicoWS paqueteDAO = new PaqueteTuristicoWS();
        GenericType<PaqueteTuristico> genericType2 = new GenericType<PaqueteTuristico>(){
        };
        PaqueteTuristico data2 = new PaqueteTuristico();
        data2 = (PaqueteTuristico) paqueteDAO.find_XML(genericType2, Integer.toString(idPaquete));     
         
        
        reservaT.setIdPaquete(data2);
        Object obj_paquete = reservaT;
        reservaDAO.create_XML(obj_paquete);
        
        // creo la nueva lista de paquetes ya con el nuevo paquete incorporado y la paso a la vista
        
        GenericType<List<Reserva>> genericTypeListado = new GenericType<List<Reserva>>(){
        };
        List <Reserva> dataListado = new ArrayList<Reserva>();
        dataListado = (List<Reserva>) reservaDAO.findAll_XML(genericTypeListado);     
         
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaReservas", dataListado);
        
        return SUCCESS;
    }
    
}
