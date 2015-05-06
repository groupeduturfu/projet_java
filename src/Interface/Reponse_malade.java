/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author meyronneaudrey
 */
public class Reponse_malade {
    
    private static Reponse_malade fenetre = null;
    
    private Reponse_malade (JFrame f) {
      
        // A coder
        
        
        
    }
    
    public static Reponse_malade getFenetre(JFrame f) {
            
    if (fenetre == null ) fenetre = new Reponse_malade(f);

        return fenetre;
    }
    
}
