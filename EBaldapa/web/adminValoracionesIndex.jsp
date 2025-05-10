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
        <title><s:text name="tituloAdmin"/></title>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="css/adminValoracionesIndex.css">


    </head>
    <body>
        <header>
            <h1><s:text name="tituloAdminValoraciones"/></h1>
        </header>

        <h2><s:text name="listaValoraciones"/></h2>
        <div class="container">
      
        <table>
            <s:iterator value="#session.listaValoraciones" var="valoracion">  
                
                <tr>
                    <td>
                        <s:property value="#valoracion.id"/>
                    </td>     
                    
                </tr>
            </s:iterator>
        </table>
            
        </div>
        

    </body>
</html>
