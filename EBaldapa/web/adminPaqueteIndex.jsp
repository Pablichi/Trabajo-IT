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
        <title><s:text name="tituloPaquete"/></title>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="css/estiloListas.css">
    </head>
    <body>
        <header>
            <s:a action="">Índice</s:a>
            <h1><s:text name="adminPaquetes">Paquetes Turísticos</s:text></h1>
            </header>

            <h2><s:text name="listaPaquetes">Lista de Paquetes Turísticos</s:text></h2>
            <table>
            <s:iterator value="#session.listaPaquetes" var="paquete">
                <tr>                  
                    <td>
                        <s:a action="detallePaquete">
                            <s:param name="idPaquete" value="%{#paquete.id}" />
                            <s:property value="#paquete.titulo" />
                        </s:a>
                    </td>
                </tr>
            </s:iterator>
        </table>
        <s:form action="crearPaqueteForm">
            <s:submit value="Crear nuevo paquete" />
        </s:form>

    </body>
</html>
