package pe.edu.upc.dw.dao;

import pe.edu.upc.dw.util.JdbcUtils;
import pe.edu.upc.dw.model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pe.edu.upc.dw.model.Local;

/**
 *
 * @author Carlos
 */
public class UsuarioDaoJdbc {

    public Usuario getUsuariobyLogin(String vNombre, String vPassword) {
        Usuario usuario = null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            final String query = "select u.nombre nombre_usuario,l.nombre nombre_local, l.id_local from usuario u,local l where u.id_local=l.id_local and u.id_usuario='" + vNombre + "' and password='"+vPassword+ "'";
            System.out.println("query=" + query);
            rs = st.executeQuery(query);

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setNombre(rs.getString("nombre_usuario"));
                Local local =new Local();
                local.setId(rs.getInt("id_local"));
                local.setNombre(rs.getString("nombre_local"));
                usuario.setLocal(local);
            }
        } catch (SQLException e) {            
            throw new IllegalStateException("Error al obtener el usuario", e);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }
        return usuario;
    }
}
