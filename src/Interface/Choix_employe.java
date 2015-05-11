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
 * @author mathieuchebassier
 */
public class Choix_employe {
    
    /**
     * Fenetre où l'utilisateur à choisi d'ajouter un employé dans la BDD et 
     * on veut savoir si cet employé est un infirmier ou un docteur
     * @param f 
     */
    public Choix_employe(JFrame f)
    {
        Object[] options = {"Infirmier","Docteur"};
        int n = JOptionPane.showOptionDialog(f,"Quelle est la profession de l'emplyé recherché ?","Choix Recherche",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
        if (n==0) Rechercher_infirmier.getFenetre(f); // Infirmier
        else Rechercher_docteur.getFenetre(f); // Docteur
    }
}
