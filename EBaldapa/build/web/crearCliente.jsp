<%-- 
    Document   : crearCliente
    Created on : 06-jun-2025, 23:12:31
    Author     : pabli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            
            <h1><s:text name="adminClientes">Creacion de Clientes</s:text></h1>
            </header>

        <s:form action="crearCliente">
            
            <s:textfield key="nombre" name="nombre" />
            <s:textfield key="email" name="email" />
            <s:textfield key="telefono" name="telefono" />
            <s:textfield key="direccion" name="direccion" />

            <s:select  key="Cuenta" name="idCuenta" list="%{#session.listaCuentas}" listValue="nombre" listKey="id" headerKey=""/>
            
            <s:submit value="Crear cliente" />
        </s:form>
    
    <s:a action="listarClientes">Volver al listado</s:a>
    </body>
</html>
