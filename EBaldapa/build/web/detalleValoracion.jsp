<%-- 
    Document   : detalleValoracion
    Created on : 05-jun-2025, 17:56:10
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
        <h1>Detalle de la valoracion #<s:property value="valoracion.id"/></h1>

        <p>Puntuacion: <s:property value="%{valoracion.puntuacion}"/></p>
        <p>Comentarios: <s:property value="%{valoracion.comentario}"/></p>
        <p>Fecha publicacion: <s:property value="%{valoracion.fechaPublicacion}"/></p>

        <p>Cliente: <s:property value="%{valoracion.idCliente.nombre}"/></p>
        <p>Paquete turistico: <s:property value="%{valoracion.idPaquete.titulo}"/></p>
        
        <s:form action="eliminarValoracion">
            <s:hidden name="idValoracion" value="%{valoracion.id}" />
            <s:submit key="Eliminar valoracion" />
        </s:form>

        
        <s:a action="listarValoraciones">Volver al listado</s:a>
    </body>
</html>
