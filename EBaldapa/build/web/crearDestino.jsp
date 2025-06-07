<%-- 
    Document   : crearDestino
    Created on : 07-jun-2025, 20:59:46
    Author     : pabli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
            <h1><s:text name="creacionDestinos">Creacion de Destinos</s:text></h1>
            </header>

        <s:form action="crearDestino">
            
            <s:textfield key="nombre" name="nombreDestino" />
            <s:textfield key="pais" name="paisDestino" />
            <s:textfield key="descripcion" name="descripcionDestino" />
            <s:radio key="tipo" name="tipoDestino" list="{'Turismo urbano', 'Turismo costero', 'Turismo de montaña'}" />
            <s:radio key="temporada" name="temporadaDestino" list="{'Verano', 'Invierno'}" />
            

            <s:submit value="Crear Destino" />
        </s:form>
    
    <s:a action="listarDestinos">Volver al listado</s:a>
    </body>
</html>
