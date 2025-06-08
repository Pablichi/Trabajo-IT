<%-- 
    Document   : editarReserva
    Created on : 08-jun-2025, 22:42:18
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
            <h1>Edicion de la reserva #<s:property value="reserva.id"/></h1>
            </header>

        <s:form action="editarReserva">
            <s:hidden name="idReserva" value="%{reserva.id}"/>
            <s:textfield key="Numero de personas" name="personasReserva" value="%{reserva.numeroPersonas}"/>
            <s:textfield key="Estado" name="estadoReserva" value="%{reserva.estado}"/>
            <s:textfield key="Precio Total" name="precioReserva" value="%{reserva.precioTotal}"/>
            <s:textfield key="Fecha de Reserva" name="fechaReserva" value="%{reserva.fechaReserva}"/>
            
            <s:select  key="Cliente" name="idCliente" list="%{#session.listaClientes}" listValue="nombre" listKey="id" headerKey=""/>
            <s:select  key="Paquete" name="idPaquete" list="%{#session.listaPaquetes}" listValue="titulo" listKey="id" headerKey="" />
            <s:submit value="Editar Reserva" />
        </s:form>
          
            
    <s:a action="listarReservas">Volver al listado</s:a>
    </body>
</html>
