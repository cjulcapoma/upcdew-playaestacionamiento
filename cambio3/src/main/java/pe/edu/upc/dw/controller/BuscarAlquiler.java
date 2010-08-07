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
import pe.edu.upc.dw.model.Alquiler;

/**
 *
 * @author oalvarez
 */
public class BuscarAlquiler extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        String sPlaca = req.getParameter("txtPlaca");

        ApplicationContext context= new ClassPathXmlApplicationContext("/applicationContext.xml");

        Alquiler oAlquiler = (Alquiler)context.getBean("alquiler"); //new Alquiler();

        HttpSession session = req.getSession();
        oAlquiler = (Alquiler) session.getAttribute("Alquiler");

        if (oAlquiler.getPlaca().equals(sPlaca)) {
            req.setAttribute("mensaje", "ok");
            req.setAttribute("placa", sPlaca);
            req.setAttribute("alquilerB", oAlquiler);
        } else {
            req.setAttribute("mensaje", "La placa no tiene alquileres registrados");
        }
        req.getRequestDispatcher("checkout_park.jsp").forward(req, resp);


    }
}
