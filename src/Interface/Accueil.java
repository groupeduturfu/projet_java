/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;


/**
 *
 * @author meyronneaudrey
 */
public class Accueil {
    
    private static Accueil fenetre = null;
    
    private Accueil(JFrame f)
    {
        JButton rechercher, ajouter, admin, emp_presents, lit_libre, stats;        
        
        // Déclaration variables
        rechercher = new JButton("Rechercher un patient");
        ajouter = new JButton("Ajouter un patient");
        admin = new JButton("Admin");
        emp_presents = new JButton("Employés présents");
        lit_libre = new JButton("Rechercher un lit libre");
        stats = new JButton("Données statistiques");
        JPanel p1, p2, p3, p5, p6, p7 ,pAdmin;
        JLabel texte = new JLabel("Veuillez choisir ce que vous voulez faire");
        
        // Mise en page 
        
        // Taille des boutons
        rechercher.setPreferredSize(new Dimension(400,30));
        ajouter.setPreferredSize(new Dimension(400,30));
        emp_presents.setPreferredSize(new Dimension(400,30));
        lit_libre.setPreferredSize(new Dimension(400,30));
        stats.setPreferredSize(new Dimension(400,30));
        
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
        // AJOUTER
        ajouter.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
                Ajouter_malade.getFenetre(f);
          }
        });
        
        // RECHERCHER
        rechercher.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
                Choix_malade.getFenetre(f);
          }
        });
        
        //Admin
        admin.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
             if(Mdp.mdp_fonctionnement()) 
             {
                    Admin.getFenetre(f); // On accede a la partie admin, le mdp est bon
             }
             else JOptionPane.showMessageDialog(null, "Le mot de passe est faux, l'accès est refusé", "Erreur", JOptionPane.ERROR_MESSAGE); // Le mdp est faux, on accede pas à la partie admin
          }
        });
        
        //Lit Libresif (rechercher.getModel().isPressed()) System.out.println("Recherche...");
        lit_libre.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
                System.out.println("Liste lits libres...");
          }
        });
        
        // Stats
        stats.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            System.out.println("Données statistiques...");
          }
        });
        
        // On affiche le reste
        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        f.add(pAdmin, BorderLayout.LINE_END); // POUR ALIGNER À DROITE
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p5);
        f.add(p6);
        f.add(p7);
        f.setSize(600,600);
        
        f.setVisible(true);
    }
    
    public static Accueil getFenetre(JFrame f) {
            
    if (fenetre == null ) fenetre = new Accueil(f);

        return fenetre;
    }
}



