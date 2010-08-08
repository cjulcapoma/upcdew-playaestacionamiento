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
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.edu.upc.dw.dao.TarjetaDaoJdbc;
import pe.edu.upc.dw.model.Tarjeta;
import pe.edu.upc.dw.dao.AlquilerDaoJdbc;
import pe.edu.upc.dw.model.Alquiler;
/**
 *
 * @author oalvarez
 */
public class BuscarTarjeta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sTarjeta = req.getParameter("txtTarjeta");
        String sPlaca = req.getParameter("txtPlacaT");

        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

        Tarjeta oTarjeta = (Tarjeta) context.getBean("tarjeta"); //new Alquiler();
        TarjetaDaoJdbc oTarjetaDao = (TarjetaDaoJdbc) context.getBean("tarjetaDao");


        oTarjeta = oTarjetaDao.buscarTarjeta(sTarjeta);




        if (oTarjeta != null) {
            req.setAttribute("tarjetaB", oTarjeta);
            Alquiler oAlquiler = (Alquiler) context.getBean("alquiler"); //new Alquiler();
            AlquilerDaoJdbc oAlquilerDao = (AlquilerDaoJdbc) context.getBean("alquilerDao");

            oAlquiler.setPlaca(sPlaca);

            oAlquiler = oAlquilerDao.buscarAlquiler(oAlquiler);

            req.setAttribute("tarjetaB", oTarjeta);
            req.setAttribute("alquilerB", oAlquiler);
        } else {
            req.setAttribute("mensaje", "La tarjeta indicada no existe");
        }

        req.getRequestDispatcher("checkout_park.jsp").forward(req, resp);
    }
}
