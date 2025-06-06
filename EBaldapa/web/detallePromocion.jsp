<%-- 
    Document   : detallePromocion
    Created on : 05-jun-2025, 17:17:59
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
        <h1>Detalle de la promoción #<s:property value="promocion.id"/>: <s:property value="promocion.nombrePromocion"/></h1>

        <p>Tipo de descuento: <s:property value="%{promocion.tipoDescuento}"/></p>
        <p>Valor: <s:property value="%{promocion.valorDescuento}"/></p>
        <p>Fecha de inicio: <s:property value="%{promocion.fechaInicio}"/></p>
        <p>Fecha de fin: <s:property value="%{promocion.fechaFinalizacion}"/></p>
        <p>Descripcion: <s:property value="%{promocion.descripcion}"/></p>
        <p>Paquete: <s:property value="%{promocion.idPaquete.titulo}"/></p>
        
        <s:form action="eliminarPromocion">
            <s:hidden name="idPromocion" value="%{promocion.id}" />
            <s:submit key="Eliminar promocion" />
        </s:form>   

    </body>
</html>
