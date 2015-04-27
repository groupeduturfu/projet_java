/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author mathieuchebassier
 */
public class Fenetre extends JFrame{
    final JButton rechercher, ajouter, admin, consulter, emp_presents, lit_libre, stats;
    final int taille_boutonX=30;
    final int taille_boutonY=400;
    public Fenetre()
    {
    

 // Déclaration variables
        rechercher = new JButton("Rechercher un patient");
        ajouter = new JButton("Ajouter un patient");
        admin = new JButton("Admin");
        consulter = new JButton("Consulter les archives (Patients partis");
        emp_presents = new JButton("Employés présents");
        lit_libre = new JButton("Rechercher un lit libre");
        stats = new JButton("Données statistiques");
        JPanel p1, p2;
        JLabel texte = new JLabel("Veuillez choisir ce que vous voulez faire");
        
        // Mise en page 
        
        // Taille des boutons
        rechercher.setSize(taille_boutonX, taille_boutonY);
        ajouter.setSize(taille_boutonX, taille_boutonY);
        consulter.setSize(taille_boutonX, taille_boutonY);
        emp_presents.setSize(taille_boutonX, taille_boutonY);
        lit_libre.setSize(taille_boutonX, taille_boutonY);
        stats.setSize(taille_boutonX, taille_boutonY);
        
        // On remplit
        this.setTitle("Gestion Hopital");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Quand on clique sur la croix, ça quitte proprement
        this.setLayout(new GridLayout(1,1)); // La fenêtre est répartie en grille : 8 lignes, 2 colonnes

        
        p1 = new JPanel(); 
        texte.setVerticalAlignment(JLabel.CENTER); // On aligne le texte au centre de p1, mais ca ne marche pas
        p1.add(texte);
        p1.setOpaque(false);
        
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(7,1));
        p2.add(ajouter);
        p2.add(rechercher);
        p2.add(consulter);
        p2.add(emp_presents);
        p2.add(lit_libre);
        p2.add(stats);
        p2.setOpaque(false);
        
        // On gère les événements
        if (rechercher.getModel().isPressed()) System.out.println("Recherche...");
        ajouter.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            System.out.println("Ajouter");
          }
        });
        
        // On affiche le reste
        this.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        this.add(p1);
        this.add(p2);
        this.setSize(600,600);
        
        this.setVisible(true);   
    }
    
    

   
    public void fenetre_accueil(JFrame f)
    {
        // Déclaration variables
        JButton rechercher = new JButton("Rechercher un patient");
        JButton ajouter = new JButton("Ajouter un patient");
        JButton admin = new JButton("Admin");
        JButton consulter = new JButton("Consulter les archives (Patients partis");
        JButton emp_presents = new JButton("Employés présents");
        JButton lit_libre = new JButton("Rechercher un lit libre");
        JButton stats = new JButton("Données statistiques");
        JPanel p1, p2;
        JLabel texte = new JLabel("Veuillez choisir ce que vous voulez faire");
        
        // Mise en page 
        
        // Taille des boutons
        rechercher.setSize(taille_boutonX, taille_boutonY);
        ajouter.setSize(taille_boutonX, taille_boutonY);
        consulter.setSize(taille_boutonX, taille_boutonY);
        emp_presents.setSize(taille_boutonX, taille_boutonY);
        lit_libre.setSize(taille_boutonX, taille_boutonY);
        stats.setSize(taille_boutonX, taille_boutonY);
        
        // On remplit
        this.setTitle("Gestion Hopital");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Quand on clique sur la croix, ça quitte proprement
        this.setLayout(new GridLayout(1,1)); // La fenêtre est répartie en grille : 8 lignes, 2 colonnes

        
        p1 = new JPanel(); 
        texte.setVerticalAlignment(JLabel.CENTER); // On aligne le texte au centre de p1, mais ca ne marche pas
        p1.add(texte);
        p1.setOpaque(false);
        
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(7,1));
        p2.add(ajouter);
        p2.add(rechercher);
        p2.add(consulter);
        p2.add(emp_presents);
        p2.add(lit_libre);
        p2.add(stats);
        p2.setOpaque(false);
        
        // On gère les événements
        if (rechercher.getModel().isPressed()) System.out.println("Recherche...");
        ajouter.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            System.out.println("Ajouter");
          }
        });
        
        // On affiche le reste
        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        f.add(p1);
        f.add(p2);
        f.setSize(600,600);
        
        f.setVisible(true);  
    }
}

