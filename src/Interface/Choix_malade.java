/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author meyronneaudrey
 */
public class Choix_malade {
    
    private static Choix_malade fenetre = null;

    public Choix_malade(JFrame f) {
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(f, "Le patient est-il actuellement dans l'hôpital ?", "Title on Box", dialogButton);
        // Oui le patient est toujours dans l'hopital : recherche dans la table hospitalisation
        if(dialogResult == 0) {
          //new Fenetre_rechercher_patient(f); 
        } 
        // non le patient n'est plus dnas l'hopital : recherche dans les archives (table historique)
        else {
            //fenetre_rechercher_archives();
        }
        
    }
    
    public static Choix_malade getFenetre(JFrame f) {
            
    if (fenetre == null ) fenetre = new Choix_malade(f);

        return fenetre;
    }
    
    
}
