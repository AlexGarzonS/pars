/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines;

import ControlErrores.CollectionsUtils;
import dao.ServiciosDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Servicios;

/**
 *
 * @author Dev
 */
public class ServiciosBussines extends CollectionsUtils
{
 
    public Collection<Servicios> traerListaServicios ()
    {
        Collection<Servicios> coleccionReturn;
        coleccionReturn = null;
        try 
        {
            Collection<Servicios> coleccion;
            coleccion= null;
            ServiciosDao DaoServicio;
            DaoServicio = new ServiciosDao();
            coleccion = new ArrayList<>();
            
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
    
}
