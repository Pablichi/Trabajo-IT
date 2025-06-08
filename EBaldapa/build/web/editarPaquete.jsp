<%-- 
    Document   : editarPaquete
    Created on : 08-jun-2025, 22:00:37
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
            <h1>Edicion del paquete #<s:property value="paquete.id"/></h1>
            </header>

        <s:form action="editarPaquete">
            <s:hidden name="idPaquete" value="%{paquete.id}" />
            <s:textfield key="Titulo" name="tituloPaquete" value="%{paquete.titulo}"/>
            <s:textfield key="Descripción" name="descripcionPaquete" value="%{paquete.descripcion}"/>
            <s:textfield key="Precio" name="precioPaquete" value="%{paquete.precio}"/>
            <s:textfield key="Fecha de salida" name="fechaSalidaPaquete" value="%{paquete.fechaSalida}"/>
            <s:radio key="Duracion" name="duracionPaquete" list="{'15', '7', '3'}" value="%{paquete.duracion}"/>
            <s:radio key="Servicios incluidos" name="serviciosIncluidosPaquete" list="{'Recogida en aeropuerto', 'Maletas extras'}" value="%{paquete.serviciosIncluidos}"/>
            
            <s:select  key="Destino" name="idDestino" list="%{#session.listaDestinos}" listValue="nombre" listKey="id" headerKey=""/>
            <s:select  key="Proveedor" name="idProveedor" list="%{#session.listaProveedores}" listValue="nombreEmpresa" listKey="id" headerKey=""/>
    
            <s:submit value="Editar paquete" />
        </s:form>
          
            
    <s:a action="listarPaquetes">Volver al listado</s:a>
    </body>
</html>
