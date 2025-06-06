package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cuenta;
import modelo.Reserva;
import modelo.Valoracion;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-06T17:22:05")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile CollectionAttribute<Cliente, Valoracion> valoracionCollection;
    public static volatile SingularAttribute<Cliente, Integer> id;
    public static volatile CollectionAttribute<Cliente, Reserva> reservaCollection;
    public static volatile SingularAttribute<Cliente, Integer> telefono;
    public static volatile SingularAttribute<Cliente, Cuenta> idCuenta;
    public static volatile SingularAttribute<Cliente, String> nombre;
    public static volatile SingularAttribute<Cliente, String> email;

}