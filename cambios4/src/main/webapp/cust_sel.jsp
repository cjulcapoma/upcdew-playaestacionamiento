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
        <title>Inicio de Sesión</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="default.css" rel="stylesheet" type="text/css" />
        <script language="JavaScript" src ="validations.js"> </script>
    </head>
    <body>

        <jsp:include page="header_s.jsp" flush="true|false"/>
        <!-- end #header -->
        <form action="RecargaTarjeta" method="post" name="cust_sel" onsubmit="return validaForm()">
            <div id="wrapper">
                <div id="content">
                    <div id="posts">
                        <div class="post">
                            <h2 class="title">Carga de Saldos</h2>
                            <div class="story">
                                <p>Ingrese el numero de DNI del Cliente</p>
                                <table >
                                    <tr>
                                        <td>DNI</td>
                                        <td><input type="text" class="input-normal" name="cliente" value="43633724"></input></td>
                                    </tr>
                                    <tr>
                                        <td> </td>
                                        <td align="center">
                                            <p></p>
                                            <input type=submit class="input-normal" name="Buscar" value="Buscar"></input>
                                            <input type="hidden" name="tipo" value="B" />
                                        </td>

                                    </tr>

                                    <tr>
                                        <td> </td>
                                        <td align="center">
                                            <p>${errlogin}</p>
                                        </td>

                                    </tr>
                                    </table>

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
                                    <li><a href="cust_edit.jsp">Recargar Tarjeta</a> <i>(T)</i></li>
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
