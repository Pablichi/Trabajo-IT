<%-- 
    Document   : clientes
    Created on : 06-jun-2025, 11:03:25
    Author     : DaniMaja
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="tituloAdminClientes"/></title>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="css/estiloListas.css">


    </head>
    <body>
        <header>
            <s:a action="">Índice</s:a>
            <h1><s:text name="adminClientes"/></h1>
        </header>

        <h2><s:text name="listaClientes"/></h2>
        <div class="container">
      
        <table>
            <s:iterator value="#session.listaClientes" var="cliente">          
                <tr>                  
                    <td>
                        <s:a action="detalleCliente">
                            <s:param name="idCliente" value="%{#cliente.id}" />
                            <s:property value="#cliente.id" />
                            <s:property value="#cliente.nombre" />
                        </s:a>
                    </td>
                    
                    <td>
                        <s:a action="editarClienteForm">
                            <s:param name="idCliente" value="%{#cliente.id}" />Editar cliente
                        </s:a>
                    </td>
                </tr>
            </s:iterator>
        </table>
            <s:form action="crearClienteForm">
                <s:submit value="Crear nuevo cliente" />
            </s:form>
        </div>
        
    </body>
</html>
