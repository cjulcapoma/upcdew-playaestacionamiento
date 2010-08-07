/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dw.dao;

import pe.edu.upc.dw.util.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pe.edu.upc.dw.model.Alquiler;
import pe.edu.upc.dw.model.Local;

/**
 *
 * @author oalvarez
 */
public class AlquilerDaoJdbc {

    public boolean registrarAlquiler(Alquiler oAlquiler) {
        boolean bOk = false;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        int nOk = 0;
        int nIdAlquiler = 0;
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            String sQuery = "Select Max(Id_Alquiler) + 1 from Dew.Alquiler";
            rs = st.executeQuery(sQuery);
            if (rs.next()) {
                nIdAlquiler = rs.getInt(1);
                if (nIdAlquiler == 0) {
                    nIdAlquiler = 1;
                }
            }
            JdbcUtils.closeResultSet(rs);

            st = connection.createStatement();
            sQuery = "Insert into Dew.Alquiler(Id_Alquiler, Fecha, Hora_Inicio, Placa, Id_Local) values ('" + nIdAlquiler +
                    "', '" + oAlquiler.getFecha() + "','" + oAlquiler.getHora_inicio() + "','" + oAlquiler.getPlaca() +
                    "','" + oAlquiler.getLocal().getId() + "')";
            nOk = st.executeUpdate(sQuery);
            if (nOk >= 0) {
                bOk = true;
            }

        } catch (SQLException ex) {
            throw new IllegalStateException("Error al registrar el alquiler", ex);
        } finally {
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }
        return bOk;
    }

    public Alquiler buscarAlquiler(Alquiler oAlquiler) {
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        Alquiler oAlquilerEncontrado = null;
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            String sQuery = "Select a.Id_Alquiler, a.Fecha, a.Hora_Inicio, a.Placa, a.Id_Local, l.nombre from Dew.Alquiler a " +
                    " Inner Join Dew.Local l on a.Id_Local = l.Id_Local " +
                    " Where a.Placa = '" + oAlquiler.getPlaca() + "'";
            rs = st.executeQuery(sQuery);
            if (rs.next()) {
                oAlquilerEncontrado = new Alquiler(rs.getInt("Id_Alquiler"), rs.getString("Fecha"), rs.getString("Hora_Inicio"),
                        "", 0.0, rs.getString("Placa"), null, new Local(rs.getInt("Id_Local"), rs.getString("Nombre"), "", "", "0"), "");
            }


        } catch (SQLException ex) {
            throw new IllegalStateException("Error al obtener el alquiler", ex);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }
        return oAlquilerEncontrado;
    }

    public boolean cerrarAlquiler(Alquiler oAlquiler) {
        boolean bOk = false;
        Connection connection = null;
        Statement st = null;
        int nOk = 0;
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            String sQuery = "Update Dew.Alquiler Set Id_Estado = '02', Hora_Fin = '" + oAlquiler.getHora_fin() + 
                    "', Importe = " + oAlquiler.getImporte() + " Where Id_Alquiler = '" + oAlquiler.getId() + "'";
            nOk = st.executeUpdate(sQuery);
            if (nOk >= 0) {
                bOk = true;
            }

        } catch (SQLException ex) {
            throw new IllegalStateException("Error al cerrar el Alquiler", ex);
        } finally {
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }
        return bOk;
    }
}
