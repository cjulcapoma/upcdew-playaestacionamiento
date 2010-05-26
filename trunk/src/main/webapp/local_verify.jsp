<%-- 
    Document   : local_verify
    Created on : 25/05/2010, 09:43:22 PM
    Author     : u201000173
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <title>Edición de Clientes</title>
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
                        <h2 class="title">Verificación de Disponibilidad</h2>
                        <div class="story">
                            <table>
                                <tr>
                                    <td>ID Local</td>
                                    <td><input  class="input-normal" type="text" name="txtId" value="" /></td>
                                </tr>
                                <tr>
                                    <td>Nombre:</td>
                                    <td><input   class="input-normal" type="text" name="txtNombre" value="" /></td>
                                </tr>
                            </table>
                            <hr />
                            <p><input name="btnConsultar" value="Consultar" type="submit" class="input-normalb"></input></p>
                            <hr />
                            <h2 class="title">Resultado de Consultas por Placa</h2>
                            <div class="story">

                                <p>Lista de Espacios Disponibles</p>

                                <table border="0" width="100%"><tr>

                                        <td class = "t1" valign = top width="100%">

                                            <table border="0" width="100%">
                                                <tr>
                                                    <td width="25%" class = "et">Código</td>
                                                    <td width="25%" class = "et">Número de Espacio</td>

                                                </tr>
                                                <tr>
                                                    <td >1</td>
                                                    <td >N-48</td>


                                                </tr>
                                                <tr>
                                                    <td >2</td>
                                                    <td >N-49</td>


                                                </tr>
                                            </table>
                                        </td>
                                    </tr></table>
                            </div>
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
                                <li><a href="cust_edit.jsp">Editar</a> <i>(A)</i></li>
                            </ul>
                        </li>
                        <li>
                            <h2>Locales</h2>
                            <ul>
                                <li><a href="local_reg.jsp">Nuevo</a> <i>(M)</i></li>
                                <li><a href="local_edit.jsp">Editar</a> <i>(A)</i></li>
                                <li><a href="local_verify.jsp">Disponibilidad</a> <i>(A)</i></li>
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
