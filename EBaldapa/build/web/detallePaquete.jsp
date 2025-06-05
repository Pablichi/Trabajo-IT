<%-- 
    Document   : detallePaquete
    Created on : 04-jun-2025, 20:37:25
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
        <h1>Detalle del paquete Turístico #<s:property value="paquete.id"/>: <s:property value="paquete.titulo"/></h1>

        <p>Descripcion: <s:property value="%{paquete.descripcion}"/></p>
        <p>Fecha de Salida: <s:property value="%{paquete.fechaSalida}"/></p>
        <p>Duración: <s:property value="%{paquete.duracion}"/></p>
        <p>Precio: <s:property value="%{paquete.precio}"/></p>
        <p>Servicios: <s:property value="%{paquete.serviciosIncluidos}"/></p>
        <p>Destino: <s:property value="%{paquete.idDestino.nombre}"/></p>
        <p>Proveedor: <s:property value="%{paquete.idProveedor.nombreEmpresa}"/></p>
        
        <s:form action="eliminarPaquete">
            <s:param name="idPaquete" value="%{#paquete.id}" />
            <s:submit key="Eliminar paquete" />
        </s:form>   

    </body>
</html>
