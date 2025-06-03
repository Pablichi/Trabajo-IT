package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cliente;
import modelo.Pago;
import modelo.PaqueteTuristico;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-03T23:58:29")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Integer> numeroPersonas;
    public static volatile SingularAttribute<Reserva, String> estado;
    public static volatile SingularAttribute<Reserva, Cliente> idCliente;
    public static volatile SingularAttribute<Reserva, PaqueteTuristico> idPaquete;
    public static volatile SingularAttribute<Reserva, Integer> id;
    public static volatile SingularAttribute<Reserva, Float> precioTotal;
    public static volatile SingularAttribute<Reserva, Date> fechaReserva;
    public static volatile CollectionAttribute<Reserva, Pago> pagoCollection;

}