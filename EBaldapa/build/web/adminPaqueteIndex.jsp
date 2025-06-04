<%-- 
    Document   : adminPaqueteIndex
    Created on : 03-jun-2025, 23:42:28
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
            <h1><s:text name="adminPaquetes">Paquetes Turísticos</s:text></h1>
        </header>
        
        <h2><s:text name="listaPaquetes">Lista de Paquetes Turísticos</s:text></h2>
            <table>
            <s:iterator value="#session.listaPaquetes" var="paquete">
                <tr>                  
                    <td><%--
                        <s:url var="paquete" action="detallePaqueteAction">
                            <s:param name="nombrePaquete" value="%{#paquete.titulo}" />
                        </s:url>
                        --%>
                        <s:property value="#paquete.titulo"/>
                    </td>
                </tr>
            </s:iterator>
            </table>
        <s:form action="nuevoPaqueteAction">
            <s:submit value="Añadir nuevo paquete" />
        </s:form>
            
            
        <s:form action="listarReservas">
                <s:submit key="ver reservas" />
        </s:form>    
    </body>
</html>
