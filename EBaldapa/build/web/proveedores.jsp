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

        <h2><s:text name="listaProveedores"/></h2>
        <div class="container">
      
        <table>
            <s:iterator value="#session.listaProveedores" var="proveedor">  
                
                <tr>
                    <td>
                        <s:a action="detalleProveedores">
                            <s:param name="idProveedor" value="%{#proveedor.id}" />
                            <s:property value="#proveedor.nombreEmpresa" />
                        </s:a>
                    </td>                     
    
                </tr>
            </s:iterator>
        </table>
        </div>

    </body>
</html>