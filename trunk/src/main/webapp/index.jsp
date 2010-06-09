<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License
-->
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Inicio</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="default.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="header_i.jsp" flush="true|false"/>
        <!-- end #header -->
        <div id="wrapper">
            <div id="content">
                <div id="posts">
                    <div class="post">
                        <h2 class="title">Control de Ingresos y Salidas</h2>
                        <div class="story">
                            <p>Registro de Ingreso</p>
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
