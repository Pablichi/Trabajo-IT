<%-- 
    Document   : editarPago
    Created on : 08-jun-2025, 22:54:04
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
            <h1>Edicion del pago #<s:property value="pago.id"/></h1>
            </header>

        <s:form action="editarPago">
            <s:hidden name="idPago" value="%{pago.id}" />
            <s:textfield key="Fecha" name="fechaPago" value="%{pago.fechaPago}"/>
            <s:textfield key="Total" name="totalPago" value="%{pago.total}"/>
            <s:textfield key="Estado" name="estadoPago" value="%{pago.estado}"/>
            <s:radio key="Metodo de Pago" name="metodoPago" list="{'Pago en efectivo', 'Pago con tarjeta'}" value="%{pago.metodoPago}"/>

            <s:select  key="Reserva" name="idReserva" list="%{#session.listaReservas}" listValue="id" listKey="id" headerKey=""/>

            <s:submit value="Editar Pago" />
        </s:form>
          
            
    <s:a action="listarPagos">Volver al listado</s:a>
    </body>
</html>
