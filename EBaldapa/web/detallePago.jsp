<%-- 
    Document   : detallePago
    Created on : 05-jun-2025, 16:55:32
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
        <h1>Detalle del pago #<s:property value="pago.id"/></h1>

        <p>Fecha de pago: <s:property value="%{pago.fechaPago}"/></p>
        <p>Total: <s:property value="%{pago.total}"/></p>
        <p>Metodo de pago: <s:property value="%{pago.metodoPago}"/></p>
        <p>Estado: <s:property value="%{pago.estado}"/></p>
        <p>Reserva: <s:property value="%{pago.idReserva.id}"/></p>
        
        <s:form action="eliminarPago">
            <s:hidden name="idPago" value="%{pago.id}" />
            <s:submit key="Eliminar pago" />
        </s:form>   
        
        
        <s:a action="listarPagos">Volver al listado</s:a>
    </body>
</html>