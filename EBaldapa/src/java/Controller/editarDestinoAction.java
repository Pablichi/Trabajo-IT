/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.DestinoWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Destino;

/**
 *
 * @author pabli
 */
public class editarDestinoAction extends ActionSupport {
    
    private String nombreDestino;
    private int idDestino;
    private String paisDestino;
    private String descripcionDestino;
    private String tipoDestino;
    private String temporadaDestino;

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }
    
    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public String getDescripcionDestino() {
        return descripcionDestino;
    }

    public void setDescripcionDestino(String descripcionDestino) {
        this.descripcionDestino = descripcionDestino;
    }

    public String getTipoDestino() {
        return tipoDestino;
    }

    public void setTipoDestino(String tipoDestino) {
        this.tipoDestino = tipoDestino;
    }

    public String getTemporadaDestino() {
        return temporadaDestino;
    }

    public void setTemporadaDestino(String temporadaDestino) {
        this.temporadaDestino = temporadaDestino;
    }
    
    
    
    public editarDestinoAction() {
    }
    
    public String execute() throws Exception {
        Destino destinoT = new Destino();
        
        destinoT.setId(idDestino);
        destinoT.setNombre(nombreDestino);
        destinoT.setPais(paisDestino);
        destinoT.setDescripcion(descripcionDestino);
        destinoT.setTipo(tipoDestino);
        destinoT.setTemporada(temporadaDestino);
        
        DestinoWS destinoDAO = new DestinoWS();
             
         
        Object obj_paquete = destinoT;
        System.out.println(this.descripcionDestino);
        System.out.println(this.idDestino);
        System.out.println(this.paisDestino);
        System.out.println(this.temporadaDestino);
        System.out.println(this.tipoDestino);
        System.out.println(this.nombreDestino);
        
        destinoDAO.edit_XML(obj_paquete, Integer.toString(idDestino));
        
        GenericType<List<Destino>> genericTypeListado = new GenericType<List<Destino>>(){
        };
        List <Destino> dataListado = new ArrayList<Destino>();
        dataListado = (List<Destino>) destinoDAO.findAll_XML(genericTypeListado);     
         
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaDestinos", dataListado);
        
        return SUCCESS;
    }
    
}
