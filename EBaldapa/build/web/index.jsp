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
        <title><s:text name="tituloAPP"/></title>
        <s:head/>
        <link rel="stylesheet" type="text/css" href="css/adminDestinoIndex.css">

    </head>
    <body>
        <header>
            <h1><s:text name="tituloIndex"/></h1>
        </header>
            <div class="container">
                <div class="column">
                    <s:form action="listarClientes">
                        <s:submit key="Clientes" />
                    </s:form>
                    <s:form action="listarPaquetes">
                        <s:submit key="Paquetes" />
                    </s:form>
                    <s:form action="listarDestinos">
                        <s:submit key="Destinos" />
                    </s:form>
                    <s:form action="listarProveedores">
                        <s:submit key="Proveedores" />
                    </s:form>
                </div>

                <div class="column">
                    <s:form action="listarReservas">
                        <s:submit key="Reservas" />
                    </s:form>
                    <s:form action="listarPagos">
                        <s:submit key="Pagos" />
                    </s:form>
                    <s:form action="listarPromociones">
                        <s:submit key="Promociones" />
                    </s:form>
                    <s:form action="listarValoraciones">
                        <s:submit key="Valoraciones" />
                    </s:form>
                </div>
            </div>
    </body>
</html>
