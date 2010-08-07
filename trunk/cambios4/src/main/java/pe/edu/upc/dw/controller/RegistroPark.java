/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dw.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.edu.upc.dw.model.Alquiler;
import pe.edu.upc.dw.model.Local;
import pe.edu.upc.dw.model.Tarjeta;
import pe.edu.upc.dw.model.Usuario;

/**
 *
 * @author oalvarez
 */
public class RegistroPark extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

        Date now = new Date();
        DateFormat df = DateFormat.getDateInstance();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

        String sFecha = formatoFecha.format(now);
        String sHora = formatoHora.format(now);
        String sPlaca = req.getParameter("txtPlaca");

        if (sPlaca.isEmpty()) {
            req.setAttribute("mensaje", "No ha ingresado la placa. Por favor verifique");
            req.getRequestDispatcher("checkin_park.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            Usuario oUsuario = (Usuario) session.getAttribute("usuario");
            Local oLocal = oUsuario.getLocal();



            //new Alquiler(1, sFecha, sHora, "", 0.0, sPlaca, new Tarjeta(), oLocal, "01");
            Alquiler oAlquiler = (Alquiler)context.getBean("alquiler");
            oAlquiler.setId(1);
            oAlquiler.setFecha(sFecha);
            oAlquiler.setHora_inicio(sHora);
            oAlquiler.setPlaca(sPlaca);
            oAlquiler.setTarjeta((Tarjeta)context.getBean("tarjeta"));
            oAlquiler.setLocal(oLocal);
            oAlquiler.setEstado("01");


            session.setAttribute("Alquiler", oAlquiler);
            //req.setAttribute("Alquiler", oAlquiler);
            req.setAttribute("mensaje", "Se registró el alquiler nro. " + oAlquiler.getId() + " - Placa: " + oAlquiler.getPlaca());
            req.getRequestDispatcher("checkin_park.jsp").forward(req, resp);
        }



    }
}
