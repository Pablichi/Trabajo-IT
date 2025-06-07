<%-- 
    Document   : crearProveedor
    Created on : 07-jun-2025, 21:26:55
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
            
            <h1><s:text name="creacionProveedores">Creacion de Proveedores</s:text></h1>
            </header>

        <s:form action="crearProveedor">
            
            <s:textfield key="Nombre" name="nombreProveedor" />
            <s:radio key="Tipo de Servicio" name="tipoProveedor" list="{'Alojamiento', 'Guía Turístico', 'Ocio'}" />
            <s:textfield key="Contacto" name="contactoProveedor" />
            <s:textfield key="País" name="paisProveedor" />
            <s:textfield key="Comentarios" name="comentariosProveedor" />

            <s:submit value="Crear Proveedor" />
        </s:form>
    
    <s:a action="listarProveedores">Volver al listado</s:a>
    </body>
</html>
