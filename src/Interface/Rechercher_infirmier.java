/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mathieuchebassier
 */
public class Rechercher_infirmier {
    
    private static Rechercher_infirmier fenetre = null;
    
    public Rechercher_infirmier(JFrame f)
    {
        JLabel jl_rotation, jl_nom, jl_prenom, jl_date, jl_adresse, jl_no_id, jl_tel, jl_salaire, jl_nom_service;
        JTextField jtf_rotation, jtf_no_id, jtf_nom, jtf_prenom, jtf_date, jtf_adresse, jtf_tel, jtf_salaire, jtf_nom_service;
        JPanel panel, p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p8b;
        JLabel texte = new JLabel("Veuillez remplir les informations connues sur le patient");
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");
        
        // On initialise les JLabel
        jl_rotation = new JLabel("Spécialité");
        jl_no_id = new JLabel("N° identification");
        jl_nom = new JLabel("Nom");
        jl_prenom = new JLabel("Prénom");
        jl_date = new JLabel("Date de naissance");
        jl_adresse = new JLabel("Adresse");
        jl_tel = new JLabel("N° telephone");
        jl_salaire = new JLabel("Salaire");
        jl_nom_service = new JLabel("Nom du service");
        
        // On iitialise les JTF
        jtf_no_id = new JTextField();
        jtf_nom = new JTextField();
        jtf_prenom = new JTextField();
        jtf_date = new JTextField();
        jtf_adresse = new JTextField();
        jtf_rotation = new JTextField();
        jtf_tel = new JTextField();
        jtf_salaire = new JTextField();
        jtf_nom_service = new JTextField();
        
        
        jtf_no_id.setColumns(20);
        jtf_nom.setColumns(20);
        jtf_prenom.setColumns(20);
        jtf_date.setColumns(20);
        jtf_adresse.setColumns(20);
        jtf_rotation.setColumns(20);
        jtf_tel.setColumns(20);
        jtf_salaire.setColumns(20);
        jtf_nom_service.setColumns(20);
        
        
        // On change le bouton de forme
        valider.setPreferredSize(new Dimension(200,30));
        valider.setOpaque(false);
        retour.setPreferredSize(new Dimension(200,30));
        retour.setOpaque(false);
        
        // On initialise les JPanel
        p0 = new JPanel();
        p0.add(texte);
        p0.setOpaque(false);
        p0.setPreferredSize(new Dimension(600, 100));
        
        p1 = new JPanel();
        p1.add(jl_no_id);
        p1.add(jtf_no_id);
        p1.setOpaque(false);
        p1.setPreferredSize(new Dimension(600, 30));
        
        p2 = new JPanel();
        p2.add(jl_nom);
        p2.add(jtf_nom);
        p2.setOpaque(false);
        p2.setPreferredSize(new Dimension(600, 30));
        
        p3 = new JPanel();
        p3.add(jl_prenom);
        p3.add(jtf_prenom);
        p3.setOpaque(false);
        p3.setPreferredSize(new Dimension(600, 30));
        
        p4 = new JPanel();
        p4.add(jl_date);
        p4.add(jtf_date);
        p4.setOpaque(false);
        p4.setPreferredSize(new Dimension(600, 30));
        
        p5 = new JPanel();
        p5.add(jl_adresse);
        p5.add(jtf_adresse);
        p5.setOpaque(false);
        p5.setPreferredSize(new Dimension(600, 30));
   
        p6 = new JPanel();
        p6.add(jl_tel);
        p6.add(jtf_tel);
        p6.setOpaque(false);
        p6.setPreferredSize(new Dimension(600, 30));
       
        p7 = new JPanel();
        p7.add(jl_salaire);
        p7.add(jtf_salaire);
        p7.setOpaque(false);
        p7.setPreferredSize(new Dimension(600, 30));
        
        p8 = new JPanel();
        p8.add(jl_rotation);
        p8.add(jtf_rotation);
        p8.setOpaque(false);
        p8.setPreferredSize(new Dimension(600, 30));
        
        p8b = new JPanel();
        p8b.add(jl_nom_service);
        p8b.add(jtf_nom_service);
        p8b.setOpaque(false);
        p8b.setPreferredSize(new Dimension(600, 30));
        
        p9 = new JPanel();
        p9.add(retour);
        p9.add(valider);
        p9.setOpaque(false);
        p9.setPreferredSize(new Dimension(600, 30));
        
        // On gère l'évennement du bouton
        valider.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
              // Requete pour rechercher un infirmier
          }
        });
        
        retour.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {
              Admin.getFenetre(f);
          }
        });
                
        // On ajoute tous les JPannel à la fenêtre
        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        f.add(p0);
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        f.add(p5);
        f.add(p6);
        f.add(p7);
        f.add(p8);
        f.add(p9);
        
        f.setSize(600,600);
        
        f.setVisible(true); 
                
          
    }
    
    public static Rechercher_infirmier getFenetre(JFrame f) {
            
    if (fenetre == null ) fenetre = new Rechercher_infirmier(f);

        return fenetre;
    }
}
