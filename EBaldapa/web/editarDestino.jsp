<%-- 
    Document   : editarDestino
    Created on : 08-jun-2025, 21:39:32
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
            <h1>Edicion del destino #<s:property value="destino.id"/></h1>
            </header>

        <s:form action="editarDestino">
            <s:hidden name="idDestino" value="%{destino.id}" />
            <s:textfield key="Nombre" name="nombreDestino" value="%{destino.nombre}"/>
            <s:textfield key="País" name="paisDestino" value="%{destino.pais}"/>
            <s:textfield key="Descripción" name="descripcionDestino" value="%{destino.descripcion}"/>
            <s:radio key="Tipo" name="tipoDestino" list="{'Turismo urbano', 'Turismo costero', 'Turismo de montaña'}" value="%{destino.tipo}"/>
            <s:radio key="Temporada" name="temporadaDestino" list="{'Verano', 'Invierno'}" value="%{destino.temporada}"/>

            <s:submit value="Editar destino" />
        </s:form>
          
            
    <s:a action="listarDestinos">Volver al listado</s:a>
    </body>
</html>
