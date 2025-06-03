package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.PaqueteTuristico;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-03T23:58:29")
@StaticMetamodel(Destino.class)
public class Destino_ { 

    public static volatile SingularAttribute<Destino, String> descripcion;
    public static volatile SingularAttribute<Destino, String> tipo;
    public static volatile SingularAttribute<Destino, String> temporada;
    public static volatile SingularAttribute<Destino, Integer> id;
    public static volatile SingularAttribute<Destino, String> nombre;
    public static volatile CollectionAttribute<Destino, PaqueteTuristico> paqueteTuristicoCollection;
    public static volatile SingularAttribute<Destino, String> pais;

}