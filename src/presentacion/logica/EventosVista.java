/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.logica;

import ControlErrores.ControlErrores;
import bussines.Servicios.ServiciosBussines;
import com.sun.xml.internal.ws.util.StringUtils;
import java.awt.Choice;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Servicios;

/**
 *
 * @author Dev
 */
public class EventosVista {

    private ControlErrores e;

    private ControlErrores getE() {
        e = new ControlErrores();
        return e;
    }

    public Choice llenarListaServicios() {
        Choice returnser;

        returnser = new Choice();

        try {
            Collection<Servicios> colecionservicios;
            ServiciosBussines service;

            colecionservicios = new ArrayList<Servicios>();
            service = new ServiciosBussines();

            returnser.setSize(209, 320);
            returnser.addItem("0 - Seleccion");

            colecionservicios = service.traerListaServicios();

            if (getE().isValidCollection(colecionservicios)) {
                for (Servicios iterador : colecionservicios) {
                    returnser.addItem(iterador.getId_servcio() + " - " + iterador.getNombre_servicio());
                }
            }

        } catch (Exception ex) {
            System.out.println("EventosVista::llenarListaServicios " + "No es posible realizar consulta " + ex.getMessage());
        }
        return returnser;
    }

    public Object[] llenartablaServicios(String seleccion) {

        Object[] obj;
        obj = null;
        try {
            Collection<Servicios> colecionservicios;
            ServiciosBussines service;

            colecionservicios = new ArrayList<Servicios>();
            service = new ServiciosBussines();

            colecionservicios = service.traerListaServicios();

            if (getE().isValidCollection(colecionservicios)) {

                String[] parts;
                int id;
                String ids;

                id = 0;
                parts = seleccion.split("-");
                ids = parts[0].trim();

                if (e.isValidString(ids)) {
                    id = Integer.parseInt(ids);
                } else {
                    throw new Exception("No es posible capturar id");
                }

                for (Servicios iterador : colecionservicios) {
                    if (id == iterador.getId_servcio()) {
                        obj = new Object[]{
                            iterador.getNombre_servicio(), iterador.getValor()};
                    }

                }
            }

        } catch (Exception ex) {
            System.out.println("EventosVista::llenartablaServicios " + ex.getMessage());
        }
        return obj;
    }

    public double valorTotalServicios(String seleccion) {

        double obj;
        obj = 0;
        try {
            Collection<Servicios> colecionservicios;
            ServiciosBussines service;
            int seleccioni;
            String[] parts;
            seleccioni = 0;
            colecionservicios = new ArrayList<Servicios>();
            service = new ServiciosBussines();

            parts = seleccion.split("-");
            seleccioni = Integer.parseInt(parts[0].trim());
            colecionservicios = service.traerListaServicios();

            if (getE().isValidCollection(colecionservicios)) {
                for (Servicios iterador : colecionservicios) {
                    if (iterador.getId_servcio() == seleccioni) {
                        obj = iterador.getValor();
                    }
                }

            }

        } catch (NumberFormatException ex) {
            System.out.println("EventosVista::valorTotalServicios " + ex.getMessage());
        }
        return obj;
    }
}
