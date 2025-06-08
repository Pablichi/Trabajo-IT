<%-- 
    Document   : editarCliente
    Created on : 08-jun-2025, 20:17:26
    Author     : DaniMaja
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
            <h1>Edicion del cliente #<s:property value="cliente.id"/></h1>
            </header>

        <s:form action="editarCliente">
            
            <s:textfield key="Nombre" name="nombreCliente" /><s:property value="%{cliente.nombre}"/>
            <s:textfield key="Email" name="emailCliente" /><s:property value="%{cliente.email}"/>
            <s:textfield key="Telefono" name="telefonoCliente" /><s:property value="%{cliente.telefono}"/>
            <s:textfield key="Direccion" name="direccionCliente" /> <s:property value="%{cliente.direccion}"/>

            <s:select  key="Cuenta" name="idCuentaCliente" list="%{#session.listaCuentas}" listValue="usuario" listKey="id" headerKey=""/>
    
            <s:submit value="Editar cliente" />
        </s:form>
          
            
    <s:a action="listarClientes">Volver al listado</s:a>
    </body>
</html>
