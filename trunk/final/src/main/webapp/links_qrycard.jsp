<%-- 
    Document   : links_qrycard
    Created on : 17-jun-2010, 18:50:00
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<div id="links">
			<ul>
                            <% if (request.getAttribute("tipovisor") == "A") { %>
                            <li>
					<h2>Ingresos y Salidas</h2>
					<ul>
						<li><a href="ConsultaIngresoSalida?querytype=L">Por Periodo</a> <i>(Rango de Fechas)</i></li>
						<li><a href="ConsultaIngresoSalida?querytype=A">Por Asociado</a> <i>(Cliente con Tarjeta)</i></li>
                                                <li><a href="ConsultaIngresoSalida?querytype=P">Por Auto</a> <i>(Número de Placa)</i></li>

					</ul>
				</li>
                            <% } %>
                            <% if (request.getAttribute("tipovisor")  == "C") { %>
                            <li>
					<h2>Consulta de Cliente</h2>
					<ul>
                                                <li><a href="ConsultaSaldos?linktype=saldo">Saldos de Tarjeta</a> <i>(S)</i></li>
						<li><a href="ConsultaSaldos?linktype=movimiento">Consulta Abonados</a> <i>(A)</i></li>
                                                <!--<li><a href="card_balance.jsp">Estado de Cuenta</a> <i>(D)</i></li> -->

					</ul>
				</li>
                            <% } %>
			</ul>
		</div>
