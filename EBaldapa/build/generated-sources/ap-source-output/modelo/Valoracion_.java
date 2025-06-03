package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cliente;
import modelo.PaqueteTuristico;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-03T23:58:29")
@StaticMetamodel(Valoracion.class)
public class Valoracion_ { 

    public static volatile SingularAttribute<Valoracion, Integer> puntuacion;
    public static volatile SingularAttribute<Valoracion, Cliente> idCliente;
    public static volatile SingularAttribute<Valoracion, PaqueteTuristico> idPaquete;
    public static volatile SingularAttribute<Valoracion, Integer> id;
    public static volatile SingularAttribute<Valoracion, String> comentario;
    public static volatile SingularAttribute<Valoracion, Date> fechaPublicacion;

}