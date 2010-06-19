<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"
          prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"
          prefix="fmt" %>
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
<form action="ConsultaIngresoSalida" method="post" onSubmit="return check_date(this.fechadesde.value)">
<div id="wrapper">
	<div id="content">
		<div id="posts">
			<div class="post">
                            Bienvenido(a) Usuario <b> ${usuario.nombre} </b>
				<h2 class="title">Criterios de Consultas</h2>
				<div class="story">
					<p>Ingrese el rango de fechas que desee consultar con el formato DD/MM/YYYY </p>
                                        
                                        <input type=hidden name="querytype" value="${querytype}"></input>
                                        <table>
                                            <c:if test="${querytype=='L'}">
                                            <tr>
                                                <td>Local</td>
                                                <td><input type="text" class="input-normal" name="id_local" value="${usuario.local.nombre}"></input>
                                                    
                                                </td>

                                            </tr>
                                            </c:if>
                                            <c:if test="${querytype=='A'}">
                                            <tr>
                                                <td>Asociado</td>
                                                <td><input type="text" class="input-normal" name="id_cliente"></input>                                                
                                                </td>
                                            </tr>
                                            </c:if>
                                            <c:if test="${querytype=='P'}">                                            
                                             <tr>
                                                <td>Placa</td>
                                                <td><input type="text" class="input-normal" name="placa"></input>                                                
                                                </td>
                                            </tr>
                                            </c:if>
                                            <tr>
                                                <td>Desde</td>
                                                <td><input type="text" class="input-normal" name="fechadesde"></input></td>
                                                <td>Hasta</td>
                                                <td><input type="text" class="input-normal" name="fechahasta"></input></td>
                                                <td><input value="Consultar" type="submit" class="input-normalb"></input></td>
                                            </tr>
                                        </table>

				</div>
                                <h2 class="title">Resultado de Consultas</h2>
                                    <div class="story">
                                        
                                        <p>Lista de transacciones desde ${coningsal.fechadesde} al ${coningsal.fechahasta} </p>
                                        
                                    <table border="0" width="100%"><tr>
                                            
                                            <td class = "t1" valign = top width="100%">

                                        <table border="0" width="100%">
                                            <tr>
                                                <td width="25%" class = "et">Ingreso</td>
                                                <td width="25%" class = "et">Salida</td>
                                                <td width="25%" class = "et">Nro de Placa</td>

                                            </tr>
                                            <c:forEach var="alquiler" items="${coningsal.alquileres}">
                                            <tr>                                             
                                             <td>${alquiler.fecha} ${alquiler.hora_inicio}</td>
                                             <td>${alquiler.fecha} ${alquiler.hora_fin}</td>
                                             <td >${alquiler.placa}</td>
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
</form>
<jsp:include page="footer.jsp" flush="true|false"/>
</body>
</html>
