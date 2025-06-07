<%-- 
    Document   : crearPaquete
    Created on : 06-jun-2025, 13:06:37
    Author     : DaniMaja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creacion de Paquetes turisticos</title>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="css/estiloDetalle.css">
    </head>
    <body>
        <header>
             <s:a action="">Índice</s:a>
            <h1><s:text name="adminPaquetes">Creacion de Paquetes Turísticos</s:text></h1>
            </header>

        <s:form action="crearPaquete">
            
            <s:textfield key="titulo" name="tituloPaquete" />
            <s:textfield key="descripcion" name="descripcionPaquete" />
            <s:textfield key="precio" name="precioPaquete" />
            <s:textfield key="fechaSalida" name="fechaSalidaPaquete" />
            <s:radio name="duracion" key="duracionPaquete" list="{'15', '7', '3'}" />
            <s:radio name="ServiciosIncluidos" key="ServiciosIncluidosPaquete" list="{'Recogida en aeropuerto', 'Maletas extras'}" />
            
            <s:select  key="Destino" name="idDestino" list="%{#session.listaDestinos}" listValue="nombre" listKey="id" headerKey=""/>
            <s:select  key="Proveedor" name="idProveedor" list="%{#session.listaProveedores}" listValue="nombreEmpresa" listKey="id" headerKey="" />

            <s:submit value="Crear paquete" />
        </s:form>

        <s:a action="listarPaquetes">Volver al listado</s:a>
            
             <h5><a href="<s:url action=""></s:url>">Volver al inicio</a></h5>
    </body>
</html>
