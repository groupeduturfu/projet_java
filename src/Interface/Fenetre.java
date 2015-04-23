/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.GridLayout;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        JPanel p1, p2;
        
        // On remplit
        fenetre.setTitle("Gestion Hopital");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Quand on clique sur la croix, ça quitte proprement
        fenetre.setLayout(new GridLayout(3,2)); // La fenêtre est répartie en grille : 3 lignes, 2 colonnes
        
        p1 = new JPanel();
        p1.add(new JLabel("Veuillez choisir ce que vous voulez faire"));
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,2));
        p2.add(ajouter);
        p2.add(rechercher);
        
        // On gère les événements
        
        // On affiche
        fenetre.add(p1);
        fenetre.add(p2);
        fenetre.setSize(400,200);
        fenetre.setVisible(true);      
    }
}
