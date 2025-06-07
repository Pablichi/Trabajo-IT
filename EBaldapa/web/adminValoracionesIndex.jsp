<%-- 
    Document   : adminValoracionesIndex
    Created on : 10-may-2025, 2:38:50
    Author     : DaniMaja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="tituloAdminValoraciones"/></title>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="css/estiloListas.css">


    </head>
    <body>
        <header>
            <s:a action="">Índice</s:a>
            <h1><s:text name="adminValoraciones"/></h1>
        </header>

        <h2><s:text name="listaValoraciones"/></h2>
        <div class="container">
      
        <table>
            <s:iterator value="#session.listaValoraciones" var="valoracion">          
                <tr>                  
                    <td>
                        <s:a action="detalleValoracion">
                            <s:param name="idValoracion" value="%{#valoracion.id}" />
                            <s:property value="#valoracion.id" />
                            <s:property value="#valoracion.puntuacion" />
                        </s:a>
                    </td>
                </tr>
            </s:iterator>
        </table>
            
        </div>
        
        
        <div>
            <s:form action="listarProveedores">
                <s:submit key="ver proveedores" />
            </s:form>
        </div>    

    </body>
</html>
