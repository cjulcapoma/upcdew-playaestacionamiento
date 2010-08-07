/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dw.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.edu.upc.dw.model.Alquiler;
import pe.edu.upc.dw.model.Cliente;
import pe.edu.upc.dw.model.ConsultaMovimiento;
import pe.edu.upc.dw.model.Local;
import pe.edu.upc.dw.model.Tarjeta;

/**
 *
 * @author Carlos
 */
public class ConsultaSaldos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

        ConsultaMovimiento conmov = (ConsultaMovimiento) context.getBean("consultaMovimiento");
        Local local = (Local) context.getBean("local");
        local.setId(1);
        local.setNombre("San Isidro");
        local.setDireccion("Av. Canaval y Moreyra 354");
        local.setTelefono("234232");
        local.setCant_espacios("50");

        Date now = new Date();
        DateFormat df = DateFormat.getDateInstance();
        String s = df.format(now).toUpperCase();

        String linktype = req.getParameter("linktype");

        req.setAttribute("fechaactual", s);

        HttpSession session = req.getSession();
        Cliente cliente = (Cliente) session.getAttribute("usuario");

        req.setAttribute("tipovisor", "C");

        req.setAttribute("cliente", cliente);

        if (linktype.equals("saldo")) {
            linktype = "card_account.jsp";
        }
        if (linktype.equals("movimiento")) {
            Tarjeta tarjeta = new Tarjeta();
            tarjeta = cliente.getTarjeta();
            linktype = "card_mov.jsp";
            conmov.getAlquileres().add(new Alquiler(1, "12/02/2010", "12:49", "13:49", 12.00, "XBO2323", tarjeta, local, null));
            conmov.getAlquileres().add(new Alquiler(2, "15/03/2010", "12:49", "13:49", 12.00, "FJU7483", tarjeta, local, null));
            conmov.getAlquileres().add(new Alquiler(3, "21/03/2010", "12:49", "13:49", 12.00, "AO20394", tarjeta, local, null));
            conmov.getAlquileres().add(new Alquiler(4, "27/04/2010", "12:49", "13:49", 10.00, "AO20394", tarjeta, local, null));
            conmov.getAlquileres().add(new Alquiler(5, "12/05/2010", "12:49", "13:49", 12.00, "QPO3983", tarjeta, local, null));
            conmov.setFechadesde(req.getParameter("fechadesde"));
            conmov.setFechahasta(req.getParameter("fechahasta"));
            if (conmov.getFechadesde() == null) {
                conmov.setFechadesde(s);
                conmov.setFechahasta(s);
            }
            req.setAttribute("conmov", conmov);
            req.setAttribute("cliente", cliente);
        }
        req.getRequestDispatcher(linktype).forward(req, resp);

    }
}
