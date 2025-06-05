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
        <title>JSP Page</title>
    </head>
    <body>
         <header>
            <h1><s:text name="adminReservas">Reservas</s:text></h1>
        </header>
        
        <h2><s:text name="listaReservas">Lista de Reservas</s:text></h2>
            <table>
            <s:iterator value="#session.listaReservas" var="reserva">
                <tr>                  
                    <td>
                        <s:property value="#reserva.id"/>
                    </td>
                </tr>
            </s:iterator>
            </table>
        <s:form action="nuevaReservaAction">
            <s:submit value="Añadir nueva reserva" />
        </s:form>
    </body>
</html>
