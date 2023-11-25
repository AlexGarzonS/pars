/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Facturas;

import connection.ConnectionDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Facturas.Facturas;

/**
 *
 * @author Dev
 */
public class FacturasDao extends ConnectionDb{
    
    private static final String cs_CONSULTAFACTURAS = "Select * from fACTURAS ";
    
    public Collection<Facturas> consultaFacturas()
            throws SQLException {
        Collection<Facturas> coleccionRetorno;
        PreparedStatement ps;
        ResultSet rs;

        coleccionRetorno = null;
        ps = null;
        rs = null;

        try {
            coleccionRetorno = new ArrayList<>();
            ps = conectar().prepareStatement(cs_CONSULTAFACTURAS);
            rs = ps.executeQuery();

            while (rs.next()) {
                coleccionRetorno.add(getDataFactura(rs));
            }
        } catch (SQLException e) {
            System.out.println("FacturasDao::consultaFacturas " + e.getMessage());
        } finally {
            closeRs(rs);
            closePs(ps);
            CerraConector();
        }

        return coleccionRetorno;
    }
    
    private Facturas getDataFactura(ResultSet ars)
            throws SQLException {
        Facturas returnServices;
        returnServices = new Facturas();

        returnServices.setIdfactura(ars.getInt("facturaid"));
        returnServices.setIdEvento(ars.getInt("id_evento"));
        returnServices.setIdcliente(ars.getInt("id_cliente"));
        returnServices.setFecha(ars.getDate("fecha"));
        returnServices.setValor(ars.getDouble("valor_total"));
        returnServices.setSubvalor(ars.getDouble("subTotal"));

        return returnServices;
    }
    
}
