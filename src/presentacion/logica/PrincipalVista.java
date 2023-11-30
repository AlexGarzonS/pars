/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.logica;

import ControlErrores.ControlErrores;
import bussines.Servicios.ServiciosBussines;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Servicios.Servicios;

/**
 *
 * @author JGARZON
 */
public class PrincipalVista {

    /*Clase especializada para controlar errores*/
    private ControlErrores e;
    /*Instanciación ControlErrores*/
    private ControlErrores getE() {
        e = new ControlErrores();
        return e;
    }
    /*Funcion para mostrar mensajes personalizados*/
    public String getVision() {
        StringBuilder vision;

        vision = new StringBuilder();
        try {
            vision.append("Ser uno de los mayores proveedores de servicios para eventos");
            vision.append("de esta manera siento referentes en el mercado de los eventos");
        } catch (Exception ex) {
            System.out.println("No es posible cargar visión "+ex);
        }
        return vision.toString();
    }
    /*Funcion para mostrar mensajes personalizados*/
    public String getMision() {
        StringBuilder mision;

        mision = new StringBuilder();
        try {
            mision.append("Ofrecer los mejores servicios para administración y gestión de eventos");
            mision.append("con los estantares mas altos del mercado");

        } catch (Exception ex) {
            System.out.println("No es posible cargar visión "+ex);
        }
        return mision.toString();
    }
    /*Funcion para mostrar mensajes personalizados*/
    public String getHacemos() {
        String retunMesaje;
        retunMesaje = null;
        try {
            StringBuilder hacemos;
            String caneda;

            hacemos = new StringBuilder();
            caneda ="";
            ServiciosBussines serviceb;
            Collection<Servicios> serviciosC;
            serviceb = new ServiciosBussines();
            serviciosC = new ArrayList<>();

            serviciosC = serviceb.traerListaServicios();

            if (getE().isValidCollection(serviciosC)) {
                hacemos.append("Ofrecer servios de : ").append('\n');
                for (Servicios iterator : serviciosC) {
                    hacemos.append(" - ");
                    hacemos.append(iterator.getNombre_servicio()).append('\n');

                }
            }
            if (getE().isValidString(hacemos.toString())) {
                caneda = hacemos.toString();
                retunMesaje = caneda;
            }

        } catch (Exception ex) {
            System.out.println("No es posible cargar hacemos" + ex);
        }
        return retunMesaje;
    }
}
