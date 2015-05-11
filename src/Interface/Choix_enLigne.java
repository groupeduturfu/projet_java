/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import projet.Connexion;

/**
 *
 * @author mathieuchebassier
 */
public class Choix_enLigne {

    /**
     *
     * @param f
     */
    public Choix_enLigne(JFrame f)
    {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.QUESTION_MESSAGE;
        
        
        Object[] options = {"Par défault (chebassi)","Autre BDD"};
        int n = JOptionPane.showOptionDialog(f,"Sur quelle base de donnée souhaitez vous travailler ?","Recherche Employé",dialogButton,dialogResult,null, options, options[0]); //default button title
        if(n == 0) { // Il clique sur chebassi
             Connexion maconnexion = Connexion.getInstance(); // en ligne
        }
        else { // Il clique sur autre
           new Login(f);
        }
        
        Accueil.getFenetre(f);
    }
}
