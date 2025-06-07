<%-- 
    Document   : crearPago
    Created on : 08-jun-2025, 0:05:59
    Author     : pabli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/estiloDetalle.css">
    </head>
    <body>
        <header>
            <s:a action="">Índice</s:a>
            <h1><s:text name="creacionPagos">Creacion de Pagos</s:text></h1>
            </header>

        <s:form action="crearPago">
            
            <s:textfield key="Fecha" name="fechaPago" />
            <s:textfield key="Total" name="totalPago" />
            <s:textfield key="Estado" name="estadoPago" />
            <s:radio key="Metodo de Pago" name="metodoPago" list="{'Pago en efectivo', 'Pago con tarjeta'}" />

            <s:select  key="Reserva" name="idReserva" list="%{#session.listaReservas}" listValue="id" listKey="id" headerKey=""/>

            <s:submit value="Crear Pago" />
        </s:form>
    
    <s:a action="listarPagos">Volver al listado</s:a>
    </body>
</html>
