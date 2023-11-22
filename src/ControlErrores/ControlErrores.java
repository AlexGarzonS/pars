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
public class ControlErrores {

    public boolean isValidCollection(Collection c) {
        boolean booleanReturn;
        booleanReturn = false;

        if (c != null) {
            if (!c.isEmpty()) {
                booleanReturn = true;
            }
        }

        return booleanReturn;
    }

    public boolean isValidString(String s) {
        boolean booleanReturn;
        booleanReturn = false;

        if (s != null) {
            if (s.length() > 0) {
                booleanReturn = true;
            }
        }

        return booleanReturn;
    }
    

}
