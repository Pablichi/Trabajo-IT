package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.PaqueteTuristico;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-06T17:22:05")
@StaticMetamodel(ProveedorServicios.class)
public class ProveedorServicios_ { 

    public static volatile SingularAttribute<ProveedorServicios, String> contacto;
    public static volatile SingularAttribute<ProveedorServicios, String> tipoServicios;
    public static volatile SingularAttribute<ProveedorServicios, String> comentariosReputacion;
    public static volatile SingularAttribute<ProveedorServicios, Integer> id;
    public static volatile SingularAttribute<ProveedorServicios, String> nombreEmpresa;
    public static volatile CollectionAttribute<ProveedorServicios, PaqueteTuristico> paqueteTuristicoCollection;
    public static volatile SingularAttribute<ProveedorServicios, String> pais;

}