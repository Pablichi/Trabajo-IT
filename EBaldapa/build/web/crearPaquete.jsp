<%-- 
    Document   : crearPaquete
    Created on : 06-jun-2025, 13:06:37
    Author     : DaniMaja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creacion de Paquetes turisticos</title>
    </head>
    <body>
        <header>
            <h1><s:text name="adminPaquetes">Paquetes Turísticos</s:text></h1>
            </header>

            
 
            
            
        <s:form action="crearPaquete">
            <s:submit value="Crear paquete" />
        </s:form>
    </body>
</html>
