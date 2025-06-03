package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Reserva;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-03T23:58:29")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, String> metodoPago;
    public static volatile SingularAttribute<Pago, Float> total;
    public static volatile SingularAttribute<Pago, String> estado;
    public static volatile SingularAttribute<Pago, Integer> id;
    public static volatile SingularAttribute<Pago, Date> fechaPago;
    public static volatile SingularAttribute<Pago, Reserva> idReserva;

}