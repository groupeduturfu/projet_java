/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author meyronneaudrey
 */
public class Admin {
    
    private static Admin fenetre = null ;
    private static JPanel p1, p2, p3, p4, p5, p6;
    
    /**
     * Constructeur de la classe Admin, on lui envoie la JFrame dans laquelle
     * il ajoutera ses objets
     * @param f 
     */
    private Admin (JFrame f) {
         
        JButton employe, ajouter, service, chambre, retour;
        JLabel texte = new JLabel("Veuillez choisir ce que vous voulez faire");
        
        // Déclaration variables
        employe = new JButton("Rechercher un employé");
        ajouter = new JButton("Ajouter un employé");
        service = new JButton("Rechercher un service");
        chambre = new JButton("Rechercher une chambre");
        
        retour = new JButton("Retour");
        retour.setPreferredSize(new Dimension(200,30));
        retour.setOpaque(false);
        
        // Taille des boutons
        employe.setPreferredSize(new Dimension(400,30));
        ajouter.setPreferredSize(new Dimension(400,30));
        service.setPreferredSize(new Dimension(400,30));
        chambre.setPreferredSize(new Dimension(400,30));

        
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
        p3.add(employe);
        p3.setOpaque(false);
        
        p4 = new JPanel();
        p4.add(service);
        p4.setOpaque(false);
        
        p5 = new JPanel();
        p5.add(chambre);
        p5.setOpaque(false);
        
        p6 = new JPanel();
        p6.add(retour);
        p6.setOpaque(false);
        
        // On gère les événements
        // AJOUTER un emp
        ajouter.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
                Ajouter_employe.getFenetre(f);
          }
        });
        
        // recherche un employé
        employe.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            // Ici on rechercher employé
              new Choix_employe(f); // Ici on crée a chaque fois l'objet car c'est un choix qui peut être différent a chaque fois
                
          }
        });
        
        //recherche chambre
        chambre.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            Rechercher_chambre.getFenetre(f);
          }
        });
        
        //recherche service
        service.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            
          }
        });
        
        //retour
        retour.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
              Accueil.getFenetre(f);
          }
        });
        
        
    }
    
    
    /**
     * Sous programme permettant de vérifier que chaque 
     * fenêtre n'est crée qu'une fois puis uniquement réutilisée
     * @param f
     * @return type de la classe
     */
    public static Admin getFenetre(JFrame f) {
            
    if (fenetre == null ) fenetre = new Admin(f);

        // On affiche le reste
        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        f.add(p5);
        f.add(p6);
        f.setSize(600,600);
        
        f.setVisible(true);
    
        return fenetre;
    }
}
