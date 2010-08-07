package pe.edu.upc.dw.dao;

import pe.edu.upc.dw.util.JdbcUtils;
import pe.edu.upc.dw.model.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pe.edu.upc.dw.model.Tarjeta;

/**
 *
 * @author Carlos
 */
public class TarjetaDaoJdbc {

    public Tarjeta getTarjetabyCliente(Cliente vcliente) {
        Tarjeta tarjeta = null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            final String query = "select * from tarjeta where id_cliente='" + vcliente.getId() + "'";
            System.out.println("query=" + query);
            rs = st.executeQuery(query);
            if (rs.next()) {
                tarjeta = new Tarjeta();
                tarjeta.setCliente(vcliente);
                tarjeta.setSaldo_disponible(rs.getDouble("saldo_disponible"));
                tarjeta.setNro_tarjeta(rs.getString("nro_tarjeta"));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error al obtener el tarjeta", e);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }
        return tarjeta;
    }
}
