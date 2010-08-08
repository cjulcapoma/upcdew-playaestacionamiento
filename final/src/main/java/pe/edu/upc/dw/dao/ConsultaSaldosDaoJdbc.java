package pe.edu.upc.dw.dao;
import java.text.ParseException;
import pe.edu.upc.dw.util.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import pe.edu.upc.dw.model.Abono;
import pe.edu.upc.dw.model.Cliente;
import pe.edu.upc.dw.model.ConsultaMovimiento;
import pe.edu.upc.dw.model.Espacio;
import pe.edu.upc.dw.model.Local;
import pe.edu.upc.dw.model.Tarjeta;

/**
 *
 * @author Yomaira
 */
public class ConsultaSaldosDaoJdbc {
    public ConsultaMovimiento getSaldosbyCliente(ConsultaMovimiento vconmov) throws ParseException {
        ConsultaMovimiento vconmosql=new ConsultaMovimiento();        
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        Tarjeta tarjeta = new Tarjeta();        
        vconmosql=vconmov;

        if (vconmosql.getFechadesde()== null){
            return null;
        }
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            String query;
            query="select * from consulta_movimientos where id_cliente='" +  vconmosql.getCliente().getId() + "'";
            if (vconmosql.getFechadesde()!= null){
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd"); 
                query = query + " and fecha_inicio between '" + df.format(sdf.parse(vconmosql.getFechadesde())) + "' and '" + df.format(sdf.parse(vconmosql.getFechahasta())) + "'";
            }
            System.out.println("query=" + query);
            rs = st.executeQuery(query);
            if (rs.next()) {
                Local local=new Local();
                Espacio espacio=new Espacio();
                tarjeta.setCliente(vconmosql.getCliente());
                tarjeta.setNro_tarjeta(rs.getString("nro_tarjeta"));
                local.setNombre(rs.getString("nombre_local"));
                espacio.setLocal(local);
                vconmosql.setTarjeta(tarjeta);
                vconmosql.getAbonos().add(new Abono(rs.getDouble("monto"),rs.getDate("fecha_inicio"),rs.getDate("fecha_fin"),vconmosql.getCliente(), rs.getString("tipo_abono"),espacio));
            //System.out.println("pasamos if" + rs.getString("nro_tarjeta"));
            }

            System.out.println("antes de while");
            while (rs.next()) {
                Local locald=new Local();
                Espacio espaciod=new Espacio();
                locald.setNombre(rs.getString("nombre_local"));
                espaciod.setLocal(locald);
                vconmosql.getAbonos().add(new Abono(rs.getDouble("monto"),rs.getDate("fecha_inicio"),rs.getDate("fecha_fin"),vconmosql.getCliente(), rs.getString("tipo_abono") ,espaciod));
            System.out.println("dentro de while");
            }
            System.out.println("fin de while");
        } catch (SQLException e) {
            throw new IllegalStateException("Error al obtener los movimientos de la tarjeta", e);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }
        return vconmosql;
    }
}
