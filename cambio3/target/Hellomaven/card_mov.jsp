<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"
          prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"
          prefix="fmt" %>

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
<script language="JavaScript" src ="validations.js"> </script>
</head>
<body>
<jsp:include page="header_q.jsp" flush="true|false"/>
<!-- end #header -->
<form action="ConsultaSaldos" method="post" name="card_mov" onsubmit="return validaForm()">
<div id="wrapper">
	<div id="content">
		<div id="posts">
			<div class="post">
                        <jsp:include page="session_control.jsp" flush="true|false"/>
			<h2 class="title">Criterios de Consultas</h2>
				<div class="story">
					<p>Ingrese el rango de fechas que desee consultar con el formato DD/MM/YYYY </p>
                                        <table >
                                            <tr>
                                                <td>Desde</td>
                                                <td>
                                                <input type="text" size="14" class="input-normal" name="fechadesde" id="formDate1" onfocus="this.blur()" readonly />
                                                </td>
                                                <td>
                                                <a href="#" onclick="dp('formDate1','calendarButton1')" class="calendario">
                                                    <img id="calendarButton1" align="absmiddle" src="images/calendar.gif" width="20" height="20" border="0" />
                                                </a>
                                                </td>
                                                <td>Hasta</td>
                                                <td><input type="text" size="14"  class="input-normal" name="fechahasta" id="formDate2" onfocus="this.blur()" readonly />
                                                    </td>
                                                    <td><a href="#" onclick="dp('formDate2','calendarButton2')">
                                                        <img id="calendarButton2" align="absmiddle" src="images/calendar.gif" width="20" height="20" border="0" />
                                                        </a></td>
                                                <td><input value="Consultar" type="submit" class="input-normalb"></input>
                                                    <input  type="hidden" name="linktype" value="movimiento" ></input>
                                                </td>

                                            </tr>
                                        </table>

				</div>
                            <h2 class="title">Resultado de Consulta</h2>

				<div class="story">
			
                                    <p> Saldo de tarjeta numero ${conmov.tarjeta.nro_tarjeta} del ${conmov.fechadesde} al ${conmov.fechahasta} </p>

                                        <table border="0" width="100%"><tr>
                                                <td class = "t1" valign = top width="100%">
                                                <table border="0" width="100%">
                                                    <tr>
                                                        <td width="25%" class = "et">Local</td>
                                                        <td width="25%" class = "et">Fecha</td>
                                                        
                                                        <td width="25%" class = "et">Tipo</td>
                                                        <td width="25%" class = "et">Monto</td>
                                                    </tr>
                                                    <c:forEach var="abono" items="${conmov.abonos}">
                                                    <tr>                                                        
                                                        <td >${abono.espacio.local.nombre}</td>
                                                        <td >${abono.fecha_Inicio}   </td>
                                                        <td >${abono.tipo_abono}</td>
                                                        <td >${abono.monto}</td>
                                                    </tr>
                                                    </c:forEach>
                                                </table>
                                                </td>
                                            </tr></table>


				</div>
                                
			</div>
		</div>
		<!-- end #posts -->
                <jsp:include page="links_qrycard.jsp" flush="true|false"/>
		<!-- end #links -->
		<div style="clear: both;">&nbsp;</div>
	</div>
</div>
<jsp:include page="select_date.jsp" flush="true|false"/>
</form>
<jsp:include page="footer.jsp" flush="true|false"/>
</body>
</html>
