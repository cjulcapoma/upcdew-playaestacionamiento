/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dw.dao;

import pe.edu.upc.dw.util.JdbcUtils;
import pe.edu.upc.dw.util.StringManager;
import pe.edu.upc.dw.model.Tarjeta;
import pe.edu.upc.dw.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author oalvarez
 */
public class TarjetaDaoJdbc {

    public boolean registrarTarjeta(Cliente oCliente) {
        boolean bOk = false;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        int nOk = 0;
        int nIdTarjeta = 0;
        String sNroTarjeta = "";
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            String sQuery = "Select Max(Id_Tarjeta) + 1 from Dew.Tarjeta";
            rs = st.executeQuery(sQuery);
            if (rs.next()) {
                nIdTarjeta = rs.getInt(1);
                if (nIdTarjeta == 0) {
                    nIdTarjeta = 1;
                }
            }
            JdbcUtils.closeResultSet(rs);

            sNroTarjeta = String.valueOf(nIdTarjeta);
            for (int i = 1; i <= 9; i++) {
                sNroTarjeta = "0" + sNroTarjeta;
            }
            sNroTarjeta = StringManager.Right(sNroTarjeta, 10);

            st = connection.createStatement();
            sQuery = "Insert into Dew.Tarjeta (Id_Tarjeta, Nro_Tarjeta, Saldo_Disponible, Id_Cliente) " +
                    " values ('" + nIdTarjeta + "','" + sNroTarjeta + "',0,'" + oCliente.getId() + "')";
            nOk = st.executeUpdate(sQuery);
            if (nOk >= 0) {
                bOk = true;
            }

        } catch (SQLException ex) {
            throw new IllegalStateException("Error al registrar la tarjeta", ex);
        } finally {
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }
        return bOk;
    }

    public Tarjeta buscarTarjeta(String sNroTarjeta) {
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        Tarjeta oTarjetaEncontrada = null;
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            String sQuery = "Select a.Id_Alquiler, a.Fecha, a.Hora_Inicio, a.Placa, a.Id_Local, l.nombre from Dew.Alquiler a " +
                    " Inner Join Dew.Local l on a.Id_Local = l.Id_Local " +
                    " Where a.Placa = '" + sNroTarjeta + "'";
            rs = st.executeQuery(sQuery);
            if (rs.next()) {
            }


        } catch (SQLException ex) {
            throw new IllegalStateException("Error al obtener el alquiler", ex);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }
        return oTarjetaEncontrada;
    }

    public boolean recargarTarjeta(Tarjeta oTarjeta) {
        boolean bOk = false;
        Connection connection = null;
        Statement st = null;
        int nOk = 0;
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            String sQuery = "Update Dew.Tarjeta Set Saldo_Disponible = " + oTarjeta.getSaldo_disponible() +
                    " Where Nro_Tarjeta = '" + oTarjeta.getNro_tarjeta() + "'";
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

    public Tarjeta getTarjetabyCliente(String vIdCliente){
        Tarjeta tarjeta = null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            final String query = "select * from tarjeta where id_cliente='" + vIdCliente + "'";
            System.out.println("query=" + query);
            rs = st.executeQuery(query);

            if (rs.next()) {
                tarjeta = new Tarjeta();
                tarjeta.setNro_tarjeta(rs.getString("nro_tarjeta"));
                tarjeta.setSaldo_disponible(rs.getDouble("saldo_disponible"));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error al obtener la tarjeta del cliente", e);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }
        return tarjeta;

    }

    
}
