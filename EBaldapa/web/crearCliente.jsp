<%-- 
    Document   : crearCliente
    Created on : 06-jun-2025, 23:12:31
    Author     : pabli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="css/estiloDetalle.css">
    </head>
    <body>
        <header>
            <s:a action="">Índice</s:a>
            <h1><s:text name="adminClientes">Creacion de Clientes</s:text></h1>
            </header>

        <s:form action="crearCliente">
            
            <s:textfield key="Nombre" name="nombreCliente" />
            <s:textfield key="Email" name="emailCliente" />
            <s:textfield key="Telefono" name="telefonoCliente" />
            <s:textfield key="Direccion" name="direccionCliente" />

            <s:select  key="Cuenta" name="idCuentaCliente" list="%{#session.listaCuentas}" listValue="usuario" listKey="id" headerKey=""/>
            
            <s:submit value="Crear cliente" />
        </s:form>
    
    <s:a action="listarClientes">Volver al listado</s:a>
    </body>
</html>
