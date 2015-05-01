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
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import projet.Connexion;

/**
 *
 * @author mathieuchebassier
 */
public class Fenetre extends JFrame{
   // final JButton rechercher, ajouter, admin, consulter, emp_presents, lit_libre, stats;

    // Attribut privés : objet de Connexion
    private Connexion maconnexion;
    
    
    public Fenetre()
    {
        try 
        {
            try 
            {
                // tentative de connexion si les 4 attributs sont remplis
                 maconnexion = new Connexion();
            } 
            catch (ClassNotFoundException cnfe) 
            {
                System.out.println("Connexion echouee : probleme de classe");
                cnfe.printStackTrace();
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("Connexion echouee : probleme SQL");
            e.printStackTrace();
        }
        
        
        this.setTitle("Gestion Hopital");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Quand on clique sur la croix, ça quitte proprement
        this.setLayout(new FlowLayout()); // La fenêtre est répartie en grille : 8 lignes, 2 colonnes
        
        fenetre_accueil();
        //fenetre_rechercher_patient();
        
    }
    
    
    public void fenetre_accueil()
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
                fenetre_ajouter_patient();
          }
        });
        
        // RECHERCHER
        rechercher.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            
              fenetre_choix_patient(); 
          }
        });
        
        //Admin
        admin.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            if(mdp()) fenetre_admin(); // On accede a la partie admin, le mdp est bon
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
        ajouter.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            System.out.println("Données statistiques...");
          }
        });
        
        // On affiche le reste
        this.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        this.add(pAdmin, BorderLayout.LINE_END); // POUR ALIGNER À DROITE
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p5);
        this.add(p6);
        this.add(p7);
        this.setSize(600,600);
        
        this.setVisible(true);  
    }

    
    public void fenetre_rechercher_patient()
    {
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

            // utilisée pour l'option 1) quand on ne veut voir que les patients actuellement à l'hopital
            String requete_malade;
            // va etre utilisée pour l'option 2) quand on veut voir tous les patients, meme ceux qui sont uniquement dans les archives
            String requete_hopsitalisation;

            ArrayList<String> liste =null;

            // RECHERCHE D UN PATIENT HOSPITALISE MAINTENANT
            // écriture de la requete exacte en fonction de la maniere dont a été rempli le formulaire
            requete_malade = maconnexion.CrerRequete_Recherche_Hospitalisation(id_recu, nom_recu, prenom_recu, no_chambre_recu, no_lit_recu, adresse_recu, tel_recu, mutuelle_recu, date_arrivee_recu);
            try 
            {
                // on envoit la requete à la base de données via RemplirChampsRequete qui est dans la classe Connexion
                liste = maconnexion.RemplirChampsRequete(requete_malade);
            
                int taille = liste.size();
                // On affiche le résultat de la requete
                for (int i = 0; i < liste.size(); i++)
                {
                    // Connnexion renvoit un tableau de String, avec dans chaque string tous les attirbuts désirés par la requete séparés par des virgules
                    String value = liste.get(i);
                    System.out.println("" + value);
                }
                
                // si la recherche n'aboutit à aucun malade, on affiche un message d'erreur
                if (taille ==0)
                {
                    JOptionPane.showMessageDialog(null, "Aucun patient ne correspond à votre recherche. Regardez dans les archives.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            catch (SQLException ex)
            {
                System.out.println("Echec SQL");
                ex.printStackTrace();
            }
            
            fenetre_reponse_patient(liste);
                       
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
        this.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
        this.add(p7);
        this.add(p8);
        this.add(p9);
        this.add(p10);
        this.add(p11);
        
        this.setSize(600,600);
        
        this.setVisible(true); 
        
    }
    
    public void fenetre_choix_patient()
    {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Le patient est-il actuellement dans l'hôpital ?", "Title on Box", dialogButton);
        // Oui le patient est toujours dans l'hopital : recherche dans la table hospitalisation
        if(dialogResult == 0) {
          fenetre_rechercher_patient(); 
        } 
        // non le patient n'est plus dnas l'hopital : recherche dans les archives (table historique)
        else {
            fenetre_rechercher_archives();
        }
    }
    
    public void fenetre_rechercher_archives()
    {

        
        JTextField jtf_no_id, jtf_nom, jtf_prenom, jtf_nom_service, jtf_nom_docteur, jtf_datea, jtf_dated, jtf_adresse, jtf_tel, jtf_mutuelle;
        JLabel jl_no_id, jl_nom, jl_prenom, jl_nom_service, jl_nom_docteur, jl_datea, jl_dated, jl_adresse, jl_tel, jl_mutuelle, texte;
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");
        JPanel p1, p2, p3, p4, p5, p6, p7, p7b, p8, p9, p10, p11;
        
        
        // On initialise les JLabel
        texte = new JLabel("Veuillez remplir les informations connues sur le patient");
        jl_no_id = new JLabel("N° identification");
        jl_nom = new JLabel("Nom");
        jl_prenom = new JLabel("Prénom");
        jl_nom_service = new JLabel("Nom service");
        jl_nom_docteur = new JLabel("Nom du docteur");
        jl_datea = new JLabel("Date d'arrivée");
        jl_dated = new JLabel("Date de sortie");
        jl_adresse = new JLabel("Adresse");
        jl_tel = new JLabel("N° telephone");
        jl_mutuelle = new JLabel("Mutuelle");
        
        // On iitialise les JTF
        jtf_no_id = new JTextField();
        jtf_nom = new JTextField();
        jtf_prenom = new JTextField();
        jtf_nom_service = new JTextField();
        jtf_nom_docteur = new JTextField();
        jtf_datea = new JTextField();
        jtf_dated = new JTextField();
        jtf_adresse = new JTextField();
        jtf_tel = new JTextField();
        jtf_mutuelle = new JTextField();
        
        jtf_no_id.setColumns(10);
        jtf_nom.setColumns(10);
        jtf_prenom.setColumns(10);
        jtf_nom_service.setColumns(10);
        jtf_nom_docteur.setColumns(10);
        jtf_datea.setColumns(10);
        jtf_dated.setColumns(10);
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
        p5.add(jl_nom_service);
        p5.add(jtf_nom_service);
        p5.setOpaque(false);
        p5.setPreferredSize(new Dimension(600, 30));
        
        p6 = new JPanel();
        p6.add(jl_nom_docteur);
        p6.add(jtf_nom_docteur);
        p6.setOpaque(false);
        p6.setPreferredSize(new Dimension(600, 30));
        
        p7 = new JPanel();
        p7.add(jl_datea);
        p7.add(jtf_datea);
        p7.setOpaque(false);
        p7.setPreferredSize(new Dimension(600, 30));
        
        p7b = new JPanel();
        p7b.add(jl_dated);
        p7b.add(jtf_dated);
        p7b.setOpaque(false);
        p7b.setPreferredSize(new Dimension(600, 30));
        
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
              
            int id_recu;  
            String nom_recu;
            String prenom_recu;
            String adresse_recu;
            String tel_recu;
            String date_arrivee_recu;
            String date_sortie_recu;
            String nom_docteur_recu;
            String code_service_recu;
            String mutuelle_recu;
            
           
            
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
            // code service
            if(jtf_nom_service.getText().equals(""))
                code_service_recu = "%";
            else code_service_recu= jtf_nom_service.getText();           
            // nom du docteur
            if(jtf_nom_docteur.getText().equals(""))
                nom_docteur_recu = "%";
            else nom_docteur_recu = jtf_nom_docteur.getText();
            // date d'arrivée
            if(jtf_datea.getText().equals(""))
                date_arrivee_recu = "%";
            else date_arrivee_recu= jtf_datea.getText();
            // date de sortie
            if(jtf_dated.getText().equals(""))
                date_sortie_recu = "%";
            else date_sortie_recu= jtf_dated.getText();
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
            
            // RECHERCHE D UN PATIENT DANS LES ARCHIVES
            
            // va etre utilisée pour l'option 2) quand on veut voir tous les patients, meme ceux qui sont uniquement dans les archives
            String requete_archives;
            ArrayList<String> liste;

                        
            // écriture de la requete exacte en fonction de la maniere dont a été rempli le formulaire
            requete_archives = maconnexion.CrerRequete_Recherche_Historique(id_recu, nom_recu, prenom_recu, adresse_recu, 
                    tel_recu, mutuelle_recu, date_arrivee_recu, date_sortie_recu, nom_docteur_recu, code_service_recu);
            try 
            {
                // on envoit la requete à la base de données via RemplirChampsRequete qui est dans la classe Connexion
                liste = maconnexion.RemplirChampsRequete(requete_archives);
            
                int taille = liste.size();
                // On affiche le résultat de la requete
                for (int i = 0; i < liste.size(); i++)
                {
                    // Connnexion renvoit un tableau de String, avec dans chaque string tous les attributs désirés par la requete, séparés par des virgules
                    String value = liste.get(i);
                    System.out.println("" + value);
                }
                
                // si la recherche n'aboutit à aucun malade, on affiche un message d'erreur
                if (taille ==0)
                {
                    JOptionPane.showMessageDialog(null, "Aucun patient ne correspond à votre recherche.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            }
            catch (SQLException ex)
            {
                System.out.println("Echec SQL");
                ex.printStackTrace();
            }
              
              */
            
           // fenetre_reponse_patient(liste);
                       
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
        this.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
        this.add(p7);
        this.add(p7b);
        this.add(p8);
        this.add(p9);
        this.add(p10);
        this.add(p11);
        
        this.setSize(600,600);
        
        this.setVisible(true); 
        
    }
    
    public void fenetre_ajouter_patient()
    {
        JTextField jtf_no_id, jtf_nom, jtf_prenom, jtf_no_chambre, jtf_no_lit, jtf_adresse, jtf_tel, jtf_mutuelle;
        JLabel jl_no_id, jl_nom, jl_prenom, jl_no_chambre, jl_no_lit, jl_adresse, jl_tel, jl_mutuelle, texte;
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");
        JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;
        
        
        // On initialise les JLabel
        texte = new JLabel("Merci de remplir toutes les informations suivantes");
        jl_no_id = new JLabel("N° identification");
        jl_nom = new JLabel("Nom");
        jl_prenom = new JLabel("Prénom");
        jl_no_chambre = new JLabel("N° chambre");
        jl_no_lit = new JLabel("N° lit");
        jl_adresse = new JLabel("Adresse");
        jl_tel = new JLabel("N° telephone");
        jl_mutuelle = new JLabel("Mutuelle");
        
        // On iitialise les JTF
        jtf_no_id = new JTextField();
        jtf_nom = new JTextField();
        jtf_prenom = new JTextField();
        jtf_no_chambre = new JTextField();
        jtf_no_lit = new JTextField();
        jtf_adresse = new JTextField();
        jtf_tel = new JTextField();
        jtf_mutuelle = new JTextField();
        
        jtf_no_id.setColumns(10);
        jtf_nom.setColumns(10);
        jtf_prenom.setColumns(10);
        jtf_no_chambre.setColumns(10);
        jtf_no_lit.setColumns(10);
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
            if(jtf_nom.getText().equals("") || jtf_prenom.getText().equals("") || jtf_no_chambre.getText().equals("") || jtf_no_lit.getText().equals("") || jtf_adresse.getText().equals("") || jtf_tel.getText().equals("") || jtf_mutuelle.getText().equals("")) 
            {
                JOptionPane.showMessageDialog(null, "Il y a au moins un champs vide", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                System.out.println("Validé avec toutes les infos");
                // C'est ici qu'il faut récupérer les informations et ajouter un patient dans la BDD
                // Attention, il faut que le numero id du patient soit implémenté tout seul ainsi que la date d'arrivée
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
        this.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        this.add(p1);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
        this.add(p8);
        this.add(p9);
        this.add(p10);
        this.add(p11);
        
        this.setSize(600,600);
        
        this.setVisible(true); 
    }
    
    public boolean mdp()
    {
        JPanel p = new JPanel();
        JLabel l = new JLabel("Entrer le mot de passe pour acceder à la partie admin :");
        JPasswordField mdp = new JPasswordField(10);
        String mdp_tape = "";
                 
        p.add(l);
        p.add(mdp);
        String[] options = new String[]{"OK", "Cancel"};
        int option = JOptionPane.showOptionDialog(null, p, "The title",
                                 JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                 null, options, options[1]);
        if(option == 0) // pressing OK button
        {
            mdp_tape  = mdp.getText();
        }
        if(mdp_tape.equals("hopital")) return true;
        else return false;
    }
    
    public void fenetre_admin()
    {
        JButton employe, ajouter, service, chambre, retour;
        JPanel p1, p2, p3, p4, p5, p6;
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
                
          }
        });
        
        // recherche un employé
        employe.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            
                
          }
        });
        
        //recherche chambre
        chambre.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            
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
            fenetre_accueil();
          }
        });
        
        // On affiche le reste
        this.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
        this.setSize(600,600);
        
        this.setVisible(true);
    }
    
    public void fenetre_reponse_patient(ArrayList tab)
    {
        /*
        pour les patients encore à l'hopital 

SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.no_chambre, h.no_lit, h.date_arrivee "
                                  + "FROM malade m, hospitalisation h WHERE …..
        */

        
        JComboBox combo = new JComboBox();
        JButton voir = new JButton("Voir");
        JButton valider = new JButton("Valider");
        JPanel pbouton, ptexte, phaut, p2, p3, p4, p5, p6, p7, p8, p9, p10;
        JTextField jtf_no_id, jtf_nom, jtf_prenom, jtf_no_chambre, jtf_no_lit, jtf_datea, jtf_adresse, jtf_tel, jtf_mutuelle;
        JLabel jl_no_id, jl_nom, jl_prenom, jl_no_chambre, jl_no_lit, jl_datea, jl_adresse, jl_tel, jl_mutuelle, texte;
        
        // On initialise les JLabel
        texte = new JLabel("Veuillez selectionner le patient");
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
        jtf_adresse.setColumns(10);
        jtf_tel.setColumns(10);
        jtf_mutuelle.setColumns(10);
        
        // On initialise les objets
        valider.setPreferredSize(new Dimension(400,30));
        valider.setOpaque(false);
        voir.setPreferredSize(new Dimension(200,30));
        voir.setOpaque(false);
        combo.setPreferredSize(new Dimension(200,30));
        combo.setOpaque(false);
        
        // On initialise la liste avec les résultats correspondants à la recerhcer
        for(int i=0; i<tab.size(); i++)
        {
            combo.addItem(tab.get(i));   
        }
        
        // On crée les panels
        ptexte = new JPanel();
        ptexte.add(texte);
        ptexte.setOpaque(false);
        ptexte.setPreferredSize(new Dimension(600, 30));
        
        phaut = new JPanel();
        phaut.add(combo);
        phaut.add(voir);
        phaut.setOpaque(false);
        phaut.setPreferredSize(new Dimension(600, 30));
        
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
        
        pbouton = new JPanel();
        pbouton.add(valider);
        pbouton.setOpaque(false);
        pbouton.setPreferredSize(new Dimension(600, 30));
        
        
        // On gère les boutons
        voir.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
           // fenetre_accueil();
          }
        });
        
        valider.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
            //fenetre_rechercher_patient();
          }
        });
        
        this.add(ptexte);
        this.add(phaut);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
        this.add(p7);
        this.add(p8);
        this.add(p9);
        this.add(p10);
        this.add(pbouton);
    }
    
    public void fenetre_reponse_archives(ArrayList tab)
    {
        
        /*
        pour les archives : SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.date_arrivee, h.date_sortie, d.no_docteur, h.description, "
                       + "h.code_service "
                       + "FROM malade m, historique h, docteur d
        */
        
    }
    
    public void fenetre_afficher_patient(ArrayList tab, int no)
    {
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
        this.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        this.add(p1);
        this.add(p2);
        this.add(p3);
        this.add(p4);
        this.add(p5);
        this.add(p6);
        this.add(p7);
        this.add(p8);
        this.add(p9);
        this.add(p10);
        this.add(p11);
        
        this.setSize(600,600);
        
        this.setVisible(true);
        */
    }
    
    
}

