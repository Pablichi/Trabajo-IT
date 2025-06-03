<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="tituloAdmin"/></title>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="css/adminDestinoIndex.css">


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
                        <s:property value="#promocion.nombrePromocion"/>
                    </td>                     
                </tr>
            </s:iterator>
        </table>
        </div>
    </body>
</html>