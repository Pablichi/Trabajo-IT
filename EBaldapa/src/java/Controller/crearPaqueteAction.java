/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.PaqueteTuristicoWS;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    private Date fechaSalida;
    private String ServiciosIncluidos;
    
    private int idDestino;
    private int idProveedor;
    
    private Destino destino;
    private ProveedorServicios proveedor;

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

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
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
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_parseada = format.parse("1987-05-27");
        paqueteT.setFechaSalida(fecha_parseada);
        
        paqueteT.setDuracion(duracion);
        paqueteT.setPrecio(precio);
        
        paqueteT.setServiciosIncluidos(ServiciosIncluidos);

        //paqueteT.setIdDestino(idDestino);
        //paqueteT.setIdProveedor(proveedor);
        
        PaqueteTuristicoWS paqueteTuristico = new PaqueteTuristicoWS();
        Object obj_paquete = paqueteT;
        paqueteTuristico.create_XML(obj_paquete);
        
        return SUCCESS;
    }
    
}
