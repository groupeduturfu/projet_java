/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JFrame;

/**
 *
 * @author mathieuchebassier
 */
public class Stats {
    
    private static Stats fenetre = null;
    
    private Stats(JFrame f)
    {
        // Y'a rien pour l'instant
    }
    
    public static Stats getFenetre(JFrame f) {
            
    if (fenetre == null ) fenetre = new Stats(f);

        return fenetre;
    }

   
}
