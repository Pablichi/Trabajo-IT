<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="tituloPromociones"/></title>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="css/estiloListas.css">


    </head>
    <body>
        <header>
            <s:a action="">Índice</s:a>
            <h1><s:text name="tituloPromociones"/></h1>
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
                    
                    
                    <td>
                        <s:a action="editarPromocionForm">
                            <s:param name="idPromocion" value="%{#promocion.id}" />Editar promocion
                        </s:a>
                    </td>
                </tr>
            </s:iterator>
        </table>
            <s:form action="crearPromocionForm">
                <s:submit value="Crear nueva promocion" />
            </s:form>
        </div>
        
    </body>
</html>