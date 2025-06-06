package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.PaqueteTuristico;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-06T17:22:05")
@StaticMetamodel(Promocion.class)
public class Promocion_ { 

    public static volatile SingularAttribute<Promocion, String> descripcion;
    public static volatile SingularAttribute<Promocion, Float> valorDescuento;
    public static volatile SingularAttribute<Promocion, Date> fechaInicio;
    public static volatile SingularAttribute<Promocion, String> tipoDescuento;
    public static volatile SingularAttribute<Promocion, PaqueteTuristico> idPaquete;
    public static volatile SingularAttribute<Promocion, Integer> id;
    public static volatile SingularAttribute<Promocion, String> nombrePromocion;
    public static volatile SingularAttribute<Promocion, Date> fechaFinalizacion;

}