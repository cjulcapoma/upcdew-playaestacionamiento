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
<jsp:include page="header_isl.jsp" flush="true|false"/>
<!-- end #header -->
<form action="LoginCliente?tipo=C" method="post" name="login_dni" onsubmit="return validaForm()">
<div id="wrapper">
	<div id="content">
		<div id="posts">
			<div class="post">
				<h2 class="title">Inicio de Sesión</h2>
				<div class="story">
					<p>Ingrese los datos de acceso</p>
                                        <table >
                                            <tr>
                                                <td>DNI</td>
                                                <td><input type="text" class="input-normal" name="user" ></input></td>
                                            </tr>
                                            <tr>
                                                <td>Contraseña</td>
                                                <td>
                                                    <input type=password class="input-normal" name="clave" ></input>
                                                </td>

                                            </tr>
                                            <tr>
                                                <td> </td>
                                                <td align="center">
                                                    <p></p>
                                                    <input type=submit class="input-normal" name="Ingresar" value="Ingresar"></input>
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
                            <h2>Inicio de Sesión</h2>
                            <ul>
                                <li><a href="login_usu.jsp">Administrativo</a> <i>(User)</i></li>
                                <li><a href="login_dni.jsp">Cliente</a> <i>(DNI)</i></li>

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
