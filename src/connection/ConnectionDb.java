package connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author JGARZON
 */
public class ConnectionDb {

    Connection cn = null;

    /*Se crear funcion para establecer conexión con la base de datos*/
    public Connection conectar()
            throws SQLException {
        String url;
        String className;
        url = "jdbc:sqlserver://localhost:1433;databaseName=pars;user=sa;password=123;";
        //+ "encrypt=true;trustServerCertificate=true";
        className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(className);
            cn = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
        return cn;
    }

    /**
     * Cerramos las posible conexiones echar a la base de datos
     * @throws SQLException excepcion sql
     */
    public void CerraConector()
            throws SQLException {
        try {
            if (cn != null) {
                if (!cn.isClosed()) {
                    cn.close();
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
    }

    /**
     * cerramos objetos ResultSet 
     * @throws SQLException excepcion sql
     */
    public static void closeRs(ResultSet ars_rs)
            throws SQLException {
        if (ars_rs != null) {
            ars_rs.close();
        }
    }

    /**
     * cerramos objetos PreparedStatement 
     * @throws SQLException excepcion sql
     */
    public static void closePs(PreparedStatement ars_ps)
            throws SQLException {
        if (ars_ps != null) {
            ars_ps.close();
        }
    }

    /**
     * cerramos objetos CallableStatement 
     * @throws SQLException excepcion sql
     */
    public static void closeCall(CallableStatement ars_ps)
            throws SQLException {
        if (ars_ps != null) {
            ars_ps.close();
        }
    }
}
