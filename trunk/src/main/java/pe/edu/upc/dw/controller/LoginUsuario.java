/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upc.dw.model.Local;
import pe.edu.upc.dw.model.Usuario;

/**
 *
 * @author oalvarez
 */
public class LoginUsuario extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        String sUsuario = req.getParameter("txtUsuario");
        String sPassword = req.getParameter("txtPassword");
        if (sUsuario.equals("oalvarez") && sPassword.equals("oalvarez")) {
            Usuario oUsuario = new Usuario();
            oUsuario.setUsuario(sUsuario);
            oUsuario.setNombre("Omar Alvarez");

            Local oLocal = new Local(1, "San Isidro", "Av. Canaval y Moreyra 354", "234232", "50");
            oUsuario.setLocal(oLocal);

            HttpSession session = req.getSession();
            session.setAttribute("usuario", oUsuario);
            session.setAttribute("tipovisor", "A");

            req.getRequestDispatcher("user_account.jsp").forward(req, resp);
        } else {
            req.setAttribute("errlogin", "El usuario o contraseña es incorrecto, por favor verifique.");
            req.getRequestDispatcher("login_usu.jsp").forward(req, resp);
        }

    }
}
