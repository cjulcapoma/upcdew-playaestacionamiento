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
<title>Configuracion</title>
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
				<h2 class="title">Tolerancia</h2>
				<div class="story">
					<p>Indique el numero de minutos que se deben considerar cuando se cumple la hora limite</p>
                                        <table>
                                            <tr>
                                                <td>Minutos</td>
                                                <td><input type="text" class="input-normal"></input></td>
                                            </tr>
                                        </table>

				</div>
                                
			</div>
		</div>
		<!-- end #posts -->
		<div id="links">
			<ul>
				<li>
					<h2>Opciones</h2>
					<ul>
						<li><a href="#">Tolerancia</a> <i>(Minutos)</i></li>
						<li><a href="#">Asociados</a> <i>(Clente registrado)</i></li>
                                                <li><a href="#">Sitios</a> <i>(Número)</i></li>

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
