/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dw.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.edu.upc.dw.dao.ClienteDaoJdbc;
import pe.edu.upc.dw.dao.ConsultaSaldosDaoJdbc;
import pe.edu.upc.dw.dao.TarjetaDaoJdbc;
import pe.edu.upc.dw.model.Abono;
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
        ConsultaSaldosDaoJdbc conmovj= (ConsultaSaldosDaoJdbc) context.getBean("consultasaldosDao");
        Cliente cliente= (Cliente) context.getBean("cliente");
        Tarjeta tarjeta = (Tarjeta)context.getBean("tarjeta");//new Tarjeta();
        ClienteDaoJdbc clientejdbc = (ClienteDaoJdbc)context.getBean("clienteDao");
        TarjetaDaoJdbc tarjetajdbc = (TarjetaDaoJdbc)context.getBean("tarjetaDao");
/*
        Local local = (Local) context.getBean("local");
        local.setId(1);
        local.setNombre("San Isidro");
        local.setDireccion("Av. Canaval y Moreyra 354");
        local.setTelefono("234232");
        local.setCant_espacios("50");
*/
        Date now = new Date();
        DateFormat df = DateFormat.getDateInstance();
        String s = df.format(now).toUpperCase();

        String linktype = req.getParameter("linktype");

        req.setAttribute("fechaactual", s);

        HttpSession session = req.getSession();
        cliente = (Cliente) session.getAttribute("usuario");

        req.setAttribute("tipovisor", "C");
        req.setAttribute("cliente", cliente);

        if (linktype.equals("saldo")) {
            linktype = "card_account.jsp";
            tarjeta = tarjetajdbc.getTarjetabyCliente(cliente);
            req.setAttribute("tarjeta", tarjeta);
        }
        if (linktype.equals("movimiento")) {
            linktype = "card_mov.jsp";
            
            conmov.setFechadesde(req.getParameter("fechadesde"));
            conmov.setFechahasta(req.getParameter("fechahasta"));
            conmov.setCliente(cliente);
            try {
                conmov = conmovj.getSaldosbyCliente(conmov);
            } catch (ParseException ex) {
                Logger.getLogger(ConsultaSaldos.class.getName()).log(Level.SEVERE, null, ex);
            }

            req.setAttribute("conmov", conmov);
            req.setAttribute("cliente", cliente);
        }
        req.getRequestDispatcher(linktype).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp) ;
    }

}
