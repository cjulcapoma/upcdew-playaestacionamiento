<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="LoginServlet" method="post">
            Usuario:
            <input type="text" name="txtNombre" />
            <br /><br />
            Password:
            <input type="password" name="txtPassword"/>
            <br /><br />
            <input type="submit" />
        </form>
    </body>
</html>
