/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author DaniMaja
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(servicios.service.AdministradorFacadeREST.class);
        resources.add(servicios.service.ClienteFacadeREST.class);
        resources.add(servicios.service.CuentaFacadeREST.class);
        resources.add(servicios.service.DestinoFacadeREST.class);
        resources.add(servicios.service.PagoFacadeREST.class);
        resources.add(servicios.service.PaqueteTuristicoFacadeREST.class);
        resources.add(servicios.service.PromocionFacadeREST.class);
        resources.add(servicios.service.ProveedorServiciosFacadeREST.class);
        resources.add(servicios.service.ReservaFacadeREST.class);
        resources.add(servicios.service.ValoracionFacadeREST.class);
    }
    
}
