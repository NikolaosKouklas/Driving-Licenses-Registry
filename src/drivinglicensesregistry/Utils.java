/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drivinglicensesregistry;

/**
 *
 * @author Nikolaos
 */
public class Utils {
    
    static boolean isInteger(String s) {
        
        try {
            Integer.parseInt(s);
        }
        catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    static boolean isShort(String s) {
        
        try {
            Short.parseShort(s);
        }
        catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    
}
