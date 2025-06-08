<%-- 
    Document   : editarPromocion
    Created on : 08-jun-2025, 23:04:03
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
            <h1>Edicion de la promocion #<s:property value="promocion.id"/></h1>
            </header>

        <s:form action="editarPromocion">
            <s:hidden name="idPromocion" value="%{promocion.id}"/>
            <s:textfield key="Nombre" name="nombrePromocion" value="%{promocion.nombrePromocion}"/>
            <s:textfield key="Valor de descuento" name="valorPromocion" value="%{promocion.valorDescuento}"/>
            <s:textfield key="Fecha de inicio" name="fechaInicioPromocion" value="%{promocion.fechaInicio}"/>
            <s:textfield key="Fecha de fin" name="fechaFinPromocion" value="%{promocion.fechaFinalizacion}"/>
            <s:textfield key="Descripcion" name="descripcionPromocion" value="%{promocion.descripcion}"/>
            <s:radio key="Tipo de descuento" name="tipoPromocion" list="{'Porcentaje', 'Plano'}" value="%{promocion.tipoDescuento}"/>

            <s:select  key="Paquete" name="idPaquete" list="%{#session.listaPaquetes}" listValue="titulo" listKey="id" headerKey=""/>

            <s:submit value="Crear Promocion" />
        </s:form>
          
    <s:a action="listarPromociones">Volver al listado</s:a>
    </body>
</html>
