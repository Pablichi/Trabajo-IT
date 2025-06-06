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
            <h1><s:text name="tituloAdminDestinos"/></h1>
        </header>

        <h2><s:text name="listaPromociones"/></h2>
        <div class="container">
      
        <table>
            <s:iterator value="#session.listaPromociones" var="promocion">  
                
                <tr>
                    <td>
                        <s:a action="detallePromocion">
                            <s:param name="idPromocion" value="%{#promocion.id}" />
                            <s:property value="#promocion.nombrePromocion" />
                        </s:a>
                    </td>                     
                </tr>
            </s:iterator>
        </table>
        </div>
        
        <div>
            <s:form action="listarPagos">
                <s:submit key="ver pagos" />
            </s:form>
        </div>    
        
    </body>
</html>