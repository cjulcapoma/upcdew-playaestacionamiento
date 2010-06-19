<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : clie_reg
    Created on : Jun 19, 2010, 4:04:45 PM
    Author     : oalvarez
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
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
                        Bienvenido(a) Usuario <b> ${usuario.nombre} </b>
                        <div class="story">
                            <p> Local Actual: ${usuario.local.nombre}</p>
                        </div>
                    </div>
                    <div class="post">
                        <h2 class="title">Registro de Clientes</h2>
                        <div class="story">
                            ${mensaje}
                            <br>
                            <br>
                            <table border="0" width="100%"><tr>

                                            <td class = "t1" valign = top width="100%">
                            <table border="0" width="100%">
                                <tr>
                                    <td class = "et">Cliente</td>
                                    <td class = "et">Dirección</td>
                                    <td class = "et"> Teléfono</td>
                                    <td class = "et">Tipo</td>
                                </tr>
                                <c:forEach var="cliente" items="${clientes}">
                                    <tr>
                                        <td>${cliente.nombre}</td>
                                        <td>${cliente.direccion}</td>
                                        <td>${cliente.telefono}</td>
                                        <td>${cliente.tipo_cliente}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                                                </td>
                                            </tr></table>
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
        <jsp:include page="footer.jsp" flush="true|false"/>
    </body>
</html>
