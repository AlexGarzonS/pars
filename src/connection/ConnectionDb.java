/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Dev
 */
public class ConnectionDb {

    Connection cn = null;

    public Connection conectar()
            throws SQLException {
        String url;
        String className;
        url = "jdbc:sqlserver://localhost:1433;databaseName=pars;user=sa;password=123;"
                + "encrypt=true;trustServerCertificate=true";
        className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        try {
            Class.forName(className);
            cn = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
        return cn;
    }

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

    public static void closeRs(ResultSet ars_rs)
            throws SQLException {
        if (ars_rs != null) {
            ars_rs.close();
        }
    }

    public static void closePs(PreparedStatement ars_ps)
            throws SQLException {
        if (ars_ps != null) {
            ars_ps.close();
        }
    }
}
