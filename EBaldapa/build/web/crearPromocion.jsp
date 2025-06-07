<%-- 
    Document   : crearPromocion
    Created on : 08-jun-2025, 0:44:14
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
            <h1><s:text name="creacionPromociones">Creacion de Promociones</s:text></h1>
            </header>

        <s:form action="crearPromocion">
            
            <s:textfield key="Nombre" name="nombrePromocion" />
            <s:textfield key="Valor de descuento" name="valorPromocion" />
            <s:textfield key="Fecha de inicio" name="fechaInicioPromocion" />
            <s:textfield key="Fecha de fin" name="fechaFinPromocion" />
            <s:textfield key="Descripcion" name="descripcionPromocion" />
            <s:radio key="Tipo de descuento" name="tipoPromocion" list="{'Porcentaje', 'Plano'}" />

            <s:select  key="Paquete" name="idPaquete" list="%{#session.listaPaquetes}" listValue="titulo" listKey="id" headerKey=""/>

            <s:submit value="Crear Promocion" />
        </s:form>
    
    <s:a action="listarPromociones">Volver al listado</s:a>
    </body>
</html>
