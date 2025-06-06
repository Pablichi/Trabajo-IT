<%-- 
    Document   : detalleProveedor
    Created on : 05-jun-2025, 17:47:16
    Author     : pabli
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
        <h1>Detalle del Proveedor #<s:property value="proveedor.id"/>: <s:property value="proveedor.nombreEmpresa"/></h1>

        <p>Contacto: <s:property value="%{proveedor.contacto}"/></p>
        <p>Pais: <s:property value="%{proveedor.pais}"/></p>
        <p>Tipo de servicio: <s:property value="%{proveedor.tipoServicios}"/></p>
        <p>Comentarios: <s:property value="%{proveedor.comentariosReputacion}"/></p>
        
        <s:form action="eliminarProveedor">
            <s:hidden name="idProveedor" value="%{proveedor.id}" />
            <s:submit key="Eliminar proveedor" />
        </s:form>   

    </body>
</html>
