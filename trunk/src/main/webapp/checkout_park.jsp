<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : checkout_park
    Created on : May 25, 2010, 5:44:32 PM
    Author     : oalvarez
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Cierre de Alquiler</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="default.css" rel="stylesheet" type="text/css" />
    </head>
    <body>

        <jsp:include page="header_s.jsp" flush="true|false"/>
        <!-- end #header -->
        <div id="wrapper">
            <div id="content">
                <div id="posts">
                    <div class="post">
                        Bienvenido(a) Usuario <b> ${usuario.nombre} </b>
                        <div class="story">
                            <p> Local Actual: ${usuario.local.nombre}</p>
                        </div>

                    </div>
                    <div class="post">
                        <h2 class="title">Registro de Salida de Autos</h2>
                        <div class="story">
                            <p> Datos del Cliente</p>
                            <form id="frmBuscaAlquiler" action="BuscarAlquiler" method="post">
                                <table>
                                    <tr>
                                        <td>Placa:</td>
                                        <td><input type="text" name="txtPlaca" value='<c:if test="${placa!=''}">${placa}</c:if>' /></td>
                                        <td><input type="submit" value="Buscar" /></td>

                                    </tr>
                                    <tr>
                                        <td>Tarjeta:</td>
                                        <td><input type="text" name="txtTarjeta" value='<c:if test="${tarjeta!=''}">${tarjeta}</c:if>' /></td>
                                        <td><input type="submit" value="Buscar" /></td>
                                    </tr>
                                </table>
                                
                            </form>
${mensaje}
                            <hr />

                            <form id="frmCierraAlquiler" action="SalidaPark" method="post">
                                <p>Datos del Alquiler</p>
                                <table>
                                    <tr>
                                        <td>ID:</td>
                                        <td><input type="text" name="txtId" disabled="true" value='<c:if test="${alquilerB.id!=0}">${alquilerB.id}</c:if>' /></td>
                                    </tr>
                                    <tr>
                                        <td>Fecha:</td>
                                        <td><input type="text" name="txtFecha" disabled="true" value='<c:if test="${alquilerB.fecha!=''}">${alquilerB.fecha}</c:if>' /></td>
                                    </tr>
                                    <tr>
                                        <td>Hora de Inicio</td>
                                        <td><input type="text" name="txtHoraInicio" disabled="true" value='<c:if test="${alquilerB.hora_inicio!=''}">${alquilerB.hora_inicio}</c:if>' /></td>
                                    </tr>
                                    <tr>
                                        <td>Hora de Salida</td>
                                        <td><input type="text" name="txtHoraFin" disabled="true" value='<c:if test="${alquilerB.hora_fin!=''}">${alquilerB.hora_fin}</c:if>' /></td>
                                    </tr>
                                    <tr>
                                        <td>Local:</td>
                                        <td><input type="text" name="txtLocal" disabled="true" value='<c:if test="${alquilerB.local.nombre!=''}">${alquilerB.local.nombre}</c:if>' /></td>
                                    </tr>
                                    <tr>
                                        <td>Monto Total:</td>
                                        <td><input type="text" name="txtMonto" disabled="true" value='<c:if test="${alquilerB.importe!=0.0}">${alquilerB.importe}</c:if>' /></td>
                                    </tr>
                                </table>
                                <hr />
                                <p><input name="btnRegistrar" value="Registrar Salida" type="submit" class="input-normalb"></input></p>
                            </form>

                        </div>

                    </div>
                </div>
                <!-- end #posts -->
                <div id="links">
                    <ul>
                        <li>
                            <h2>Registro</h2>
                            <ul>
                                <li><a href="checkin_park.jsp">Ingreso</a> <i>(Placa)</i></li>
                                <li><a href="checkout_park.jsp">Salida</a> <i>(Placa)</i></li>

                            </ul>
                        </li>
                        <li>
                            <h2>Clientes</h2>
                            <ul>
                                <li><a href="cust_reg.jsp">Nuevo</a> <i>(M)</i></li>
                                <li><a href="cust_edit.jsp">Editar</a> <i>(A)</i></li>
                            </ul>
                        </li>
                        <li>
                            <h2>Locales</h2>
                            <ul>
                                <li><a href="local_reg.jsp">Nuevo</a> <i>(M)</i></li>
                                <li><a href="local_edit.jsp">Editar</a> <i>(A)</i></li>
                            </ul>
                        </li>

                    </ul>
                </div>
                <!-- end #links -->
                <div style="clear: both;">&nbsp;</div>
            </div>
        </div>
        <jsp:include page="footer.jsp" flush="true|false"/>
    </body>
</html>