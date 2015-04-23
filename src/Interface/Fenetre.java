/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author mathieuchebassier
 */
public class Fenetre extends JFrame{
    public Fenetre()
    {
        // Déclaration variables
        JFrame fenetre = new JFrame();
        JButton rechercher = new JButton("Rechercher");
        JButton ajouter = new JButton("Ajouter");
        
        // On remplit
        fenetre.setTitle("Gestion Hopital");
        fenetre.setLayout(new GridLayout(2,2));
        
        
        fenetre.add(ajouter);
        fenetre.add(rechercher);
        
        // On gère les événements
        ajouter.
        
        // On affiche
        fenetre.setSize(400,400);
        fenetre.setVisible(true);      
    }
}
