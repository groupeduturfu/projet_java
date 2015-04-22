/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author mathieuchebassier
 */
public class Vue extends JFrame {
    private Container fenetre;
    
    public Vue()
    {
        JButton valider = new JButton("Test");
        fenetre.add(valider);
        
    }
}
