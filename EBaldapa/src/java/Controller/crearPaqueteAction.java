/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.DestinoWS;
import WS.PaqueteTuristicoWS;
import WS.ProveedorServiciosWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.RequiredFieldValidator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Destino;
import modelo.PaqueteTuristico;
import modelo.ProveedorServicios;

/**
 *
 * @author DaniMaja
 */
public class crearPaqueteAction extends ActionSupport {
    
    private String descripcionPaquete;
    private int duracionPaquete;
    private String tituloPaquete;
    private float precioPaquete;
    private String fechaSalidaPaquete;
    private String ServiciosIncluidosPaquete;
    
    private int idDestino;
    private int idProveedor;
    
    private Destino destino;
    private ProveedorServicios proveedor;

    public String getDescripcionPaquete() {
        return descripcionPaquete;
    }

    public void setDescripcionPaquete(String descripcionPaquete) {
        this.descripcionPaquete = descripcionPaquete;
    }

    public int getDuracionPaquete() {
        return duracionPaquete;
    }

    public void setDuracionPaquete(int duracionPaquete) {
        this.duracionPaquete = duracionPaquete;
    }

    public String getTituloPaquete() {
        return tituloPaquete;
    }

    public void setTituloPaquete(String tituloPaquete) {
        this.tituloPaquete = tituloPaquete;
    }

    public float getPrecioPaquete() {
        return precioPaquete;
    }

    public void setPrecioPaquete(float precioPaquete) {
        this.precioPaquete = precioPaquete;
    }

    public String getFechaSalidaPaquete() {
        return fechaSalidaPaquete;
    }

    public void setFechaSalidaPaquete(String fechaSalidaPaquete) {
        this.fechaSalidaPaquete = fechaSalidaPaquete;
    }

    public String getServiciosIncluidosPaquete() {
        return ServiciosIncluidosPaquete;
    }

    public void setServiciosIncluidosPaquete(String ServiciosIncluidosPaquete) {
        this.ServiciosIncluidosPaquete = ServiciosIncluidosPaquete;
    }
    
    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public ProveedorServicios getProveedor() {
        return proveedor;
    }

    public void setProveedor(ProveedorServicios proveedor) {
        this.proveedor = proveedor;
    }
    
    public crearPaqueteAction() {
    }
    
    public String execute() throws Exception {
        
        PaqueteTuristico paqueteT = new PaqueteTuristico();
        
        int idRandom;
        idRandom = (int) Math.random();
        
        paqueteT.setId(idRandom);
        paqueteT.setTitulo(tituloPaquete);
        paqueteT.setDescripcion(descripcionPaquete);
    
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_parseada = format.parse(fechaSalidaPaquete);
        
        paqueteT.setFechaSalida(fecha_parseada);
        
        paqueteT.setDuracion(duracionPaquete);
        paqueteT.setPrecio(precioPaquete);
        
        paqueteT.setServiciosIncluidos(ServiciosIncluidosPaquete);
        
        PaqueteTuristicoWS paqueteTuristico = new PaqueteTuristicoWS();
        
        DestinoWS cliente = new DestinoWS();
                GenericType<Destino> genericType = new GenericType<Destino>(){
        };
        Destino data = new Destino();
        data = (Destino) cliente.find_XML(genericType, Integer.toString(idDestino));     
         
        destino = data;
        
        paqueteT.setIdDestino(destino);
        
        ProveedorServiciosWS ps = new ProveedorServiciosWS();
        GenericType<ProveedorServicios> genericType2 = new GenericType<ProveedorServicios>(){
        };
        ProveedorServicios data2 = new ProveedorServicios();
        data2 = (ProveedorServicios) ps.find_XML(genericType2, Integer.toString(idProveedor));     
         
        proveedor = data2;
        
        paqueteT.setIdProveedor(proveedor);
        
        Object obj_paquete = paqueteT;
        paqueteTuristico.create_XML(obj_paquete);
        
        // creo la nueva lista de paquetes ya con el nuevo paquete incorporado y la paso a la vista
        
        PaqueteTuristicoWS clienteListado = new PaqueteTuristicoWS();
        GenericType<List<PaqueteTuristico>> genericTypeListado = new GenericType<List<PaqueteTuristico>>(){
        };
        List <PaqueteTuristico> dataListado = new ArrayList<PaqueteTuristico>();
        dataListado = (List<PaqueteTuristico>) clienteListado.findAll_XML(genericTypeListado);     
         
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaPaquetes", dataListado);
        
        return SUCCESS;
    }
    
        public void validate(){
        
            if(this.getPrecioPaquete()<50){
                addFieldError("precioPaquete", getText("precioPaquete.error"));
            }

            if(this.getTituloPaquete().isEmpty())
            {
                addFieldError("tituloPaquete", getText("tituloPaquete.error"));
            }
        }
    
    
    
}
