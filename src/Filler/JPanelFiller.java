/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filler;

import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author Samuel
 */
public class JPanelFiller {
    
    public JPanel fillPane(Component component, JPanel panel){
        
        panel.add(component);
        
        return panel;
    }
    
}
