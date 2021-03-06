/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel
 */
public class Dialoger {
    
    
    public static void message(Component component, String body){
        
        JOptionPane.showMessageDialog(component, body);
        
    }
    
    public static void errorMessage(Component component, Exception exception){
        
        JOptionPane.showMessageDialog(component, exception.getMessage(), "Occorreu um Erro", JOptionPane.WARNING_MESSAGE);
    
        exception.printStackTrace();
    }
    
    public static void errorMessage(Component component, String message, Exception exception){
        
        JOptionPane.showMessageDialog(component, exception.getMessage(), message, JOptionPane.WARNING_MESSAGE);
        
        exception.printStackTrace();
    }

    public static boolean confirm(Component component, String body) {
       
       if(JOptionPane.showConfirmDialog(component, body) == JOptionPane.YES_OPTION){
           
           return true;
       }else{
           return false;
       } 
    }

    public static String inputDialog(Component component, String message) {
        
        return JOptionPane.showInputDialog(component, message);
    }
    
    public static String inputDialog(Component component, String title, String message) {
        
        return JOptionPane.showInputDialog(component, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
