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
        <title>Consultas</title>
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <link href="default.css" rel="stylesheet" type="text/css" />
    </head>
    <body>

        <jsp:include page="header_s.jsp" flush="true|false"/>
        <!-- end #header -->
        <form action="RecargaTarjeta" method="post">
            <div id="wrapper">
                <div id="content">
                    <div id="posts">
                        <div class="post">                            
                            <h2 class="title">Recarga de Tarjeta</h2>
                            <div class="story">
                                <p> Informacion actualizada al ${fechaactual}</p>
                                
                                    <input type="hidden" name="tipo" value="R"/>
                                    <table>
                                        <tr>
                                            <td>Cliente: </td>
                                            <td>${clienterecarga.nombre}</td>
                                        </tr>

                                        <tr>
                                            <td>Saldo Disponible:</td>
                                            <td>${clienterecarga.tarjeta.saldo_disponible} Nuevos Soles</td>
                                        </tr>
                                        <tr>
                                            <td>Monto a Recargar:</td>
                                            <td><input type="text" class="input-normal" name="monto"></input></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td><input type=submit class="input-normal" name="Recargar" value="Recargar"></input></td>
                                        </tr>
                                    </table>

                                
                                ${mensaje}

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
