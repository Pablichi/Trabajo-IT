package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Administrador;
import modelo.Cliente;

@Generated(value="EclipseLink-2.6.1.v20150605-rNA", date="2025-06-06T17:22:05")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, String> password;
    public static volatile SingularAttribute<Cuenta, String> estado;
    public static volatile CollectionAttribute<Cuenta, Administrador> administradorCollection;
    public static volatile SingularAttribute<Cuenta, String> usuario;
    public static volatile SingularAttribute<Cuenta, Integer> id;
    public static volatile SingularAttribute<Cuenta, Date> ultimoAcceso;
    public static volatile CollectionAttribute<Cuenta, Cliente> clienteCollection;

}