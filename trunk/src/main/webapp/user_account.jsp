<%-- 
    Document   : user_account
    Created on : Jun 19, 2010, 12:19:44 PM
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
        <form action="RegistroPark" method="post">
            <div id="wrapper">
                <div id="content">
                    <div id="posts">
                        <div class="post">
                            Bienvenido(a) Usuario <b> ${usuario.nombre} </b>
                            <h2 class="title">Resultado de Consulta</h2>
                            <div class="story">
                                <p> Local Actual: ${usuario.local.nombre}</p>
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
        </form>
        <jsp:include page="footer.jsp" flush="true|false"/>
    </body>
</html>
