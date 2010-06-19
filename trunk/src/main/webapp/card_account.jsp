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

        <jsp:include page="header_q.jsp" flush="true|false"/>
        <!-- end #header -->
        <form action="LoginCiente" method="post">
            <div id="wrapper">
                <div id="content">
                    <div id="posts">
                        <div class="post">
                            Bienvenido(a) <b> ${cliente.nombre} </b>
                            <h2 class="title">Resultado de Consulta</h2>
                            <div class="story">
                                <p> Saldo de tarjeta al ${fechaactual}</p>
                                <table>
                                    <tr>
                                        <td>${cliente.tarjeta.saldo_disponible} Nuevos Soles</td>
                                    </tr>
                                    <!--<<tr>
                                        <td><input value="Refrescar" type="submit" class="input-normalb"></input></td>
                                    </tr>-->
                                </table>

                            </div>

                        </div>
                    </div>
                    <!-- end #posts -->
                    <div id="links">
                        <ul>

                            <% if (request.getAttribute("tipovisor") == "A") {%>
                            <li>
                                <h2>Ingresos y Salidas</h2>
                                <ul>
                                    <li><a href="query.jsp">Por Periodo</a> <i>(Rango de Fechas)</i></li>
                                    <li><a href="query_abon.jsp">Por Asociado</a> <i>(Clente registrado)</i></li>
                                    <li><a href="query_placa.jsp">Por Auto</a> <i>(Número de Placa)</i></li>

                                </ul>
                            </li>
                            <% }%>
                            <% if (request.getAttribute("tipovisor") == "C") {%>
                            <li>
                                <h2>Consulta de Tarjeta</h2>
                                <ul>
                                    <li><a href="ConsultaSaldos?idcliente=${cliente.id}">Saldos</a> <i>(M)</i></li>
                                    <li><a href="ConsultaMovimientos?idcliente=${cliente.id}">Movimientos</a> <i>(A)</i></li>
                                    <!--<li><a href="card_balance.jsp">Estado de Cuenta</a> <i>(D)</i></li> -->

                                </ul>
                            </li>
                            <% }%>
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
