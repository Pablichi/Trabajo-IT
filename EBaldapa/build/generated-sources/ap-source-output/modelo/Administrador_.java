package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Cuenta;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-03T23:58:29")
@StaticMetamodel(Administrador.class)
public class Administrador_ { 

    public static volatile SingularAttribute<Administrador, String> rolPermisos;
    public static volatile SingularAttribute<Administrador, Integer> id;
    public static volatile SingularAttribute<Administrador, String> nombreUsuario;
    public static volatile SingularAttribute<Administrador, Cuenta> idCuenta;
    public static volatile SingularAttribute<Administrador, String> email;

}