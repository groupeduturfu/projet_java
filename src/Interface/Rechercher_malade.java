/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import projet.Connexion;

/**
 *
 * @author meyronneaudrey
 */
public class Rechercher_malade {
    
    private static Rechercher_malade fenetre = null;
    private static JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;
    private Connexion maconnexion;
        
    private Rechercher_malade (JFrame f) {

JTextField jtf_no_id, jtf_nom, jtf_prenom, jtf_no_chambre, jtf_no_lit, jtf_datea, jtf_adresse, jtf_tel, jtf_mutuelle;
        JLabel jl_no_id, jl_nom, jl_prenom, jl_no_chambre, jl_no_lit, jl_datea, jl_adresse, jl_tel, jl_mutuelle, texte;
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");
        JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;
        maconnexion=Connexion.getInstance();
                    
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
        jtf_no_id = new JTextField();
        jtf_nom = new JTextField();
        jtf_prenom = new JTextField();
        jtf_no_chambre = new JTextField();
        jtf_no_lit = new JTextField();
        jtf_datea = new JTextField();
        jtf_adresse = new JTextField();
        jtf_tel = new JTextField();
        jtf_mutuelle = new JTextField();
        
        jtf_no_id.setColumns(10);
        jtf_nom.setColumns(10);
        jtf_prenom.setColumns(10);
        jtf_no_chambre.setColumns(10);
        jtf_no_lit.setColumns(10);
        jtf_datea.setColumns(10);
        jtf_adresse.setColumns(40);
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
            // Pour la recherche des patients hopsitalisés et la recherche dans les archives
            int id_recu;  
            String nom_recu;
            String prenom_recu;
            int no_chambre_recu;
            int no_lit_recu;
            String adresse_recu;
            String tel_recu;
            String mutuelle_recu;
            String date_arrivee_recu;
            String requete;

            
            // si l'utilisateur n'a pas rempli certains champs, on initialise ces champs avec les valeurs 0 et null
            // no identification
            if(jtf_no_id.getText().equals(""))
                id_recu = 0;
            else id_recu = Integer.parseInt(jtf_no_id.getText().trim());
            // nom
            if(jtf_nom.getText().equals(""))
                nom_recu = "%";
            else nom_recu= jtf_nom.getText();
            // prenom
            if(jtf_prenom.getText().equals(""))
                prenom_recu = "%";
            else prenom_recu= jtf_prenom.getText();
            // no chambre
            if(jtf_no_chambre.getText().equals(""))
                no_chambre_recu = 0;
            else no_chambre_recu = Integer.parseInt(jtf_no_chambre.getText().trim());            
            // no lit
            if(jtf_no_lit.getText().equals(""))
                no_lit_recu = 0;
            else no_lit_recu = Integer.parseInt(jtf_no_lit.getText().trim());
            // date arrivée
            if(jtf_datea.getText().equals(""))
                date_arrivee_recu = "%";
            else date_arrivee_recu= jtf_datea.getText();
            //adresse
            if(jtf_adresse.getText().equals(""))
                adresse_recu = "%";
            else adresse_recu= jtf_adresse.getText();
            //tel
            if(jtf_tel.getText().equals(""))
                tel_recu = "%";
            else tel_recu= jtf_tel.getText();
            //mutuelle
            if(jtf_mutuelle.getText().equals(""))
                mutuelle_recu = "%";
            else mutuelle_recu= jtf_mutuelle.getText();

            // chaine de caractère dans laquelle on écrit la requete correspondant aux infos du formulaire rempli 
           

            ArrayList<ArrayList<String>> liste =null;
            // écriture de la requete exacte en fonction de la maniere dont a été rempli le formulaire
            requete = maconnexion.CreerRequete_Recherche_Hospitalisation(id_recu, nom_recu, prenom_recu, no_chambre_recu, no_lit_recu, adresse_recu, tel_recu, mutuelle_recu, date_arrivee_recu);

            try 
            {
                // on envoit la requete à la base de données via RemplirChampsRequete qui est dans la classe Connexion
                liste = maconnexion.RemplirChampsRequete_Malade(requete);
                int taille=liste.size();
                // On affiche le résultat de la requete
                for (int i = 0; i < liste.size(); i++)
                {
                
                    // Connnexion renvoit un tableau de String, avec dans chaque string tous les attirbuts désirés par la requete séparés par des virgules
                    ArrayList<String> value = liste.get(i);
                    System.out.println("" + value);
                }
                
                // si la recherche n'aboutit à aucun malade, on affiche un message d'erreur
                if (taille ==0)
                {
                    JOptionPane.showMessageDialog(null, "Aucun patient ne correspond à votre recherche. Regardez dans les archives.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    Rechercher_archives.getFenetre(f);
                }
                
            }
            catch (SQLException ex)
            {
                System.out.println("Echec SQL");
                ex.printStackTrace();
            }
            
           Afficher_malade.getFenetre(f, liste);
                       
          }
        });
                retour.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            Accueil.getFenetre(f);
          }
        });
        
        
        // On ajoute tous les JPannel à la fenêtre
        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
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
        
    

         
        
    }
    
    public static Rechercher_malade getFenetre(JFrame f) {
            
    if (fenetre == null ) fenetre = new Rechercher_malade(f);

    // On ajoute tous les JPannel à la fenêtre

        
        return fenetre;
    }
}
