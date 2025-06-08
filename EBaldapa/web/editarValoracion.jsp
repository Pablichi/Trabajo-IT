<%-- 
    Document   : editarValoracion
    Created on : 08-jun-2025, 23:15:24
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
            <h1>Edicion de la valoracion #<s:property value="valoracion.id"/></h1>
            </header>

        <s:form action="editarValoracion">
            <s:hidden name="idValoracion" value="%{valoracion.id}"/>
            <s:radio key="Puntuacion" name="puntuacionValoracion" list="{'0', '1', '2', '3', '4', '5'}" value="%{valoracion.puntuacion}"/>
            <s:textfield key="Comentarios" name="comentariosValoracion" value="%{valoracion.comentario}"/>
            <s:textfield key="Fecha de publicación" name="fechaValoracion" value="%{valoracion.fechaPublicacion}"/>
            
            <s:select  key="Cliente" name="idCliente" list="%{#session.listaClientes}" listValue="nombre" listKey="id" headerKey=""/>
            <s:select  key="Paquete" name="idPaquete" list="%{#session.listaPaquetes}" listValue="titulo" listKey="id" headerKey="" />
            <s:submit value="Crear Valoración" />
        </s:form>
          
            
    <s:a action="listarValoraciones">Volver al listado</s:a>
    </body>
</html>
