<%-- 
    Document   : adminDestinoIndex
    Created on : 08-may-2025, 12:32:38
    Author     : DaniMaja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="tituloAdmin"/></title>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="css/estiloListas.css">


    </head>
    <body>
        <header>
            <s:a action="">Índice</s:a>
            <h1><s:text name="tituloAdminDestinos"/></h1>
        </header>

        <h2><s:text name="listaDestinos"/></h2>
        <div class="container">
      
        <table>
            <s:iterator value="#session.listaDestinos" var="destino">  
                <tr>                  
                    <td>
                        <s:a action="detalleDestino">
                            <s:param name="idDestino" value="%{#destino.id}" />
                            <s:property value="#destino.nombre" />
                        </s:a>
                    </td>
                </tr>
            </s:iterator>
        </table>
  
        <div>
            <s:form action="listarValoraciones">
                <s:submit key="ver valoraciones" />
            </s:form>
        </div>  
            <s:form action="listarPaquetes">
                <s:submit key="ver paquetes" />
            </s:form>
        </div>
    </body>
</html>