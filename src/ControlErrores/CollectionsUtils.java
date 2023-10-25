/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlErrores;

import java.util.Collection;

/**
 *
 * @author Dev
 */
public class CollectionsUtils 
{
    
    public boolean isValidCollection(Collection c)
    {
        boolean booleanReturn;
        booleanReturn = true;
        
        if(c.isEmpty())
        {
            booleanReturn = false;
        }
        else if(c == null)
        {
            booleanReturn = false;
        }
        
        return booleanReturn;
    }

}
