/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import WS.ClienteWS;
import WS.CuentaWS;
import WS.DestinoWS;
import WS.PagoWS;
import WS.PaqueteTuristicoWS;
import WS.PromocionWS;
import WS.ProveedorServiciosWS;
import WS.ReservaWS;
import WS.ValoracionWS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;
import modelo.Cliente;
import modelo.Cuenta;
import modelo.Destino;
import modelo.Pago;
import modelo.PaqueteTuristico;
import modelo.Promocion;
import modelo.ProveedorServicios;
import modelo.Reserva;
import modelo.Valoracion;

/**
 *
 * @author DaniMaja
 */
public class cargaInicialAction extends ActionSupport {
    
    public cargaInicialAction() {
    }
    
    public String execute() throws Exception {
        
        ClienteWS clienteListado = new ClienteWS();
        GenericType<List<Cliente>> genericTypeListadoCliente = new GenericType<List<Cliente>>(){};
        List <Cliente> dataListadoCliente = new ArrayList<Cliente>();
        dataListadoCliente = (List<Cliente>) clienteListado.findAll_XML(genericTypeListadoCliente);     
        Map <String, Object> session = ActionContext.getContext().getSession();
        session.put("listaClientes", dataListadoCliente);
        
        DestinoWS destinoListado = new DestinoWS();
        GenericType<List<Destino>> genericTypeListadoDestino = new GenericType<List<Destino>>(){};
        List <Destino> dataListadoDestino = new ArrayList<Destino>();
        dataListadoDestino = (List<Destino>) destinoListado.findAll_XML(genericTypeListadoDestino);     
        session.put("listaDestinos", dataListadoDestino);
        
        PagoWS pagoListado = new PagoWS();
        GenericType<List<Pago>> genericTypeListadoPago = new GenericType<List<Pago>>(){};
        List <Pago> dataListadoPago = new ArrayList<Pago>();
        dataListadoPago = (List<Pago>) pagoListado.findAll_XML(genericTypeListadoPago);     
        session.put("listaPagos", dataListadoPago);
        
        PaqueteTuristicoWS paqueteListado = new PaqueteTuristicoWS();
        GenericType<List<PaqueteTuristico>> genericTypeListadoPaquete = new GenericType<List<PaqueteTuristico>>(){};
        List <PaqueteTuristico> dataListadoPaquete = new ArrayList<PaqueteTuristico>();
        dataListadoPaquete = (List<PaqueteTuristico>) paqueteListado.findAll_XML(genericTypeListadoPaquete);     
        session.put("listaPaquetes", dataListadoPaquete);
        
        PromocionWS promocionListado = new PromocionWS();
        GenericType<List<Promocion>> genericTypeListadoPromocion = new GenericType<List<Promocion>>(){};
        List <Promocion> dataListadoPromocion = new ArrayList<Promocion>();
        dataListadoPromocion = (List<Promocion>) promocionListado.findAll_XML(genericTypeListadoPromocion);     
        session.put("listaPromociones", dataListadoPromocion);
        
        ProveedorServiciosWS proveedorListado = new ProveedorServiciosWS();
        GenericType<List<ProveedorServicios>> genericTypeListadoProveedor = new GenericType<List<ProveedorServicios>>(){};
        List <ProveedorServicios> dataListadoProveedor = new ArrayList<ProveedorServicios>();
        dataListadoProveedor = (List<ProveedorServicios>) proveedorListado.findAll_XML(genericTypeListadoProveedor);     
        session.put("listaProveedores", dataListadoProveedor);
        
        ReservaWS reservaListado = new ReservaWS();
        GenericType<List<Reserva>> genericTypeListadoReserva = new GenericType<List<Reserva>>(){};
        List <Reserva> dataListadoReserva = new ArrayList<Reserva>();
        dataListadoReserva = (List<Reserva>) reservaListado.findAll_XML(genericTypeListadoReserva);     
        session.put("listaReservas", dataListadoReserva);
        
        ValoracionWS valoracionListado = new ValoracionWS();
        GenericType<List<Valoracion>> genericTypeListadoValoracion = new GenericType<List<Valoracion>>(){};
        List <Valoracion> dataListadoValoracion = new ArrayList<Valoracion>();
        dataListadoValoracion = (List<Valoracion>) valoracionListado.findAll_XML(genericTypeListadoValoracion);     
        session.put("listaValoraciones", dataListadoValoracion);
        
        CuentaWS cuentaListado = new CuentaWS();
        GenericType<List<Cuenta>> genericTypeListadoCuenta = new GenericType<List<Cuenta>>(){};
        List <Cuenta> dataListadoCuenta = new ArrayList<Cuenta>();
        dataListadoCuenta = (List<Cuenta>) cuentaListado.findAll_XML(genericTypeListadoCuenta);     
        session.put("listaCuentas", dataListadoCuenta);
        
        return SUCCESS;
    }
    
}
