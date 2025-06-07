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
import java.util.Random;
import javax.ws.rs.core.GenericType;
import modelo.Destino;

/**
 *
 * @author pabli
 */
public class crearDestinoAction extends ActionSupport {
    
    private String nombreDestino;
    private String paisDestino;
    private String tipoDestino;
    private String temporadaDestino;
    private String descripcionDestino;

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
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

    public String getDescripcionDestino() {
        return descripcionDestino;
    }

    public void setDescripcionDestino(String descripcionDestino) {
        this.descripcionDestino = descripcionDestino;
    }
    
    
    
    
    public crearDestinoAction() {
    }
    
    public String execute() throws Exception {
        Destino destinoT = new Destino();
        
        int idRandom = new Random().nextInt(1000000)+1;
        destinoT.setId(idRandom);
        destinoT.setNombre(nombreDestino);
        destinoT.setPais(paisDestino);
        destinoT.setTipo(tipoDestino);
        destinoT.setTemporada(temporadaDestino);
        destinoT.setDescripcion(descripcionDestino);
        
        DestinoWS destinoDAO = new DestinoWS();
        
        Object obj_paquete = destinoT;
        destinoDAO.create_XML(obj_paquete);
        
        
        DestinoWS destinoListado = new DestinoWS();
        GenericType<List<Destino>> genericTypeListado = new GenericType<List<Destino>>(){
        };
        List <Destino> dataListado = new ArrayList<Destino>();
        dataListado = (List<Destino>) destinoListado.findAll_XML(genericTypeListado);     
         
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaDestinos", dataListado);
        
        return SUCCESS;
    }
    
}
