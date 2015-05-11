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

    /**
     * fenetre afin de savoir si l'on chercher parmi les patient dans l'hopital
     * ou bien parmi les patients ayant séjourné dans le passé
     * @param f 
     */
    public Choix_malade(JFrame f) {
        
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(f, "Le patient est-il actuellement dans l'hôpital ?", "Choix de recherche", dialogButton);
        // Oui le patient est toujours dans l'hopital : recherche dans la table hospitalisation
        if(dialogResult == 0) {
          Rechercher_malade.getFenetre(f); 
        } 
        // non le patient n'est plus dnas l'hopital : recherche dans les archives (table historique)
        else {
            Rechercher_archives.getFenetre(f);
        }
        
    }
   
}


