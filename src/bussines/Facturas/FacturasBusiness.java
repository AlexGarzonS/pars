/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines.Facturas;

import ControlErrores.ControlErrores;
import dao.Facturas.FacturasDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Facturas.Facturas;

/**
 *
 * @author Dev
 */
public class FacturasBusiness extends ControlErrores {

    public Collection<Facturas> ConsultarFacturas() {
        Collection<Facturas> coleccionReturn;
        coleccionReturn = null;
        try {
            Collection<Facturas> coleccion;
            coleccion = new ArrayList<Facturas>();
            FacturasDao facturaDao;
            facturaDao = new FacturasDao();

            coleccion = facturaDao.consultaFacturas();

            if (isValidCollection(coleccion)) {
                coleccionReturn = coleccion;
            }

        } catch (SQLException e) {
            System.out.println("FacturasBusiness::ConsultarFacturas " + e.getMessage());
        }

        return coleccionReturn;
    }
}
