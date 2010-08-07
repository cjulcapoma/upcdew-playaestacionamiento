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
import pe.edu.upc.dw.dao.ClienteDaoJdbc;
import pe.edu.upc.dw.dao.TarjetaDaoJdbc;

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
            ClienteDaoJdbc clientejdbc = (ClienteDaoJdbc)context.getBean("clienteDao");
            TarjetaDaoJdbc tarjetajdbc = (TarjetaDaoJdbc)context.getBean("tarjetaDao");
            /*ClienteDaoJdbc clienteJdbc= new ClienteDaoJdbc();*/

            Date now = new Date();
            DateFormat df = DateFormat.getDateInstance();
            String s = df.format(now).toUpperCase();

            req.setAttribute("fechaactual", s);
            String user = req.getParameter("user");
            String clave =req.getParameter("clave");


            cliente = clientejdbc.getClientebyLogin(user, clave);
            if (cliente !=null ) {
                tarjeta = tarjetajdbc.getTarjetabyCliente(cliente);
                req.setAttribute("cliente", cliente);
                req.setAttribute("tarjeta", tarjeta);
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
