<%-- 
    Document   : adminReservaIndex
    Created on : 04-jun-2025, 0:58:14
    Author     : pabli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="tituloAdminReservas"/></title>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="css/estiloListas.css">
    </head>
    <body>
        <header>
            <s:a action="">Índice</s:a>
            <h1><s:text name="adminReservas"></s:text></h1>
            </header>

            <h2><s:text name="listaReservas"></s:text></h2>
            <table>
            <s:iterator value="#session.listaReservas" var="reserva">
                <tr>                  
                    <td>
                        <s:a action="detalleReserva">
                            <s:param name="idReserva" value="%{#reserva.id}" />
                            <s:property value="#reserva.id" />
                        </s:a>
                    </td>
                </tr>
            </s:iterator>
        </table>
        <s:form action="crearReservaForm">
            <s:submit value="Añadir nueva reserva" />
        </s:form>
    </body>
</html>
