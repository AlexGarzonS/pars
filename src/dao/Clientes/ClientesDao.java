/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Clientes;

import connection.ConnectionDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Clientes.Clientes;

/**
 *
 * @author Dev
 */
public class ClientesDao extends ConnectionDb {

    private static final String cs_CONSULTACLIENTES = "Select * from clientes";

    public Collection<Clientes> consultaClientes()
            throws SQLException {
        Collection<Clientes> coleccionRetorno;
        PreparedStatement ps;
        ResultSet rs;

        coleccionRetorno = null;
        ps = null;
        rs = null;

        try {
            ps = conectar().prepareStatement(cs_CONSULTACLIENTES);
            rs = ps.executeQuery();
            coleccionRetorno = new ArrayList<>();

            while (rs.next()) {
                coleccionRetorno.add(getDataClients(rs));
            }
        } catch (SQLException e) {
            System.out.println("ClientesDao::consultaServicios " + e.getMessage());
        } finally {
            closeRs(rs);
            closePs(ps);
        }

        return coleccionRetorno;
    }

    private Clientes getDataClients(ResultSet ars)
            throws SQLException {
        Clientes returnClients;
        returnClients = new Clientes();

        returnClients.setId_cliente(ars.getInt("clienteID"));
        returnClients.setNombre(ars.getString("Nombre"));
        returnClients.setDireccion(ars.getString("direccion"));
        returnClients.setEmail(ars.getString("email"));
        returnClients.setNumeroDocumento(ars.getString("numeroDocumento"));
        returnClients.setTipoDoc(ars.getString("tipoDocumento"));
        returnClients.setTelefono(ars.getString("telefono"));

        return returnClients;
    }
}
