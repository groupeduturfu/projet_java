/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author meyronneaudrey
 */
public class Afficher_malade {
    
    private Afficher_malade fenetre = null;
    
     private Afficher_malade (JFrame f) {
         
        JTextField jtf_no_id, jtf_nom, jtf_prenom, jtf_no_chambre, jtf_no_lit, jtf_datea, jtf_adresse, jtf_tel, jtf_mutuelle;
        JLabel jl_no_id, jl_nom, jl_prenom, jl_no_chambre, jl_no_lit, jl_datea, jl_adresse, jl_tel, jl_mutuelle, texte;
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");
        JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;
        
        
        // On initialise les JLabel
        texte = new JLabel("Veuillez remplir les informations connues sur le patient");
        jl_no_id = new JLabel("N° identification");
        jl_nom = new JLabel("Nom");
        jl_prenom = new JLabel("Prénom");
        jl_no_chambre = new JLabel("N° chambre");
        jl_no_lit = new JLabel("N° lit");
        jl_datea = new JLabel("Date d'arrivée");
        jl_adresse = new JLabel("Adresse");
        jl_tel = new JLabel("N° telephone");
        jl_mutuelle = new JLabel("Mutuelle");
        
        // On iitialise les JTF
/*        jtf_no_id = new JTextField(no_id);
        jtf_nom = new JTextField(nom);
        jtf_prenom = new JTextField(prenom);
        jtf_no_chambre = new JTextField(no_chambre);
        jtf_no_lit = new JTextField(no_lit);
        jtf_datea = new JTextField(datea);
        jtf_adresse = new JTextField(adresse);
        jtf_tel = new JTextField(tel);
        jtf_mutuelle = new JTextField(mutuelle);
        
        jtf_no_id.setColumns(10);
        jtf_nom.setColumns(10);
        jtf_prenom.setColumns(10);
        jtf_no_chambre.setColumns(10);
        jtf_no_lit.setColumns(10);
        jtf_datea.setColumns(10);
        jtf_adresse.setColumns(10);
        jtf_tel.setColumns(10);
        jtf_mutuelle.setColumns(10);
        
        // On change le bouton de forme
        valider.setPreferredSize(new Dimension(200,30));
        valider.setOpaque(false);
        retour.setPreferredSize(new Dimension(200,30));
        retour.setOpaque(false);
        
        // On initialise les JPanel
        p1 = new JPanel();
        p1.add(texte);
        p1.setOpaque(false);
        p1.setPreferredSize(new Dimension(600, 100));
        
        p2 = new JPanel();
        p2.add(jl_no_id);
        p2.add(jtf_no_id);
        p2.setOpaque(false);
        p2.setPreferredSize(new Dimension(600, 30));
        
        p3 = new JPanel();
        p3.add(jl_nom);
        p3.add(jtf_nom);
        p3.setOpaque(false);
        p3.setPreferredSize(new Dimension(600, 30));
        
        p4 = new JPanel();
        p4.add(jl_prenom);
        p4.add(jtf_prenom);
        p4.setOpaque(false);
        p4.setPreferredSize(new Dimension(600, 30));
        
        p5 = new JPanel();
        p5.add(jl_no_chambre);
        p5.add(jtf_no_chambre);
        p5.setOpaque(false);
        p5.setPreferredSize(new Dimension(600, 30));
        
        p6 = new JPanel();
        p6.add(jl_no_lit);
        p6.add(jtf_no_lit);
        p6.setOpaque(false);
        p6.setPreferredSize(new Dimension(600, 30));
        
        p7 = new JPanel();
        p7.add(jl_datea);
        p7.add(jtf_datea);
        p7.setOpaque(false);
        p7.setPreferredSize(new Dimension(600, 30));
        
        p8 = new JPanel();
        p8.add(jl_adresse);
        p8.add(jtf_adresse);
        p8.setOpaque(false);
        p8.setPreferredSize(new Dimension(600, 30));
        
        p9 = new JPanel();
        p9.add(jl_tel);
        p9.add(jtf_tel);
        p9.setOpaque(false);
        p9.setPreferredSize(new Dimension(600, 30));
        
        p10 = new JPanel();
        p10.add(jl_mutuelle);
        p10.add(jtf_mutuelle);
        p10.setOpaque(false);
        p10.setPreferredSize(new Dimension(600, 30));
        
        p11 = new JPanel();
        p11.add(retour);
        p11.add(valider);
        p11.setOpaque(false);
        p11.setPreferredSize(new Dimension(600, 30));
        
        // On gère l'évennement du bouton
        valider.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            System.out.println("Il valide avec :");
            System.out.println("N° id : "+jtf_no_id.getText());
            System.out.println("Nom : "+jtf_nom.getText()); // ETC
            
            // ESSAI SEULEMENT : afficher en console tous les prenoms de la table malade si clique sur "Valider"
            try 
            {
                // Liste qui récupérera les tuples de réponse à notre requête
                ArrayList<String> liste;
                String requete = ("SELECT prenom FROM malade;");
                liste = maconnexion.RemplirChampsRequete(requete);
                
                // Loop through elements.
                for (int i = 0; i < liste.size(); i++) 
                {   
                    // Dans l'exemple on récupère une liste de prenom donc que des string => facilite pour le 1er essai 
                    String value = liste.get(i);
                    System.out.println("Element: " + value);
                }
                
            }
            catch (SQLException ex)
            {
                System.out.println("Echec SQL");
                ex.printStackTrace();
            }
                       
          }
        });
        
        retour.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            fenetre_accueil();
          }
        });
        
        // On ajoute tous les JPannel à la fenêtre
        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        f.add(p5);
        f.add(p6);
        f.add(p7);
        f.add(p8);
        f.add(p9);
        f.add(p10);
        f.add(p11);
        
        f.setSize(600,600);
        
        f.setVisible(true);
        */
    }
}
    

