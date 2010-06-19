<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : checkin_park
    Created on : May 25, 2010, 5:44:23 PM
    Author     : oalvarez
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Registro de Clientes</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="default.css" rel="stylesheet" type="text/css" />
    </head>
    <body>

        <jsp:include page="header_s.jsp" flush="true|false"/>
        <!-- end #header -->
        <form action="RegistroPark" method="post">
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
                            <h2 class="title">Registro de Ingreso de Autos</h2>
                            <div class="story">
                                <p> Datos del Cliente</p>
                                <table>
                                    <tr>
                                        <td>Placa:</td>
                                        <td><input type="text" name="txtPlaca" value='<c:if test="${Alquiler.placa!=''}">${Alquiler.placa}</c:if>' /></td>
                                    </tr>
                                </table>
                                <hr />
                                <p>Datos del Alquiler</p>
                                <table>
                                    <tr>
                                        <td>Fecha:</td>
                                        <td><input type="text" name="txtFecha" disabled="true" value='<c:if test="${Alquiler.fecha!=''}">${Alquiler.fecha}</c:if>' /></td>
                                    </tr>
                                    <tr>
                                        <td>Hora de Inicio:</td>
                                        <td><input type="text" name="txtHoraInicio" disabled="true" value='<c:if test="${Alquiler.fecha!=''}">${Alquiler.hora_inicio}</c:if>' /></td>
                                    </tr>
                                    <tr>
                                        <td>Local:</td>
                                        <td><input type="text" name="txtLocal" disabled="true" value='<c:if test="${Alquiler.local.nombre!=''}">${Alquiler.local.nombre}</c:if>' /></td>
                                    </tr>
                                    <tr>
                                        <td> </td>
                                        <td align="center">
                                            <p>${mensaje}</p>
                                        </td>

                                    </tr>
                                </table>
                                <hr />
                                <p><input name="btnRegistrar" value="Registrar Ingreso" type="submit" class="input-normalb"></input></p>

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
                                    <!--<li><a href="cust_edit.jsp">Editar</a> <i>(A)</i></li>-->
                                    <li><a href="cust_sel.jsp">Recargar Tarjeta</a> <i>(T)</i></li>
                                </ul>
                            </li>
                            

                        </ul>
                    </div>
                    <!-- end #links -->
                    <div style="clear: both;">&nbsp;</div>
                </div>
            </div>
        </form>
        <jsp:include page="footer.jsp" flush="true|false"/>
    </body>
</html>