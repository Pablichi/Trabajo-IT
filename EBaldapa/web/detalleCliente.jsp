<%-- 
    Document   : detalleCliente
    Created on : 06-jun-2025, 11:14:39
    Author     : DaniMaja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Detalle del cliente #<s:property value="cliente.id"/></h1>

        <p>Nombre cliente <s:property value="%{cliente.nombre}"/></p>
        <p>Email: <s:property value="%{cliente.email}"/></p>
        <p>Telefono: <s:property value="%{cliente.telefono}"/></p> 
        <p>Direccion: <s:property value="%{cliente.direccion}"/></p>
        
        <s:form action="eliminarCliente">
            <s:param name="idCliente" value="%{#cliente.id}" />
            <s:submit key="Eliminar cliente" />
        </s:form>   

    </body>
</html>