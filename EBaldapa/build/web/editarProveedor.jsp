<%-- 
    Document   : editarProveedor
    Created on : 08-jun-2025, 22:24:57
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
            <h1>Edicion del proveedor #<s:property value="proveedor.id"/></h1>
            </header>

        <s:form action="editarProveedor">
            <s:hidden name="idProveedor" value="%{proveedor.id}"/>
            <s:textfield key="Nombre" name="nombreProveedor" value="%{proveedor.nombreEmpresa}"/>
            <s:radio key="Tipo de Servicio" name="tipoProveedor" list="{'Alojamiento', 'Guía Turístico', 'Ocio'}" value="%{proveedor.tipoServicios}"/>
            <s:textfield key="Contacto" name="contactoProveedor" value="%{proveedor.contacto}"/>
            <s:textfield key="País" name="paisProveedor" value="%{proveedor.pais}"/>
            <s:textfield key="Comentarios" name="comentariosProveedor" value="%{proveedor.comentariosReputacion}"/>

            <s:submit value="Editar Proveedor" />
        </s:form>
          
            
    <s:a action="listarProveedores">Volver al listado</s:a>
    </body>
</html>
