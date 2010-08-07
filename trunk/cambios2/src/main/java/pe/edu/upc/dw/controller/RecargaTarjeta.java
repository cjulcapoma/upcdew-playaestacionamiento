/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.edu.upc.dw.model.Cliente;
import pe.edu.upc.dw.model.Tarjeta;

/**
 *
 * @author oalvarez
 */
public class RecargaTarjeta extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

        HttpSession session = req.getSession();
        Cliente cliente = (Cliente)context.getBean("cliente");//new Cliente();
        if (req.getParameter("tipo").equals("B")) {
            Tarjeta tarjeta = (Tarjeta)context.getBean("tarjeta"); //new Tarjeta();
            Date now = new Date();
            DateFormat df = DateFormat.getDateInstance();
            String s = df.format(now).toUpperCase();

            req.setAttribute("fechaactual", s);
            if (req.getParameter("cliente").equals("43633724")) {
                cliente.setDni(req.getParameter("cliente"));
                cliente.setId(1);
                cliente.setNombre("Pedro Pablo Chavez");
                tarjeta.setNro_tarjeta("4213880944529066");
                tarjeta.setSaldo_disponible(149.50);
                cliente.setTarjeta(tarjeta);

                session.setAttribute("clienterecarga", cliente);
                req.setAttribute("tipovisor", "C");

                req.getRequestDispatcher("card_load.jsp").forward(req, resp);
            } else {
                req.setAttribute("errlogin", "El cliente no existe, por favor verifique.");
                req.getRequestDispatcher("cust_sel.jsp").forward(req, resp);
            }
        } else {
            cliente = (Cliente) session.getAttribute("clienterecarga");
            String sMonto = req.getParameter("monto");
            double monto = Double.parseDouble(sMonto);
            cliente.getTarjeta().setSaldo_disponible(cliente.getTarjeta().getSaldo_disponible() + monto);

            req.setAttribute("mensaje", "El saldo del cliente es:" + cliente.getTarjeta().getSaldo_disponible());

            session.setAttribute("clienterecarga", cliente);
            req.getRequestDispatcher("card_load.jsp").forward(req, resp);
        }
        //super.doPost(req, resp);
    }
}
