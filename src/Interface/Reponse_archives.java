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
public class Reponse_archives {
    private static Reponse_archives fenetre = null;
    
    private Reponse_archives (JFrame f) {
      
        // A coder
        
        
        
    }
    
    public static Reponse_archives getFenetre(JFrame f) {
            
    if (fenetre == null ) fenetre = new Reponse_archives(f);

        return fenetre;
    }
    
}
