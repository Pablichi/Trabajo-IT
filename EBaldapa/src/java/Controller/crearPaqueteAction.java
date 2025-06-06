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
    
    private String descripcion;
    private int duracion;
    private String titulo;
    private float precio;
    private String fechaSalida;

    private String ServiciosIncluidos;
    
    private int idDestino;
    private int idProveedor;
    
    private Destino destino;
    private ProveedorServicios proveedor;

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
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

    public String getServiciosIncluidos() {
        return ServiciosIncluidos;
    }

    public void setServiciosIncluidos(String ServiciosIncluidos) {
        this.ServiciosIncluidos = ServiciosIncluidos;
    }
    
    
    public crearPaqueteAction() {
    }
    
    public String execute() throws Exception {
        
        PaqueteTuristico paqueteT = new PaqueteTuristico();
        
        int idRandom;
        idRandom = (int) Math.random();
        
        paqueteT.setId(idRandom);
        paqueteT.setTitulo(titulo);
        paqueteT.setDescripcion(descripcion);
       
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-");
        Date fecha_parseada = format.parse(fechaSalida);
        
        //Date fecha_parseada = ("1987-05-27");
        
        
        paqueteT.setFechaSalida(fecha_parseada);
        
        paqueteT.setDuracion(duracion);
        paqueteT.setPrecio(precio);
        
        paqueteT.setServiciosIncluidos(ServiciosIncluidos);
        
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
    
}
