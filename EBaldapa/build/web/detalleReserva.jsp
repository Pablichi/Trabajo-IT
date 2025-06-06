<%-- 
    Document   : detalleReserva
    Created on : 05-jun-2025, 13:44:17
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
        <h1>Detalle de la Reserva #<s:property value="reserva.id"/></h1>

        <p>Fecha: <s:property value="%{reserva.fechaReserva}"/></p>
        <p>Número de personas: <s:property value="%{reserva.numeroPersonas}"/></p>
        <p>Estado: <s:property value="%{reserva.estado}"/></p>
        <p>Precio total: <s:property value="%{reserva.precioTotal}"/></p>
        <p>Cliente: <s:property value="%{reserva.idCliente.nombre}"/></p>
        <p>Paquete: <s:property value="%{reserva.idPaquete.titulo}"/></p>

        
        <s:form action="eliminarReserva">
            <s:hidden name="idReserva" value="%{reserva.id}" />
            <s:submit key="Eliminar reserva" />
        </s:form>   
        
    </body>
</html>
