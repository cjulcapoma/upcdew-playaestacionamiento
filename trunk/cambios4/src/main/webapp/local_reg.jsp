<%-- 
    Document   : local_reg
    Created on : May 25, 2010, 4:50:12 PM
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
        <div id="wrapper">
            <div id="content">
                <div id="posts">
                    <div class="post">
                        <h2 class="title">Registro de Locales</h2>
                        <div class="story">
                            <p> Datos Principales</p>
                            <table>
                                <tr>
                                    <td>ID</td>
                                    <td><input type="text" name="txtId" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Nombre:</td>
                                    <td><input type="text" name="txtNombre" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Dirección:</td>
                                    <td><input type="text" name="txtDireccion" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Teléfono:</td>
                                    <td><input type="text" name="txtTelefono" value="" /> </td>
                                </tr>
                            </table>
                            <hr />
                            <p>Datos de Capacidad</p>
                            <table>
                                <tr>
                                    <td>Cantidad de Espacios:</td>
                                    <td><input type="text" name="txtEspacios" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Tolerancia (En Minutos):</td>
                                    <td><input type="text" name="txtTolerancia" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Precio por Hora:</td>
                                    <td><input type="text" name="txtPrecioHora" value="" /> </td>
                                </tr>
                                <tr>
                                    <td>Porc. de Descuento con Tarjeta:</td>
                                    <td><input type="text" name="txtPorcDscto" value="" /> </td>
                                </tr>
                            </table>
                            <hr />
                            <p><input name="btnRegistrar" value="Registrar" type="submit" class="input-normalb"></input></p>

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