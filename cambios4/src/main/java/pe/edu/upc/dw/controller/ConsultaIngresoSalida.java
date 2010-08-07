/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dw.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import pe.edu.upc.dw.dao.ConsultaIngresoSalidaDaoJdbc;
import pe.edu.upc.dw.model.ConsultaIngresoSalidas;
import pe.edu.upc.dw.model.Local;
import pe.edu.upc.dw.model.Usuario;

/**
 *
 * @author Carlos
 */
public class ConsultaIngresoSalida extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

        ConsultaIngresoSalidas coningsal = (ConsultaIngresoSalidas)context.getBean("consultaIngresoSalida");
        ConsultaIngresoSalidaDaoJdbc coningsalj= (ConsultaIngresoSalidaDaoJdbc) context.getBean("consultaingresosalidaDao");
        HttpSession session = req.getSession();
        Usuario cliente = (Usuario) session.getAttribute("usuario");

        //Local local = (Local) context.getBean("local");

        req.setAttribute("tipovisor", "A");
        req.setAttribute("cliente", cliente);

        String tipoconsulta = req.getParameter("querytype");
        coningsal.setFechadesde(req.getParameter("fechadesde"));
        coningsal.setFechahasta(req.getParameter("fechahasta"));
        coningsal.setPlaca(req.getParameter("placa"));
        coningsal.setId_local(req.getParameter("id_local"));
        coningsal.setId_cliente(req.getParameter("id_cliente"));
        
        try {
            coningsal = coningsalj.getIngresoSalidabyQuery(coningsal);
        } catch (ParseException ex) {
            Logger.getLogger(ConsultaIngresoSalida.class.getName()).log(Level.SEVERE, null, ex);
        }

        req.setAttribute("coningsal", coningsal);
        req.setAttribute("querytype", tipoconsulta);
        req.getRequestDispatcher("query.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
