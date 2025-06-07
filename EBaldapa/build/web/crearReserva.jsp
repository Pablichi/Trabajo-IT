<%-- 
    Document   : crearReserva
    Created on : 07-jun-2025, 23:04:48
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
        <header>
            
            <h1><s:text name="creacionReservas">Creacion de Reservas</s:text></h1>
            </header>

        <s:form action="crearReserva">
            
            <s:textfield key="Numero de personas" name="personasReserva" />
            <s:textfield key="estado" name="estadoReserva" />
            <s:textfield key="Precio Total" name="precioReserva" />
            <s:textfield key="Fecha de Reserva" name="fechaReserva" />
            
            <s:select  key="Cliente" name="idCliente" list="%{#session.listaClientes}" listValue="nombre" listKey="id" headerKey=""/>
            <s:select  key="Paquete" name="idPaquete" list="%{#session.listaPaquetes}" listValue="titulo" listKey="id" headerKey="" />
            <s:submit value="Crear Reserva" />
        </s:form>
    
    <s:a action="listarReservas">Volver al listado</s:a>
    </body>
</html>
