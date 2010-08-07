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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.edu.upc.dw.model.Local;
import pe.edu.upc.dw.model.Usuario;
import pe.edu.upc.dw.dao.UsuarioDaoJdbc;

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
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        String sUsuario = req.getParameter("txtUsuario");
        String sPassword = req.getParameter("txtPassword");
        UsuarioDaoJdbc usuariojdbc = (UsuarioDaoJdbc)context.getBean("usuarioDao");

        Usuario oUsuario = usuariojdbc.getUsuariobyLogin(sUsuario, sPassword);

        if (oUsuario!=null) {

           
            //Usuario oUsuario = (Usuario)context.getBean("usuario");
            //Usuario oUsuario = new Usuario();

            Local oLocal = new Local(1, "San Isidro", "Av. Canaval y Moreyra 354", "234232", "50");
            oUsuario.setLocal(oLocal);

            HttpSession session = req.getSession();
            session.setAttribute("usuario", oUsuario);
            session.setAttribute("tipovisor", "A");
            session.setAttribute("querytype", "L");

            req.getRequestDispatcher("user_account.jsp").forward(req, resp);
        } else {
            req.setAttribute("errlogin", "El usuario o contraseña es incorrecto, por favor verifique.");
            req.getRequestDispatcher("login_usu.jsp").forward(req, resp);
        }

    }
}
