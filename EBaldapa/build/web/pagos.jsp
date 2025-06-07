<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="tituloAdminPagos"/></title>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="css/estiloListas.css">


    </head>
    <body>
        <header>
            <s:a action="">Índice</s:a>
            <h1><s:text name="adminPagos"/></h1>
        </header>

        <h2><s:text name="listaPagos"/></h2>
        <div class="container">
      
        <table>
            <s:iterator value="#session.listaPagos" var="pago">  
                <tr>                  
                    <td>
                        <s:a action="detallePago">
                            <s:param name="idPago" value="%{#pago.id}" />
                            <s:property value="#pago.metodoPago" />
                        </s:a>
                    </td>
                </tr>
            </s:iterator>
        </table>
            
            <s:form action="crearPagoForm">
                <s:submit value="Crear nuevo pago" />
            </s:form>
        </div>

    </body>
</html>