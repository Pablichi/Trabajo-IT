/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.PaqueteTuristicoWS;
import WS.PromocionWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.GenericType;
import modelo.PaqueteTuristico;
import modelo.Promocion;

/**
 *
 * @author pabli
 */
public class crearPromocionAction extends ActionSupport {
    
    private String nombrePromocion;
    private String tipoPromocion;
    private int valorPromocion;
    private String fechaInicioPromocion;
    private String fechaFinPromocion;
    private String descripcionPromocion;
    
    private int idPaquete;

    public String getNombrePromocion() {
        return nombrePromocion;
    }

    public void setNombrePromocion(String nombrePromocion) {
        this.nombrePromocion = nombrePromocion;
    }

    public String getTipoPromocion() {
        return tipoPromocion;
    }

    public void setTipoPromocion(String tipoPromocion) {
        this.tipoPromocion = tipoPromocion;
    }

    public int getValorPromocion() {
        return valorPromocion;
    }

    public void setValorPromocion(int valorPromocion) {
        this.valorPromocion = valorPromocion;
    }

    public String getFechaInicioPromocion() {
        return fechaInicioPromocion;
    }

    public void setFechaInicioPromocion(String fechaInicioPromocion) {
        this.fechaInicioPromocion = fechaInicioPromocion;
    }

    public String getFechaFinPromocion() {
        return fechaFinPromocion;
    }

    public void setFechaFinPromocion(String fechaFinPromocion) {
        this.fechaFinPromocion = fechaFinPromocion;
    }

    public String getDescripcionPromocion() {
        return descripcionPromocion;
    }

    public void setDescripcionPromocion(String descripcionPromocion) {
        this.descripcionPromocion = descripcionPromocion;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }
    
    
    
    
    public crearPromocionAction() {
    }
    
    public String execute() throws Exception {
        Promocion promocionT = new Promocion();
        
        int idRandom = new Random().nextInt(1000000)+1;
        promocionT.setId(idRandom);
        promocionT.setNombrePromocion(nombrePromocion);
        promocionT.setTipoDescuento(tipoPromocion);
        promocionT.setValorDescuento(valorPromocion);
        promocionT.setDescripcion(descripcionPromocion);
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        
        Date fechaInicio_parseada = format.parse(fechaInicioPromocion);
        promocionT.setFechaInicio(fechaInicio_parseada);
        
        Date fechaFin_parseada = format.parse(fechaFinPromocion);
        promocionT.setFechaFinalizacion(fechaFin_parseada);
        
        PromocionWS promocionDAO = new PromocionWS();
        
        PaqueteTuristicoWS paqueteDAO = new PaqueteTuristicoWS();
                GenericType<PaqueteTuristico> genericType = new GenericType<PaqueteTuristico>(){
        };
        PaqueteTuristico data = new PaqueteTuristico();
        data = (PaqueteTuristico) paqueteDAO.find_XML(genericType, Integer.toString(idPaquete));     
         

        promocionT.setIdPaquete(data);

        Object obj_paquete = promocionT;
        promocionDAO.create_XML(obj_paquete);
        
        
        GenericType<List<Promocion>> genericTypeListado = new GenericType<List<Promocion>>(){
        };
        List <Promocion> dataListado = new ArrayList<Promocion>();
        dataListado = (List<Promocion>) promocionDAO.findAll_XML(genericTypeListado);     
         
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaPromociones", dataListado);
        
        return SUCCESS;
    }
    
}
