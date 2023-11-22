/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines.Servicios;

import ControlErrores.ControlErrores;
import dao.Servicios.ServiciosDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Servicios;

/**
 *
 * @author Dev
 */
public class ServiciosBussines extends ControlErrores
{
 
    public Collection<Servicios> traerListaServicios ()
    {
        Collection<Servicios> coleccionReturn;
        coleccionReturn = null;
        try 
        {
            Collection<Servicios> coleccion;
            coleccion = new ArrayList<Servicios>();
            ServiciosDao DaoServicio;
            DaoServicio = new ServiciosDao();

            coleccion = DaoServicio.consultaServicios();
            
            if(isValidCollection(coleccion))
            {
                coleccionReturn = coleccion;
            }
            
        } catch (SQLException e) 
        {
            System.out.println("ServiciosBussines::traerListaServicios "+e.getMessage());
        }
        
        return coleccionReturn;
    }
    
    public void insertarServicio(Servicios a_servicios)
    {
        try 
        {
            ServiciosDao DaoServicio;
            DaoServicio = new ServiciosDao();
            
            if(a_servicios != null)
            {
                DaoServicio.insertServicio(a_servicios);
            }

        } catch (SQLException e) 
        {
            System.out.println("ServiciosBussines::insertarServicio"+e.getMessage());
        }
    }
    
}
