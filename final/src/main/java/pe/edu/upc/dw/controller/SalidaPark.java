/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upc.dw.model.Alquiler;
import pe.edu.upc.dw.model.Usuario;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pe.edu.upc.dw.dao.AlquilerDaoJdbc;
import pe.edu.upc.dw.model.Local;
import pe.edu.upc.dw.dao.LocalDaoJdbc;
import pe.edu.upc.dw.util.StringManager;
import pe.edu.upc.dw.model.Tarjeta;
import pe.edu.upc.dw.dao.AlquilerDaoJdbc;
import pe.edu.upc.dw.dao.TarjetaDaoJdbc;

/**
 *
 * @author oalvarez
 */
public class SalidaPark extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        Date now = new Date();
        DateFormat df = DateFormat.getDateInstance();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");
        SimpleDateFormat fecha = new SimpleDateFormat();

        String sFecha = formatoFecha.format(now);
        String sHora = formatoHora.format(now);
        String sPlaca = req.getParameter("txtPlacaA");
        String sTarjeta = req.getParameter("txtTarjetaA");

        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");

        Alquiler oAlquiler = (Alquiler) context.getBean("alquiler"); //new Alquiler();
        AlquilerDaoJdbc oAlquilerDao = (AlquilerDaoJdbc) context.getBean("alquilerDao");

        oAlquiler.setPlaca(sPlaca);

        oAlquiler = oAlquilerDao.buscarAlquiler(oAlquiler);

        Tarjeta oTarjeta = (Tarjeta) context.getBean("tarjeta"); //new Alquiler();
        TarjetaDaoJdbc oTarjetaDao = (TarjetaDaoJdbc) context.getBean("tarjetaDao");


        if (sTarjeta != "") {
            oTarjeta = oTarjetaDao.buscarTarjeta(sTarjeta);
        }
        int minIni = 0;
        int minFin = 0;

        String sHoraInicio = oAlquiler.getHora_inicio();

        minIni = Integer.parseInt(StringManager.Left(sHoraInicio, 2));
        //+ Integer.parseInt( StringManager.Right(sHoraInicio, 2));

        minFin = Integer.parseInt(StringManager.Left(sHora, 2)); //+
        //Integer.parseInt( StringManager.Right(sHora, 2))  ;

        Local oLocal = (Local) context.getBean("local"); //new Alquiler();
        oLocal.setId(oAlquiler.getLocal().getId());
        LocalDaoJdbc oLocalDao = (LocalDaoJdbc) context.getBean("localDao");

        oLocal = oLocalDao.buscarLocal(oLocal);


        double nImporte = Double.parseDouble(String.valueOf(minFin - minIni)) * Double.parseDouble(oLocal.getPrecio_hora());

        oAlquiler.setHora_fin(sHora);
        oAlquiler.setImporte(nImporte);
        oAlquiler.setEstado("02");
        oAlquiler.setTarjeta(oTarjeta);

        oTarjeta.setSaldo_disponible(oTarjeta.getSaldo_disponible() - nImporte);

        if (oTarjeta.getSaldo_disponible() >= nImporte) {
            if (oAlquilerDao.cerrarAlquiler(oAlquiler)) {
                if (oTarjetaDao.recargarTarjeta(oTarjeta)) {
                    req.setAttribute("alquilerB", oAlquiler);
                    req.setAttribute("mensajeCierre", "Se cerró el alquiler nro. " + oAlquiler.getId() + " - Placa: " + oAlquiler.getPlaca());
                }

            }
        } else {
            req.setAttribute("alquilerB", oAlquiler);
            req.setAttribute("mensajeCierre", "El cliente no tiene saldo disponible");
        }



        //session.setAttribute("alquilerB", oAlquiler);
        //req.setAttribute("Alquiler", oAlquiler);
        req.getRequestDispatcher("checkout_park.jsp").forward(req, resp);
    }
}
