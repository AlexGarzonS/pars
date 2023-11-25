/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Facturas;

import ControlErrores.ControlErrores;
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
public class FacturasDao extends ConnectionDb {

    private static final String cs_CONSULTAFACTURAS = "Select * from fACTURAS ";
    private static final String cs_ESTADOfACTURA = "SELECT f.* FROM facturas f "
            + "INNER JOIN Eventos e ON (e.eventoID = f.id_evento) "
            + "WHERE e.Estado = ?";

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

    public Collection<Facturas> consultaFacturasEstado(String estado)
            throws SQLException {
        Collection<Facturas> coleccionRetorno;
        PreparedStatement ps;
        ResultSet rs;

        coleccionRetorno = null;
        ps = null;
        rs = null;

        try {
            ControlErrores er;
            er = new ControlErrores();
            if (er.isValidString(estado)) {
                coleccionRetorno = new ArrayList<>();
                ps = conectar().prepareStatement(cs_ESTADOfACTURA);
                ps.setString(1, estado);
                rs = ps.executeQuery();

                while (rs.next()) {
                    coleccionRetorno.add(getDataFactura(rs));
                }
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
