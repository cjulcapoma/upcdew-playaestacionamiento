/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.webmaven.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upc.webmaven.model.Usuario;

/**
 *
 * @author u201000173
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Usuario oUsuario = new Usuario();

        oUsuario.setUsuario(req.getParameter("txtNombre"));
        oUsuario.setPassword(req.getParameter("txtPassword"));

        req.setAttribute("usuario", oUsuario);
        req.getRequestDispatcher("bienvenida.jsp").forward(req, resp);

//        PrintWriter writer = resp.getWriter();
//        writer.println("Usuario: " + oUsuario.getUsuario() + " - " + " Password: " + oUsuario.getPassword());
//        writer.close();
    }
}
