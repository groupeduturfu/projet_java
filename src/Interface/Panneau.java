/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author mathieuchebassier
 */
public class Panneau extends JPanel {

    public void accueil(Graphics g)
    {
        // Déclaration variables
        JFrame fenetre = new JFrame();
        JButton rechercher = new JButton("Rechercher");
        JButton ajouter = new JButton("Ajouter");
        
        fenetre.setTitle("Accueil");
        
        fenetre.add(ajouter);
        fenetre.add(rechercher);
        
        fenetre.setSize(400,400);
        fenetre.setVisible(true);      
    }
    
    public void afficherTexte(Graphics g)
    {
        String phrase = "Merci de cliquer sur le bouton correspondant à ce que vous souhaitez faire.";
        g.drawString(phrase, 50, 50);
    }
}
