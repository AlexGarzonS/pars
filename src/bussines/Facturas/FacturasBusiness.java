package bussines.Facturas;

import ControlErrores.ControlErrores;
import dao.Facturas.FacturasDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Facturas.Facturas;

/**
 *
 * @author JGARZON
 */
public class FacturasBusiness extends ControlErrores {

    /**
     *
     * Colección de facturas consultadas en la base de datos
     *
     * @return coleccion de facturas
     */
    public Collection<Facturas> ConsultarFacturas() {
        Collection<Facturas> coleccionReturn;
        coleccionReturn = null;
        try {
            Collection<Facturas> coleccion;
            coleccion = new ArrayList<>();
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

    /**
     *
     * Coleccion de facturas con los diferentes estados
     *
     * @param estado Estado a buscar
     * @return coleccion de facturas
     */
    public Collection<Facturas> ConsultarFacturasEstado(String estado) {
        Collection<Facturas> coleccionReturn;
        coleccionReturn = null;
        try {
            if (isValidString(estado)) {
                Collection<Facturas> coleccion;
                coleccion = new ArrayList<>();
                FacturasDao facturaDao;
                facturaDao = new FacturasDao();

                coleccion = facturaDao.consultaFacturasEstado(estado);

                if (isValidCollection(coleccion)) {
                    coleccionReturn = coleccion;
                }
            }

        } catch (SQLException e) {
            System.out.println("FacturasBusiness::ConsultarFacturas " + e.getMessage());
        }

        return coleccionReturn;
    }
}
