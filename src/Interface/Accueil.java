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
    
    private static Accueil fenetre_accueil = null;
    private static JPanel p1, p2, p3, p7 ,pAdmin;
    
    /**
     * Constructeur de Accueil, on lui envoie la JFrame sur laquelle on ajoutera les éléments
     * @param f 
     */
    private Accueil(JFrame f)
    {
        JButton rechercher, ajouter, admin, stats;        
        
        // Déclaration variables
        rechercher = new JButton("Rechercher un patient");
        ajouter = new JButton("Ajouter un patient");
        admin = new JButton("Admin");
        stats = new JButton("Données statistiques");
        JLabel texte = new JLabel("Veuillez choisir ce que vous voulez faire");
        
        // Mise en page 
        
        // Taille des boutons
        rechercher.setPreferredSize(new Dimension(400,30));
        ajouter.setPreferredSize(new Dimension(400,30));
        stats.setPreferredSize(new Dimension(400,30));
        
        pAdmin = new JPanel();
        pAdmin.setOpaque(false);
        pAdmin.setLocation(100, 100);
        pAdmin.add(admin);
        pAdmin.setPreferredSize(new Dimension(100,100));

        
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
                new Choix_malade(f); // Pour celui ci, étant donné qu'on pose une question il faut recréer l'objet à chaque fois
          }
        });
        
        //Admin
        admin.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
             if(Mdp.mdp_fonctionnement(f)) 
             {
                    Admin.getFenetre(f); // On accede a la partie admin, le mdp est bon
             }
             else JOptionPane.showMessageDialog(null, "Le mot de passe est faux, l'accès est refusé", "Erreur", JOptionPane.ERROR_MESSAGE); // Le mdp est faux, on accede pas à la partie admin
          }
        });

        
        // Stats
        stats.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            Stats.getFenetre(f);
          }
        });
        
        
        
        
        f.setVisible(true);
    }
    
    /**
     * Sous programme permettant de vérifier que chaque 
     * fenêtre n'est crée qu'une fois puis uniquement réutilisée
     * @param f
     * @return type de la classe
     */
    public static Accueil getFenetre(JFrame f) {
            
    if (fenetre_accueil == null ) fenetre_accueil = new Accueil(f);
        
    // On affiche le reste
        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        f.add(pAdmin, BorderLayout.LINE_END); // POUR ALIGNER À DROITE
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p7);
        f.setSize(600,600);
        f.setVisible(true);
        return fenetre_accueil;
    }
}



