/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.logica;

import ControlErrores.ControlErrores;
import bussines.Servicios.ServiciosBussines;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.table.DefaultTableModel;
import modelo.Servicios;

/**
 *
 * @author Dev
 */
public class ServiciosVista {

    /**
     *
     * @return
     */
    public DefaultTableModel Listaservicios() {
        Collection<Servicios> collectionServices;
        DefaultTableModel model;

        collectionServices = null;
        model = null;
        try {
            ControlErrores utils;
            ServiciosBussines service;

            utils = new ControlErrores();
            service = new ServiciosBussines();
            collectionServices = new ArrayList<>();

            collectionServices = service.traerListaServicios();

            if (utils.isValidCollection(collectionServices)) 
            {
                Object[] obj;
                model = new DefaultTableModel();
                obj = null;

                model.addColumn("ID");
                model.addColumn("NOMBRE");
                model.addColumn("DESCRIPCION");
                model.addColumn("VALOR");

                for (Servicios iterador : collectionServices) {

                    obj = new Object[]{iterador.getId_servcio(), iterador.getNombre_servicio(), iterador.getDescripcion(), iterador.getValor()};
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
    
    public void insertarServicio(Servicios a_servicio)
    {
        try 
        {
         ServiciosBussines service;
         service = new ServiciosBussines();
         
         if(a_servicio != null)
         {
             service.insertarServicio(a_servicio);
         }
                  
        } catch (Exception e) {
            System.out.println("ServiciosVista::insertarServicio " + "No insertar nuevo registro " + e.getMessage());
        }
    }

}
