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
<div id="wrapper">
	<div id="content">
		<div id="posts">
			<div class="post">
			<h2 class="title">Criterios de Consultas</h2>
				<div class="story">
					<p>Ingrese el rango de fechas que desee consultar con el formato DD/MM/YYYY </p>
                                        <table>
                                            <tr>
                                                <td>Desde</td>
                                                <td><input type="text" class="input-normal"></input></td>
                                                <td>Hasta</td>
                                                <td><input type="text" class="input-normal"></input></td>
                                                <td><input value="Consultar" type="submit" class="input-normalb"></input></td>
                                            </tr>
                                        </table>

				</div>
                            <h2 class="title">Resultado de Consulta</h2>
				<div class="story">
					<p> Saldo de tarjeta del 20/05/2010 al 25/05/2010</p>
                                        <table border="0" width="100%"><tr>
                                                <td class = "t1" valign = top width="100%">
                                        <table border="0" width="100%">
                                            <tr>
                                                <td width="25%" class = "et">Ingreso</td>
                                                <td width="25%" class = "et">Salida</td>
                                                <td width="25%" class = "et">Costo</td>
                                                
                                            </tr>
                                            <tr>                                                                                                                                         
                                             <td >21/05/2010 13:00</td>
                                                <td >21/05/2010 13:50</td>
                                                <td >10.00</td>
                                                
                                            </tr>
                                            <tr>
                                             <td >22/05/2010 13:00</td>
                                                <td >22/05/2010 13:50</td>
                                                <td >10.00</td>
                                                
                                            </tr>
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
					<h2>Ingresos y Salidas</h2>
					<ul>
						<li><a href="#">Por Periodo</a> <i>(Rango de Fechas)</i></li>
						<li><a href="#">Por Asociado</a> <i>(Clente registrado)</i></li>
                                                <li><a href="#">Por Auto</a> <i>(Número de Placa)</i></li>

					</ul>
				</li>
                            <li>
					<h2>Consulta de Tarjeta</h2>
					<ul>
                                        <li><a href="card_account.jsp">Saldos</a> <i>(M)</i></li>
						<li><a href="card_mov.jsp">Movimientos</a> <i>(A)</i></li>
                                                <!--<li><a href="card_balance.jsp">Estado de Cuenta</a> <i>(D)</i></li> -->

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
