/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author mathieuchebassier
 */
public class Fenetre extends JFrame{
    final JButton rechercher, ajouter, admin, consulter, emp_presents, lit_libre, stats;
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
        JPanel p1, p2, p3, p4, p5, p6, p7 ,pAdmin;
        JLabel texte = new JLabel("Veuillez choisir ce que vous voulez faire");
        
        // Mise en page 
        
        // Taille des boutons
        rechercher.setPreferredSize(new Dimension(400,30));
        ajouter.setPreferredSize(new Dimension(400,30));
        consulter.setPreferredSize(new Dimension(400,30));
        emp_presents.setPreferredSize(new Dimension(400,30));
        lit_libre.setPreferredSize(new Dimension(400,30));
        stats.setPreferredSize(new Dimension(400,30));
        
        // On remplit
        this.setTitle("Gestion Hopital");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Quand on clique sur la croix, ça quitte proprement
        this.setLayout(new FlowLayout()); // La fenêtre est répartie en grille : 8 lignes, 2 colonnes

        pAdmin = new JPanel();
        pAdmin.setOpaque(false);;
        pAdmin.add(admin);
        admin.setHorizontalTextPosition(SwingConstants.RIGHT);

        
        p1 = new JPanel(); 
        p1.setOpaque(false);
        p1.setPreferredSize(new Dimension(600, 100));
        p1.setLayout(new FlowLayout());
        texte.setVerticalAlignment(CENTER);
        texte.setVerticalAlignment(JLabel.CENTER); // On aligne le texte au centre de p1, mais ca ne marche pas
        p1.add(texte);
        
        
        // On crée les JPanel contenanant les boutons
        p2 = new JPanel();
        p2.add(ajouter);
        p2.setOpaque(false);
        
        p3 = new JPanel();
        p3.add(rechercher);
        p3.setOpaque(false);
        
        p4 = new JPanel();
        p4.add(consulter);
        p4.setOpaque(false);
        
        p5 = new JPanel();
        p5.add(emp_presents);
        p5.setOpaque(false);
        
        p6 = new JPanel();
        p6.add(lit_libre);
        p6.setOpaque(false);
        
        p7 = new JPanel();
        p7.add(stats);
        p7.setOpaque(false);
        
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
        this.add(pAdmin, BorderLayout.LINE_END); // POUR ALIGNER À DROITE
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
        this.add(p7);
        this.setSize(600,600);
        
        this.setVisible(true);   
    }
    
    

   // A terme j'aimerai faire ça
    public void fenetre_accueil(JFrame f)
    {
         
    }
}

