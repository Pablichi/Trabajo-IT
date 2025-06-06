<%-- 
    Document   : index.jsp
    Created on : 06-jun-2025, 10:54:02
    Author     : DaniMaja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="tituloIndex"/></title>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="css/estiloIndex.css">

    </head>
    <body>
        <header>
            <h1><s:text name="tituloIndex"/></h1>
        </header>
            <div class="container">
                <div class="column">
                    <s:form action="listarClientes">
                        <s:submit key="cli" />
                    </s:form>
                    <s:form action="listarPaquetes">
                        <s:submit key="paq" />
                    </s:form>
                    <s:form action="listarDestinos">
                        <s:submit key="des" />
                    </s:form>
                    <s:form action="listarProveedores">
                        <s:submit key="prov" />
                    </s:form>
                </div>

                <div class="column">
                    <s:form action="listarReservas">
                        <s:submit key="res" />
                    </s:form>
                    <s:form action="listarPagos">
                        <s:submit key="pag" />
                    </s:form>
                    <s:form action="listarPromociones">
                        <s:submit key="prom" />
                    </s:form>
                    <s:form action="listarValoraciones">
                        <s:submit key="val" />
                    </s:form>
                </div>
            </div>
    </body>
</html>
