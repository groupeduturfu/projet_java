/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
    //    JFrame fenetre = new JFrame();
        JButton rechercher = new JButton("Rechercher");
        JButton ajouter = new JButton("Ajouter");
        JPanel p1, p2;
        JLabel texte = new JLabel("Veuillez choisir ce que vous voulez faire");
        
        // On remplit
        this.setTitle("Gestion Hopital");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Quand on clique sur la croix, ça quitte proprement
        this.setLayout(new GridLayout(2,2)); // La fenêtre est répartie en grille : 2 lignes, 2 colonnes

        
        p1 = new JPanel(); 
        texte.setVerticalAlignment(JLabel.CENTER); // On aligne le texte au centre de p1, mais ca ne marche pas
        p1.add(texte);
        
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,2));
        p2.add(ajouter);
        p2.add(rechercher);
        
        // On gère les événements
        
        // On affiche le reste
        this.setContentPane(new ImagePanel(new ImageIcon("fond.jpg").getImage())); // Met l'image en background
        this.add(p1);
        this.add(p2);
        this.setSize(600,600);
        
        this.setVisible(true);    
    }
}