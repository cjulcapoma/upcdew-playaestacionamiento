/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dw.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.print.PrintException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.edu.upc.dw.dao.ClienteDaoJdbc;
import pe.edu.upc.dw.dao.TarjetaDaoJdbc;
import pe.edu.upc.dw.model.Cliente;

/**
 *
 * @author oalvarez
 */
public class RegistroCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Cliente ocliente = (Cliente)context.getBean("cliente"); //new Cliente();
        ClienteDaoJdbc clientejdbc = (ClienteDaoJdbc)context.getBean("clienteDao");
TarjetaDaoJdbc tarjetajdbc = (TarjetaDaoJdbc) context.getBean("tarjetaDao");
//        HttpSession session = req.getSession();

//        List<Cliente> oClientes = (List<Cliente>) session.getAttribute("clientes");
//        if (oClientes == null) {
//            oClientes = new ArrayList<Cliente>();
//        }


//        ocliente.setId(5);
        ocliente.setDni(req.getParameter("txtDNI"));
        ocliente.setNombre(req.getParameter("txtNombre"));
        ocliente.setDireccion(req.getParameter("txtDireccion"));
        ocliente.setTelefono(req.getParameter("txtTelefono"));
        ocliente.setCorreo(req.getParameter("txtMail"));
        ocliente.setTipo_cliente(req.getParameter("TipoCliente"));
        ocliente.setEstado("A");

        Cliente clienteExist;

        clienteExist = clientejdbc.Buscar(ocliente.getDni());


        if (clienteExist != null) {
        req.setAttribute("errlogin", "El cliente ya existe, ingrese uno nuevo");
        req.getRequestDispatcher("cust_reg.jsp").forward(req, resp);
        }else{
            Cliente vCliente = clientejdbc.InsertarCliente(ocliente);
            if (tarjetajdbc.registrarTarjeta(vCliente)) {
            }
//            HttpSession session = req.getSession();
//            session.setAttribute("cliente", vCliente);

        List<Cliente>  oListaClientes = clientejdbc.MostrarTodos();

        req.setAttribute("clientes", oListaClientes);

        req.getRequestDispatcher("clie_reg.jsp").forward(req, resp);

        }



//        Cliente vCliente = clientejdbc.InsertarCliente(ocliente);
//        HttpSession session = req.getSession();
//        session.setAttribute("cliente", vCliente);

        //req.setAttribute("cliente", oClientes);

//        session.setAttribute("clientes", oClientes);


    }
}
