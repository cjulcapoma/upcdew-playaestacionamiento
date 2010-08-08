<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<form action="LoginUsuario" method="post" name="login_usu" onsubmit="return validaForm()">
<div id="wrapper">
	<div id="content">
		<div id="posts">
			<div class="post">
				<h2 class="title">Inicio de Sesión</h2>
				<div class="story">
					<p>Ingrese su nombre de Usuario</p>
                                        <table >
                                            <tr>
                                                <td>Usuario</td>
                                                <td><input type="text" class="input-normal" name="txtUsuario" ></input></td>
                                            </tr>
                                            <tr>
                                                <td>Contraseña</td>
                                                <td>
                                                    <input type=password class="input-normal" name="txtPassword"></input>
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
                                <li><a href="checkin_park.jsp">Administrativo</a> <i>(User)</i></li>
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
