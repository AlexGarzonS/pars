/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.logica;

import ControlErrores.ControlErrores;
import bussines.Facturas.FacturasBusiness;
import bussines.Servicios.ServiciosBussines;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.table.DefaultTableModel;
import modelo.Facturas.Facturas;
import modelo.Servicios.Servicios;

/**
 *
 * @author Dev
 */
public class Facturasvista {
    
    
    public DefaultTableModel ListaFacturas() {
        Collection<Facturas> collectionServices;
        DefaultTableModel model;

        collectionServices = null;
        model = null;
        try {
            ControlErrores utils;
            FacturasBusiness facturasB;
            
            facturasB = new FacturasBusiness();

            utils = new ControlErrores();
            
            collectionServices = new ArrayList<Facturas>();

            collectionServices = facturasB.ConsultarFacturas();

            if (utils.isValidCollection(collectionServices)) 
            {
                Object[] obj;
                model = new DefaultTableModel();
                obj = null;

                model.addColumn("ID");
                model.addColumn("ID EVENTO");
                model.addColumn("ID CLIENTE");
                model.addColumn("FECHA");
                model.addColumn("SUB TOTAL");
                model.addColumn("VALOR TOTAL");

                for (Facturas iterador : collectionServices) {

                    obj = new Object[]{iterador.getIdfactura(), iterador.getIdEvento(), iterador.getIdcliente(),
                    iterador.getFecha(), iterador.getSubvalor(), iterador.getValor()};
                    model.addRow(obj);
                }

            } else {
                System.out.println("No hay datos");
            }
        } catch (Exception e) {
            System.out.println("ServiciosVista::Listaservicios " + "No es posible realizar consulta " + e.getMessage());
        }
        return model;
    }
}
