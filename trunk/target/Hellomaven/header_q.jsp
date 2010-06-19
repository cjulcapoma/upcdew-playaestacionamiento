<%-- 
    Document   : header
    Created on : 16-may-2010, 20:42:10
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<script language="JavaScript" src ="validations.js"> </script>
<div id="menu">
	<ul>
		<li><a href="index.jsp" accesskey="1" title="">Inicio</a></li>
                <li class="active"><a href="#" accesskey="2" title="">Consultas</a></li>
                <% if (request.getAttribute("tipovisor") == "A") { %>
                    <li><a href="user_account.jsp" accesskey="3" title="">Procesos</a></li>
                <% } %>
	</ul>
</div>
<!-- end #menu -->
<div id="header">
	<h1></h1>
</div>