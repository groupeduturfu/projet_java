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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import projet.Connexion;

/**
 *
 * @author meyronneaudrey
 */
public class Ajouter_malade {

    private static Ajouter_malade fenetre = null;
    private static JPanel p1, p2, p3, p4, p5, p6, p8, p9, p10, p11, p12, p12bis, p13, p14, p15;

    // recupere les numéros de chambre du service sélectionné 
    private ArrayList<String> liste_chambres = new ArrayList<String>();

// recupere les numéros de lits de la chambre sélectionnée
    //private ArrayList<String> liste_lits = new ArrayList<String>();
    private Ajouter_malade(JFrame f) {
        JTextField jtf_nom, jtf_prenom, jtf_no_chambre, jtf_no_lit, jtf_adresse, jtf_tel, jtf_mutuelle, jtf_docteur, jtf_docteur_prenom, jtf_date_naissance;
        JLabel jl_no_id, jl_nom, jl_prenom, jl_no_chambre, jl_no_lit, jl_adresse, jl_tel, jl_mutuelle, jl_docteur, jl_docteur_prenom, jl_code_service, jl_description, jl_date_naissance, texte;
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");

        // description de l'intervention
        JTextArea jtf_description;
        JScrollPane jsp;

        // Liste deroulante si infirmier pour le service des infirmiers
        JComboBox Jcombo_service;
        String[] service_string = {"ORL", "REA", "CHG"};
        Jcombo_service = new JComboBox(service_string);

        // Liste deroulante pour le choix de la chambre et du lit : initialisées vides car seront remplies par requetes
        //JComboBox Jcombo_chambres;
        //String[] chambres_dispos_string = {""};
        //Jcombo_chambres = new JComboBox(chambres_dispos_string);
        //JComboBox Jcombo_lits;
        //String[] lits_dispos_string = {""};
        //Jcombo_lits = new JComboBox(lits_dispos_string);
        // On initialise les JLabel
        texte = new JLabel("Merci de remplir toutes les informations suivantes");
        //jl_no_id = new JLabel("N° identification");
        jl_nom = new JLabel("Nom");
        jl_prenom = new JLabel("Prénom");
        jl_no_chambre = new JLabel("N° chambre");
        jl_no_lit = new JLabel("N° lit");
        jl_adresse = new JLabel("Adresse");
        jl_tel = new JLabel("N° telephone");
        jl_mutuelle = new JLabel("Mutuelle");
        jl_docteur = new JLabel("Nom du docteur");
        jl_docteur_prenom = new JLabel("Prenom du docteur");
        jl_code_service = new JLabel("Code Service");
        jl_description = new JLabel("Description");
        jl_date_naissance = new JLabel("Date de naissance");
        

        // On iitialise les JTF
        jtf_nom = new JTextField();
        jtf_prenom = new JTextField();
        jtf_no_chambre = new JTextField();
        jtf_no_lit = new JTextField();
        jtf_adresse = new JTextField();
        jtf_tel = new JTextField();
        jtf_mutuelle = new JTextField();
        jtf_docteur = new JTextField();
        jtf_docteur_prenom = new JTextField();
        jtf_date_naissance = new JTextField();

        jtf_description = new JTextArea();
        jtf_description.setLineWrap(true);
        jsp = new JScrollPane(jtf_description);


        jsp = new JScrollPane(jtf_description);

        jtf_nom.setColumns(15);
        jtf_prenom.setColumns(15);
        jtf_no_chambre.setColumns(15);
        jtf_no_lit.setColumns(15);
        jtf_adresse.setColumns(15);
        jtf_tel.setColumns(15);
        jtf_mutuelle.setColumns(15);
        jtf_docteur.setColumns(15);
        jtf_docteur_prenom.setColumns(15);
        jtf_description.setColumns(25);
        jtf_description.setPreferredSize(new Dimension(50, 100));

        jtf_date_naissance.setColumns(15);

        // On change le bouton de forme
        valider.setPreferredSize(new Dimension(200, 30));
        valider.setOpaque(false);
        retour.setPreferredSize(new Dimension(200, 30));
        retour.setOpaque(false);

        // On initialise les JPanel
        p1 = new JPanel();
        p1.add(texte);
        p1.setOpaque(false);
        p1.setPreferredSize(new Dimension(600, 30));

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

        p12 = new JPanel();
        p12.add(jl_docteur_prenom);
        p12.add(jtf_docteur_prenom);
        p12.setOpaque(false);
        p12.setPreferredSize(new Dimension(600, 30));

        p12bis = new JPanel();
        p12bis.add(jl_docteur);
        p12bis.add(jtf_docteur);
        p12bis.setOpaque(false);
        p12bis.setPreferredSize(new Dimension(600, 30));
        
        p13 = new JPanel();
        p13.add(jl_description);
        p13.add(jsp);
        p13.setOpaque(false);
        p13.setPreferredSize(new Dimension(600, 100));

        p14 = new JPanel();
        p14.add(jl_date_naissance);
        p14.add(jtf_date_naissance);
        p14.setOpaque(false);
        p14.setPreferredSize(new Dimension(600, 30));

        // liste déroulante des code service
        p15 = new JPanel();
        p15.add(jl_code_service);
        p15.add(Jcombo_service);
        p15.setOpaque(false);
        p15.setPreferredSize(new Dimension(600, 30));

        // On gère l'évennement du bouton
        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // C'est ici qu'il faut récupérer les informations et ajouter un patient dans la BDD
                // Attention, il faut que le numero id du patient soit implémenté tout seul ainsi que la date d'arrivée

                int id_recu;
                String nom_recu;
                String prenom_recu;
                int no_chambre_recu = 1;
                int no_lit_recu = 1;
                String lit_string;
                String adresse_recu;
                String tel_recu;
                String mutuelle_recu;
                String nom_docteur_recu;
                String prenom_docteur_recu;
                String date_naissance_recu;
                String no_chambre;
                String no_lit;
                String code_service_recu = "ORL";

                // chaines de caractère dans laquelle on écrit la requete correspondant aux infos du formulaire rempli 
                String requete_malade;
                String requete_hopsitalisation;
                String requete_id_recup;
                String requete_docteur;
                String requete_verif_lit_chambre;

                // vont récupérer le numéro du malade et le numéro du docteur
                String id_string_malade_recup;
                String id_string_docteur_recup;
                String check_chambre;
                int id_malade_recup = 100;
                int id_docteur_recup = 100;

                ArrayList<String> liste;

                if (jtf_nom.getText().equals("") || jtf_prenom.getText().equals("") || jtf_no_chambre.getText().equals("") || jtf_no_lit.getText().equals("") || jtf_adresse.getText().equals("") || jtf_tel.getText().equals("") || jtf_mutuelle.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Il y a au moins un champs vide", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                    // RECUPERATION DES VALEURS DES TEXTFIELDS
                    nom_recu = jtf_nom.getText();
                    prenom_recu = jtf_prenom.getText();
                    adresse_recu = jtf_adresse.getText();
                    tel_recu = jtf_tel.getText();
                    mutuelle_recu = jtf_mutuelle.getText();
                    nom_docteur_recu = jtf_docteur.getText();
                    prenom_docteur_recu = jtf_docteur_prenom.getText();
                    date_naissance_recu = jtf_date_naissance.getText();
                    String chambre_string = jtf_no_chambre.getText().trim();
                    String description = jtf_description.getText();

                    // vérifie si la chambre donnée existe dans le service
                    int chambre_cohérent;

                    // enregistre le code service recu
                    code_service_recu = Jcombo_service.getSelectedItem().toString();

                    // récupération du numéro de chambre
                    // on regarde si le numéro de la chambre existe
                    try {
                        no_chambre_recu = Integer.parseInt(chambre_string.trim());
                        chambre_cohérent = malade_cohérence_chambre(Jcombo_service, no_chambre_recu);
                        if (chambre_cohérent == 1) {
                            // récupération du numéro de lit
                            try {
                                no_lit_recu = Integer.parseInt(jtf_no_lit.getText().trim());

                                // avant d'enregistrer le malade on vérifie que le nom du docteur existe
                                // on récupère le numéro de docteur correspondant au nom inscrit dans le formulaire 
                                requete_docteur = Connexion.getInstance().CreerRequete_recup_id_docteur(nom_docteur_recu, prenom_docteur_recu);
                                try {
                                    // on recupere le numero du medecin qui soigne le patient
                                    id_string_docteur_recup = Connexion.getInstance().RecupererId(requete_docteur);
                                    // si le nom du docteur mentionné n'exite pas dans la base
                                    if ("NotExist".equals(id_string_docteur_recup)) {
                                        JOptionPane.showMessageDialog(null, "Le docteur recherché n'existe pas.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                    } // sinon on vérifie la date de naissance 
                                    else {

                                        // RecupererId renvoie une chaine de caractere, on le transforme en int
                                        id_docteur_recup = Integer.parseInt(id_string_docteur_recup.trim());

                                        // si la date envoyee est au bon format
                                        if (date_naissance_recu.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")) {

                                            // Récupération du format du téléphone
                                            if (tel_recu.matches("([0-9]{2}) ([0-9]{2}) ([0-9]{2}) ([0-9]{2}) ([0-9]{2})")) {

                                                // on regarde si le lit situé dans cette chambre est déjà pris
                                                requete_verif_lit_chambre = Connexion.getInstance().CreerRequete_Check_lit_chambre(no_chambre_recu, no_lit_recu);
                                                try {
                                                    check_chambre = Connexion.getInstance().RecupererId(requete_verif_lit_chambre);
                                                    // si la requete renvoie not exist alors le lit est libre, on enregistre le patient
                                                    if (check_chambre == "NotExist") {

                                                        // écriture de la requete : écrire infos dans la table MALADE
                                                        requete_malade = Connexion.getInstance().CreerRequete_malade(nom_recu, prenom_recu, adresse_recu, tel_recu, mutuelle_recu, date_naissance_recu);
                                                        try {
                                                            // on enregistre les infos dans la table malade
                                                            Connexion.getInstance().executeUpdate(requete_malade);

                                                            // écriture de la requete : récupération du numéro malade attribué au patient
                                                            requete_id_recup = Connexion.getInstance().CreerRequete_recup_id(1, nom_recu, prenom_recu, tel_recu);
                                                            try {
                                                                // on recupere le numero du malade qui vient d'etre inscrit
                                                                id_string_malade_recup = Connexion.getInstance().RecupererId(requete_id_recup);

                                                                // RecupererId renvoie une chaine de caractere, on le transforme en int
                                                                id_malade_recup = Integer.parseInt(id_string_malade_recup.trim());
                                                                System.out.println("id malade recupéré : " + id_malade_recup);

                                                                // on crée un nouveau tuple dans la table hospitalisation avec comme no_malade celui créé à l'instant
                                                                requete_hopsitalisation = Connexion.getInstance().CreerRequete_hospitalisation(id_malade_recup, no_chambre_recu, no_lit_recu, id_docteur_recup, code_service_recu, description);
                                                                try {
                                                                    // on enregistre les infos dans la table hospitalisation
                                                                    Connexion.getInstance().executeUpdate(requete_hopsitalisation);
                                                                    // on affiche à l'utilisateur que le nouveau patient a bien été inscrit
                                                                    JOptionPane.showMessageDialog(null, "Le patient a été enregistré.", "Info", JOptionPane.ERROR_MESSAGE);
                                                                    Accueil.getFenetre(f);

                                                                } catch (SQLException ex) {
                                                                    System.out.println("Echec SQL");
                                                                    ex.printStackTrace();
                                                                }

                                                            } catch (SQLException ex) {
                                                                System.out.println("Echec SQL");
                                                                ex.printStackTrace();
                                                            }

                                                        } catch (SQLException ex) {
                                                            System.out.println("Echec SQL");
                                                            ex.printStackTrace();
                                                        }

                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Le lit de cette chambre est déjà pris", "Erreur", JOptionPane.ERROR_MESSAGE);
                                                    }

                                                } catch (SQLException ex) {
                                                    System.out.println("Echec SQL");
                                                    ex.printStackTrace();
                                                }

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Le téléphone n'est pas au format '-- -- -- -- --'.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                            }

                                        } else {
                                            JOptionPane.showMessageDialog(null, "La date de naissance n'est pas au format aaaa-mm-jj.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                        }

                                    }

                                } catch (SQLException ex) {
                                    System.out.println("Echec SQL");
                                    ex.printStackTrace();
                                }

                            } catch (NumberFormatException nfe) {
                                JOptionPane.showMessageDialog(null, "Le numéro de lit n'est pas correct.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Aucune chambre de ce numéro n'appartient à ce service.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }

                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Le numéro de chambre n'est pas correct.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        );

        retour.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // on vide les combo box
                //Jcombo_chambres.removeAllItems();
                //Jcombo_lits.removeAllItems();
                Accueil.getFenetre(f);
            }
        });

        /*
         Jcombo_service.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent e) {
         if (e.getStateChange() == 1) {

         // on enregistre la valeur du service sélectionné
         String service = Jcombo_service.getSelectedItem().toString();

         // on vide les listes déroulantes des lits et chambres
         Jcombo_chambres.removeAllItems();
         Jcombo_lits.removeAllItems();
                    
         liste_chambres.clear();
                                        
                    
         // la liste des chambres se remplit des numéros de chambre appartenant à ce service
         liste_chambres = Connexion.getInstance().Requete_chambre_dans_service(service);

                    
                    
         System.out.println("nb chambres dispos :" + liste_chambres.size());
         for (int i = 0; i < liste_chambres.size(); i++) {
         System.out.println(""+ liste_chambres.get(i));
         Jcombo_chambres.addItem(liste_chambres.get(i));
         }
                    
                    
         // si toutes les chambres du service ont déjà un surveillant pour la rotation sélectionnée, on affiche un message 
         if (liste_chambres.size() == 0) {
         JOptionPane.showMessageDialog(null, "Le service est plein, il n'y a plus de lits disponibles.", "Erreur", JOptionPane.ERROR_MESSAGE);
         }
         }
         }
         });

         //Jcombo_chambres.addMouseListener(new MouseAdapter(){

         //public void actionPerformed(ActionEvent e) {
            
         Component[] comps = Jcombo_chambres.getComponents();
         for(int i = 0; i < comps.length; i++)
         { 
         comps[i].addMouseListener(new MouseAdapter() {

         public void mouseClicked(MouseEvent me) {
            
         System.out.println("check chambres ");
         //Jcombo_chambres.removeAllItems();
         //for (int i = 0; i < liste_chambres.size(); i++) {
         //        Jcombo_chambres.addItem(liste_chambres.get(i));
         //    }

         // on enregistre la valeur de la chambre sélectionnée
         String chambre_string = Jcombo_chambres.getSelectedItem().toString();
         int chambre = Integer.parseInt(chambre_string.trim());

         // on enregistre la valeur du code service sélectionné
         String service = Jcombo_service.getSelectedItem().toString();

         // recuperera les numéros de lits déjà pris de cette chambre
         ArrayList<String> liste_lits_occupes = new ArrayList<String>();

         // recuperera les numéros de lits disponibles de cette chambre
         ArrayList<String> liste_lits_dispos = new ArrayList<String>();

         // nombre total de lits (occupés et libres) dans la chambre sélectionnée
         String nb_lit_string = "0";
         try {
         nb_lit_string = Connexion.getInstance().RecupererId("SELECT nb_lits FROM chambre WHERE no_chambre=" + chambre +
         " AND code_service LIKE '" + service + "';");

         int nb_lit_int = Integer.parseInt(nb_lit_string.trim());

         int ajout = 1;

         System.out.println("int nb lits : " + nb_lit_int);

         // on vide la liste déroulante des lits
         Jcombo_lits.removeAllItems();
                    
                    

         // la liste se remplit des numéros de lits déjà occupés de cette chambre
         liste_lits_occupes = Connexion.getInstance().Requete_lits_dans_chambre(chambre, service);
         System.out.println("nb libres occupés" + liste_lits_occupes.size());
                    
         for (int k = 0; k < liste_lits_occupes.size(); k++) 
         {
         System.out.println("k : " + liste_lits_occupes.get(k));
         }

                   
         // pour chaque numéro de lit existant dans la chambre sélectionnée
         for (int i = 1; i <= nb_lit_int; i++) {
         ajout = 1; // par défaut on considère que le lit est libre et qu'on le notera dans la liste des lits dispos
         // on regarde s'il est dans la liste des lits occupés
         for (int j = 0; j < liste_lits_occupes.size(); j++) {
         // s'il y est, on ne l'ajoutera pas dans la liste des lits disponibles
         if (liste_lits_occupes.get(j) == Integer.toString(i));
         ajout = 0;
         }
         // ajout est resté à 1 si on n'a pas trouvé ce numéro de lit dans les lits occupés
         if (ajout == 1) {
         // on l'ajoute alors à la liste des lits disponibles
         liste_lits_dispos.add(Integer.toString(i));
         Jcombo_lits.addItem(i);
         }
         }
         // si toutes les chambres du service ont déjà un surveillant pour la rotation sélectionnée, on affiche un message 
         if (liste_lits_dispos.size() == 0) {
         JOptionPane.showMessageDialog(null, "Il n'y a plus de lits disponibles dans la chambre " + chambre, "Erreur", JOptionPane.ERROR_MESSAGE);
         }

         } catch (SQLException ex) {
         System.out.println("Echec SQL");
         ex.printStackTrace();
         }

         }

         });
         }
            
            

         }*/
    }

    public static Ajouter_malade getFenetre(JFrame f) {

        if (fenetre == null) {
            fenetre = new Ajouter_malade(f);
        }

        // On ajoute tous les JPannel à la fenêtre
        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background qui recouvre la fenetre d'avant
        f.add(p1);
        f.add(p3);
        f.add(p4);
        f.add(p14);
        f.add(p15);
        f.add(p5);
        f.add(p6);
        f.add(p8);
        f.add(p9);
        f.add(p10);
        f.add(p12);
        f.add(p12bis);
        f.add(p13);
        //f.add(p5);

        f.add(p11);

        f.setSize(600, 600);

        f.setVisible(true);

        return fenetre;
    }

    public int malade_cohérence_chambre(JComboBox Jcombo_service, int chambre) {
        int coherent = 0;
        // on enregistre la valeur du service sélectionné
        String service = Jcombo_service.getSelectedItem().toString();

        liste_chambres.clear();

        // la liste des chambres se remplit des numéros de chambre appartenant à ce service
        liste_chambres = Connexion.getInstance().Requete_chambre_dans_service(service);

        System.out.println("nb chambres dispos :" + liste_chambres.size());
        for (int i = 0; i < liste_chambres.size(); i++) {
            System.out.println("saisie : " + chambre);
            System.out.println("check : " + liste_chambres.get(i));
            if (chambre == Integer.parseInt(liste_chambres.get(i).trim())) {
                coherent = 1; // si la chambre saisie appartient aux chambres du service
            }
            System.out.println("coherent " + coherent);
        }

        return coherent;
    }

}
