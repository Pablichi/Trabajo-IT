<%-- 
    Document   : crearValoracion
    Created on : 08-jun-2025, 1:28:42
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
            <h1><s:text name="creacionValoraciones">Creacion de Valoraciones</s:text></h1>
            </header>

        <s:form action="crearValoracion">
            
            <s:radio key="Puntuacion" name="puntuacionValoracion" list="{'0', '1', '2', '3', '4', '5'}" />
            <s:textfield key="Comentarios" name="comentariosValoracion" />
            <s:textfield key="Fecha de publicación" name="fechaValoracion" />
            
            <s:select  key="Cliente" name="idCliente" list="%{#session.listaClientes}" listValue="nombre" listKey="id" headerKey=""/>
            <s:select  key="Paquete" name="idPaquete" list="%{#session.listaPaquetes}" listValue="titulo" listKey="id" headerKey="" />
            <s:submit value="Crear Valoración" />
        </s:form>
    </body>
</html>
