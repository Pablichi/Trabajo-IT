/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ClienteWS;
import WS.PaqueteTuristicoWS;
import WS.ValoracionWS;
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
import modelo.Cliente;
import modelo.PaqueteTuristico;
import modelo.Valoracion;

/**
 *
 * @author pabli
 */
public class editarValoracionAction extends ActionSupport {
    
    private int idValoracion;
    private int puntuacionValoracion;
    private String comentariosValoracion;
    private String fechaValoracion;
    
    private int idCliente;
    private int idPaquete;

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

    public int getPuntuacionValoracion() {
        return puntuacionValoracion;
    }

    public void setPuntuacionValoracion(int puntuacionValoracion) {
        this.puntuacionValoracion = puntuacionValoracion;
    }

    public String getComentariosValoracion() {
        return comentariosValoracion;
    }

    public void setComentariosValoracion(String comentariosValoracion) {
        this.comentariosValoracion = comentariosValoracion;
    }

    public String getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(String fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
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
    
    
    
    
    public editarValoracionAction() {
    }
    
    public String execute() throws Exception {
        Valoracion valoracionT = new Valoracion();
        
        valoracionT.setId(idValoracion);
        valoracionT.setPuntuacion(puntuacionValoracion);
        valoracionT.setComentario(comentariosValoracion);
    
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_parseada = format.parse(fechaValoracion);
        
        valoracionT.setFechaPublicacion(fecha_parseada);
        
        ValoracionWS valoracionDAO = new ValoracionWS();
        
        ClienteWS clienteDAO = new ClienteWS();
                GenericType<Cliente> genericType = new GenericType<Cliente>(){
        };
        Cliente data = new Cliente();
        data = (Cliente) clienteDAO.find_XML(genericType, Integer.toString(idCliente));     
        
        valoracionT.setIdCliente(data);
        
        PaqueteTuristicoWS paqueteDAO = new PaqueteTuristicoWS();
        GenericType<PaqueteTuristico> genericType2 = new GenericType<PaqueteTuristico>(){
        };
        PaqueteTuristico data2 = new PaqueteTuristico();
        data2 = (PaqueteTuristico) paqueteDAO.find_XML(genericType2, Integer.toString(idPaquete));     
         
        
        valoracionT.setIdPaquete(data2);
        Object obj_paquete = valoracionT;
        valoracionDAO.edit_XML(obj_paquete, String.valueOf(idValoracion));
        
        // creo la nueva lista de paquetes ya con el nuevo paquete incorporado y la paso a la vista
        
        GenericType<List<Valoracion>> genericTypeListado = new GenericType<List<Valoracion>>(){
        };
        List <Valoracion> dataListado = new ArrayList<Valoracion>();
        dataListado = (List<Valoracion>) valoracionDAO.findAll_XML(genericTypeListado);     
         
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaValoraciones", dataListado);
        
        return SUCCESS;
    }
    
}
