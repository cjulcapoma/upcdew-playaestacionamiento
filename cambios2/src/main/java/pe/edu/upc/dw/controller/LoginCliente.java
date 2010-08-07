/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dw.controller;

import com.sun.jmx.remote.internal.ClientCommunicatorAdmin;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upc.dw.model.Cliente;
import pe.edu.upc.dw.model.Tarjeta;
import java.util.*;
import java.text.*;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Yomaira
 */
public class LoginCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if ((req.getParameter("tipo").equals("C"))) {

            ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

           Tarjeta tarjeta = (Tarjeta)context.getBean("tarjeta");//new Tarjeta();
           Cliente cliente = (Cliente)context.getBean("cliente"); //new Cliente();



            Date now = new Date();
            DateFormat df = DateFormat.getDateInstance();
            String s = df.format(now).toUpperCase();

            req.setAttribute("fechaactual", s);
            if (req.getParameter("user").equals("43633724") && req.getParameter("clave").equals("43633724")) {
                cliente.setDni(req.getParameter("user"));
                cliente.setClave(req.getParameter("clave"));
                cliente.setId(1);
                cliente.setNombre("Pedro Pablo Chavez");
                tarjeta.setNro_tarjeta("4213880944529066");
                tarjeta.setSaldo_disponible(149.50);
                cliente.setTarjeta(tarjeta);

                req.setAttribute("cliente", cliente);
                req.setAttribute("tipovisor", "C");
                req.setAttribute("tipo", "C");

                session.setAttribute("usuario", cliente);

                req.getRequestDispatcher("card_account.jsp").forward(req, resp);
            } else {
                req.setAttribute("errlogin", "El usuario o contraseña es incorrecto, por favor verifique.");
                req.getRequestDispatcher("login_dni.jsp").forward(req, resp);
            }
            //super.doPost(req, resp);
        }/*else{
        if (req.getParameter("user").equals("admin") && req.getParameter("clave").equals("admin")){
        Usuario usuario = new Usuario();
        usuario.setUserid(1);
        usuario.setUserName(req.getParameter("user"));
        usuario.setClave(req.getParameter("clave"));

        //req.setAttribute("cliente", cliente);
        //HttpSession session = req.getSession();
        req.setAttribute("tipovisor", "A");
        req.setAttribute("tipo", "A");
        req.setAttribute("querytype", "L");
        session.setAttribute("usuario", usuario);

        req.getRequestDispatcher("query.jsp").forward(req, resp);
        }else{
        req.setAttribute("errlogin", "El usuario o contraseña es incorrecto, por favor verifique.");
        req.getRequestDispatcher("login_user.jsp").forward(req, resp);
        }
        }*/
    }
}
