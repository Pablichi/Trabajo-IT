<%-- 
    Document   : detalleDestino
    Created on : 05-jun-2025, 17:24:22
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
        <h1>Detalle del destino #<s:property value="destino.id"/></h1>

        <p>Nombre destino: <s:property value="%{destino.nombre}"/></p>
        <p>Pais: <s:property value="%{destino.pais}"/></p>
        <p>Tipo: <s:property value="%{destino.tipo}"/></p>
        <p>Temporada: <s:property value="%{destino.temporada}"/></p>
        <p>Descripcion: <s:property value="%{destino.descripcion}"/></p>
        
        <s:form action="eliminarDestino">
            <s:hidden name="idDestino" value="%{destino.id}" />
            <s:submit key="Eliminar destino" />
        </s:form>   

    </body>
</html>