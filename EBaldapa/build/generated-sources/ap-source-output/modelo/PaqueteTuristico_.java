package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Destino;
import modelo.Promocion;
import modelo.ProveedorServicios;
import modelo.Reserva;
import modelo.Valoracion;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-03T23:58:29")
@StaticMetamodel(PaqueteTuristico.class)
public class PaqueteTuristico_ { 

    public static volatile SingularAttribute<PaqueteTuristico, String> descripcion;
    public static volatile SingularAttribute<PaqueteTuristico, Float> precio;
    public static volatile SingularAttribute<PaqueteTuristico, Date> fechaSalida;
    public static volatile SingularAttribute<PaqueteTuristico, ProveedorServicios> idProveedor;
    public static volatile CollectionAttribute<PaqueteTuristico, Valoracion> valoracionCollection;
    public static volatile SingularAttribute<PaqueteTuristico, String> titulo;
    public static volatile SingularAttribute<PaqueteTuristico, Integer> duracion;
    public static volatile SingularAttribute<PaqueteTuristico, Integer> id;
    public static volatile CollectionAttribute<PaqueteTuristico, Reserva> reservaCollection;
    public static volatile SingularAttribute<PaqueteTuristico, String> serviciosIncluidos;
    public static volatile CollectionAttribute<PaqueteTuristico, Promocion> promocionCollection;
    public static volatile SingularAttribute<PaqueteTuristico, Destino> idDestino;

}