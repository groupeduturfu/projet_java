/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
public class Ajouter_employe {

    private static Ajouter_employe fenetre = null;
    private static JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20;

    private Ajouter_employe(JFrame f) {

        JTextField jtf_nom, jtf_prenom, jtf_adresse, jtf_tel, jtf_salaire, jtf_fonction, jtf_date_naissance;
        JLabel texte, jl_nom, jl_prenom, jl_adresse, jl_tel, jl_salaire, jl_fonction, jl_specialite, jl_rotation, jl_code_service, jl_date_naissance, jl_services;
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");

        // checkboxes des services si docteur
        JCheckBox jch_ORL = new JCheckBox("ORL");
        JCheckBox jch_REA = new JCheckBox("REA");
        JCheckBox jch_CHG = new JCheckBox("CHG");
        JCheckBox jch_dorl = new JCheckBox("Directeur");
        JCheckBox jch_drea = new JCheckBox("Directeur");
        JCheckBox jch_dchg = new JCheckBox("Directeur");
        jch_ORL.setSelected(false);
        jch_REA.setSelected(false);
        jch_CHG.setSelected(false);
        jch_dorl.setSelected(false);
        jch_drea.setSelected(false);
        jch_dchg.setSelected(false);

        // checkbox si infirmier = surveillant
        JCheckBox jch_surveillant = new JCheckBox("Surveillant de la chambre : ");
        jch_surveillant.setSelected(false);

        // liste déroulante pour les chambres disponibles à la surveillance
        JComboBox Jcombo_chambres;
        String[] chambres_string = {""};
        Jcombo_chambres = new JComboBox(chambres_string);

        // liste déroulante pour Infirmier / Docteur
        JComboBox Jcombo_fonction;
        String[] fonction_string = {"Docteur", "Infirmier"};
        Jcombo_fonction = new JComboBox(fonction_string);
        Jcombo_fonction.setSelectedIndex(0);

        // Liste deroulante si docteur pour la specialite
        JComboBox Jcombo_specialite;
        String[] specialite_string = {"Anesthesiste", "Cardiologue", "Generaliste", "Orthopediste", "Pneumologue", "Radiologue", "Traumatologue"};
        Jcombo_specialite = new JComboBox(specialite_string);

        // Liste deroulante si infirmier pour la rotation
        JComboBox Jcombo_rotation;
        String[] rotation_string = {"JOUR", "NUIT"};
        Jcombo_rotation = new JComboBox(rotation_string);

        // Liste deroulante si infirmier pour le service des infirmiers
        JComboBox Jcombo_service;
        String[] service_string = {"ORL", "REA", "CHG"};
        Jcombo_service = new JComboBox(service_string);

        // On initialise les JLabel
        texte = new JLabel("Merci de remplir toutes les informations suivantes");
        jl_nom = new JLabel("Nom");
        jl_prenom = new JLabel("Prénom");
        jl_adresse = new JLabel("Adresse");
        jl_tel = new JLabel("N° telephone '-- -- -- -- --'");
        jl_salaire = new JLabel("Salaire");
        jl_fonction = new JLabel("Fonction");
        jl_specialite = new JLabel("Specialite");
        jl_rotation = new JLabel("Rotation");
        jl_code_service = new JLabel("Code service");
        jl_date_naissance = new JLabel("Date de naissance 'aaaa-mm-jj'");

        // On iitialise les JTF
        //jtf_no_id = new JTextField();
        jtf_nom = new JTextField();
        jtf_prenom = new JTextField();
        jtf_adresse = new JTextField();
        jtf_tel = new JTextField();
        jtf_salaire = new JTextField();
        jtf_fonction = new JTextField();
        jtf_date_naissance = new JTextField();

        //jtf_no_id.setColumns(10);
        jtf_nom.setColumns(10);
        jtf_prenom.setColumns(10);
        jtf_adresse.setColumns(10);
        jtf_tel.setColumns(10);
        jtf_salaire.setColumns(10);
        jtf_fonction.setColumns(10);
        jtf_date_naissance.setColumns(10);

        // On change le bouton de forme
        valider.setPreferredSize(new Dimension(200, 30));
        valider.setOpaque(false);
        retour.setPreferredSize(new Dimension(200, 30));
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

        //liste déroulante Infirmier / Docteur
        p12 = new JPanel();
        p12.add(jl_fonction);
        p12.add(Jcombo_fonction);
        p12.setOpaque(false);
        p12.setPreferredSize(new Dimension(600, 30));

        //liste déroulante specialite docteur
        p13 = new JPanel();
        p13.add(jl_specialite);
        p13.add(Jcombo_specialite);
        p13.setOpaque(false);
        p13.setPreferredSize(new Dimension(600, 30));

        //liste déroulante rotation infirmier
        p14 = new JPanel();
        p14.add(jl_rotation);
        p14.add(Jcombo_rotation);
        p14.setOpaque(false);
        p14.setPreferredSize(new Dimension(600, 30));

        // textfield code service infirmier
        p15 = new JPanel();
        p15.add(jl_code_service);
        p15.add(Jcombo_service);
        p15.setOpaque(false);
        p15.setPreferredSize(new Dimension(600, 30));

        p16 = new JPanel();
        p16.add(jl_date_naissance);
        p16.add(jtf_date_naissance);
        p16.setOpaque(false);
        p16.setPreferredSize(new Dimension(600, 30));

        p17 = new JPanel();
        p17.add(jch_ORL);
        p17.add(jch_dorl);
        p17.setOpaque(false);
        p17.setPreferredSize(new Dimension(600, 30));

        p18 = new JPanel();
        p18.add(jch_REA);
        p18.add(jch_drea);
        p18.setOpaque(false);
        p18.setPreferredSize(new Dimension(600, 30));

        p19 = new JPanel();
        p19.add(jch_CHG);
        p19.add(jch_dchg);
        p19.setOpaque(false);
        p19.setPreferredSize(new Dimension(600, 30));

        p20 = new JPanel();
        p20.add(jch_surveillant);
        p20.add(Jcombo_chambres);
        p20.setOpaque(false);
        p20.setPreferredSize(new Dimension(600, 30));

        p11 = new JPanel();
        p11.add(retour);
        p11.add(valider);
        p11.setOpaque(false);
        p11.setPreferredSize(new Dimension(600, 30));

        // On gère l'évennement du bouton
        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String nom_recu;
                String prenom_recu;
                String adresse_recu;
                String tel_recu;
                int salaire_recu;
                String fonction_recu;
                String specialite_recu;
                String rotation_recu;
                String code_service_recu;
                String d_naissance_recu;
                String salaire;
                int chambre_recu;

                nom_recu = jtf_nom.getText();
                prenom_recu = jtf_prenom.getText();
                adresse_recu = jtf_adresse.getText();
                tel_recu = jtf_tel.getText();
                d_naissance_recu = jtf_date_naissance.getText();

                // enregistre la valeur de la liste deroulante infirmier/docteur
                fonction_recu = Jcombo_fonction.getSelectedItem().toString();

                if (jtf_nom.getText().equals("") || jtf_prenom.getText().equals("") || jtf_adresse.getText().equals("") || jtf_tel.getText().equals("") || jtf_salaire.getText().equals("") || jtf_date_naissance.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Il y a au moins un champs vide", "Erreur", JOptionPane.ERROR_MESSAGE);
                } else {
                // C'est ici qu'il faut récupérer les informations et ajouter un patient dans la BDD
                    // Attention, il faut que le numero id du patient soit implémenté tout seul ainsi que la date d'arrivée

                    // chaine de caractère dans laquelle on écrit la requete correspondant aux infos du formulaire rempli 
                    String requete_employe;
                    String requete_docteur;
                    String requete_infirmier;

                    // si docteur
                    String requete_appartient;
                    String requete_service;

                    // si infirmier
                    String requete_ch_dispos;
                    String requete_surveillant;

                    // requete pour récupérer le no_employe créé
                    String requete_id_recup;
                    String id_string_recup;
                    int id_recup = 100;
                    int cocher_directeurs = 1;

                    // no_infirmier
                    int surveillant;

                    try {
                        // BLINDAGE DE LA VALEUR DES CHAMPS 
                        // Récupération de la valeur du salaire
                        salaire_recu = Integer.parseInt(jtf_salaire.getText().trim());

                        // Récupération du format de la date de naissance
                        if (d_naissance_recu.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")) {
                            // Récupération du format du téléphone
                            if (tel_recu.matches("([0-9]{2}) ([0-9]{2}) ([0-9]{2}) ([0-9]{2}) ([0-9]{2})")) {

                                // On vérifie la cohérence des checkboxes, deux cas à distinguer, si on est sur infirmier ou docteur
                                // si c'est un docteur, on vérifie les checkboxes directeur / service
                                if (fonction_recu == "Docteur") {
                                    cocher_directeurs = docteurs_cohérence_chboxs(jch_ORL, jch_dorl, jch_REA, jch_drea, jch_CHG, jch_dchg);
                                    // s'il n'y a pas d'incohérence entre les services et directeurs cochés
                                    if (cocher_directeurs == 1) {
                                        // on enregistre le docteur en tant que directeur
                                        // TABLE EMPLOYE
                                        // Création de la requete pour remplir la table employé
                                        requete_employe = Connexion.getInstance().CreerRequete_employe(nom_recu, prenom_recu, adresse_recu, tel_recu, salaire_recu, fonction_recu, d_naissance_recu);
                                        try {
                                            // Envoi de la requete => remplissage de la table employé
                                            Connexion.getInstance().executeUpdate(requete_employe);

                                            // création de la requete recuperant le numero employe de l'employé enregistré à l'instant pour ensuite l'enregistrer dans les tables infirmier / docteur
                                            requete_id_recup = Connexion.getInstance().CreerRequete_recup_id(2, nom_recu, prenom_recu, tel_recu);

                                            // envoi de la requete qui récupère le numero de l'employe qui vient d'etre inscrit
                                            id_string_recup = Connexion.getInstance().RecupererId(requete_id_recup);
                                            try {
                                                // RecupererId renvoie une chaine de caractere, on le transforme en int
                                                id_recup = Integer.parseInt(id_string_recup.trim());
                                                System.out.println("id employe recupéré : " + id_recup);

                                                // ON REMPLIT LA TABLE DOCTEUR
                                                // enregistre la valeur de la liste specialite
                                                specialite_recu = Jcombo_specialite.getSelectedItem().toString();
                                                // on crée un nouveau tuple dans la table docteur avec comme no_docteur celui créé à l'instant
                                                requete_docteur = Connexion.getInstance().CreerRequete_docteur_infirmier(1, id_recup, specialite_recu, " ", " ");
                                                // on enregistre les infos dans la table DOCTEUR
                                                Connexion.getInstance().executeUpdate(requete_docteur);
                                                // on affiche à l'utilisateur que le nouveau docteur a bien été inscrit
                                                JOptionPane.showMessageDialog(null, "Le docteur a été enregistré.", "Info", JOptionPane.ERROR_MESSAGE);

                                                // ON REMPLIT LA TABLE APPARTIENT
                                                Connexion.getInstance().docteurs_requetes_appartient(jch_ORL, jch_REA, jch_CHG, id_recup);

                                                // ON REMPLIT LA TABLE DIRECTEUR
                                                Connexion.getInstance().docteurs_requetes_directeur(jch_dorl, jch_drea, jch_dchg, id_recup);

                                            } catch (SQLException ex) {
                                                System.out.println("Echec SQL");
                                                ex.printStackTrace();
                                            }
                                        } catch (SQLException ei) {
                                            if (ei instanceof MySQLIntegrityConstraintViolationException) {
                                                JOptionPane.showMessageDialog(null, "Cet employé est déjà enregistré.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                                System.out.println("Echec SQL");
                                                ei.printStackTrace();
                                            }

                                        }
                                    }// fin du if il n'y a pas d'incohérences dans les checkboxes docteurs
                                } // sinon s'il s'agit d'un infirmier
                                else if (fonction_recu == "Infirmier") {
                                    // on commence par vérifier la cohérence des informations avant d'enregistrer l'employé
                                    // enregistre la valeur de la liste rotation
                                    rotation_recu = Jcombo_rotation.getSelectedItem().toString();
                                    // enregistre le code service recu
                                    code_service_recu = Jcombo_service.getSelectedItem().toString();

                                    // on enregistre le employé en tant que infirmier
                                    // TABLE EMPLOYE
                                    // Création de la requete pour remplir la table employé
                                    requete_employe = Connexion.getInstance().CreerRequete_employe(nom_recu, prenom_recu, adresse_recu, tel_recu, salaire_recu, fonction_recu, d_naissance_recu);
                                    try {
                                        // Envoi de la requete => remplissage de la table employé
                                        Connexion.getInstance().executeUpdate(requete_employe);

                                        // création de la requete recuperant le numero employe de l'employé enregistré à l'instant pour ensuite l'enregistrer dans les tables infirmier / docteur
                                        requete_id_recup = Connexion.getInstance().CreerRequete_recup_id(2, nom_recu, prenom_recu, tel_recu);

                                        // envoi de la requete qui récupère le numero de l'employe qui vient d'etre inscrit
                                        id_string_recup = Connexion.getInstance().RecupererId(requete_id_recup);
                                        // RecupererId renvoie une chaine de caractere, on le transforme en int
                                        id_recup = Integer.parseInt(id_string_recup.trim());
                                        System.out.println("id employe recupéré : " + id_recup);

                                        // TABLE INFIRMIER : on crée un nouveau tuple dans la table infirmier avec comme no_infirmier celui créé à l'instant
                                        requete_infirmier = Connexion.getInstance().CreerRequete_docteur_infirmier(2, id_recup, " ", code_service_recu, rotation_recu);
                                        try {
                                            // on enregistre les infos dans la table hospitalisation
                                            Connexion.getInstance().executeUpdate(requete_infirmier);
                                            // on affiche à l'utilisateur que le nouvel infirmier a bien été inscrit
                                            JOptionPane.showMessageDialog(null, "L'infirmier a été enregistré.", "Info", JOptionPane.ERROR_MESSAGE);
                                        } catch (SQLException ex) {
                                            System.out.println("Echec SQL");
                                            ex.printStackTrace();
                                        }

                                        // s'il a sélectionné la case "surveillant"
                                        if (jch_surveillant.isSelected()) {
                                            // TABLE CHAMBRE : 
                                            try {

                                                // Récupération de la valeur de la chambre sélectionnée
                                                chambre_recu = Integer.parseInt(Jcombo_chambres.getSelectedItem().toString().trim());

                                                // on écrit la requete pour inscrire le surveillant et on l'exécute
                                                requete_surveillant = Connexion.getInstance().CreerRequete_surveillant(id_recup, rotation_recu, code_service_recu, chambre_recu);
                                                System.out.println(requete_surveillant);

                                                try {
                                                    // on enregistre les infos dans la table CHAMBRE
                                                    Connexion.getInstance().executeUpdate(requete_surveillant);

                                                    // on affiche à l'utilisateur que le nouvel infirmier a bien été inscrit
                                                    JOptionPane.showMessageDialog(null, "L'infirmier a été enregistré en tant que surveillant.", "Info", JOptionPane.ERROR_MESSAGE);

                                                    //on déselectionne la checkbox surveillant 
                                                    jch_surveillant.setSelected(false);

                                                    // et on rend vide la liste déroulante des chambres  
                                                    Jcombo_chambres.removeAllItems();

                                                } catch (SQLException ex) {
                                                    System.out.println("Echec SQL");
                                                    ex.printStackTrace();
                                                }
                                            } catch (NumberFormatException nfe) {
                                                nfe.printStackTrace();

                                            }

                                        }

                                    } catch (SQLException ei) {
                                        if (ei instanceof MySQLIntegrityConstraintViolationException) {
                                            JOptionPane.showMessageDialog(null, "Ce patient est déjà enregistré.", "Erreur", JOptionPane.ERROR_MESSAGE);
                                            System.out.println("Echec SQL");
                                            ei.printStackTrace();
                                        }

                                    }

                                } // fin du else if infirmier

                            } else {
                                JOptionPane.showMessageDialog(null, "Le téléphone n'est pas au format '-- -- -- -- --'.", "Erreur", JOptionPane.ERROR_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "La date de naissance n'est pas au format aaaa-mm-jj.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Le numéro de salaire n'est pas correct.", "Erreur", JOptionPane.ERROR_MESSAGE);
                        nfe.printStackTrace();

                    }

                }
            }
        });

        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin.getFenetre(f);
            }
        });

        Jcombo_fonction.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    if (e.getItem().toString() == "Docteur") {
                        // VISIBLES
                        p13.setVisible(true); // liste specialites
                        p17.setVisible(true); // checkbox ORL
                        p18.setVisible(true); // checkbox REA
                        p19.setVisible(true); // checkbox CHG

                        // INVISIBLES
                        p14.setVisible(false); // liste rotation
                        p15.setVisible(false); // liste code service 
                        p20.setVisible(false); // checkbox surveillant
                        jch_surveillant.setSelected(false);

                    } else if (e.getItem().toString() == "Infirmier") {
                        // VISIBLES
                        p14.setVisible(true); // liste rotation 
                        p15.setVisible(true); // liste code service
                        p20.setVisible(true); // checkbox surveillant

                        // INVISIBLES
                        p13.setVisible(false); // liste specialites
                        p17.setVisible(false); // checkbox ORL
                        p18.setVisible(false); // checkbox REA
                        p19.setVisible(false); // checkbox CHG
                        jch_ORL.setSelected(false);
                        jch_REA.setSelected(false);
                        jch_CHG.setSelected(false);
                        jch_dorl.setSelected(false);
                        jch_drea.setSelected(false);
                        jch_dchg.setSelected(false);

                    }
                }
            }
        });

        jch_surveillant.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    if (jch_surveillant.isSelected()) {
                        // on affiche dans une liste déroulante la liste des chambres correspondant au service sélectionné n'ayant pas de surveillant jour / nuit selon la rotation sléectionnée
                        // requete de sélection des chambres disponilbes à la surveillance

                        // enregistre la valeur de la liste rotation
                        String rotation = Jcombo_rotation.getSelectedItem().toString();
                        // enregistre le code service recu
                        String code_service = Jcombo_service.getSelectedItem().toString();

                        // recupere les chambres disponibles à la surveillance selon le service
                        ArrayList<String> liste;

                        Jcombo_chambres.removeAllItems();

                        liste = Connexion.getInstance().Requete_chambre_dispo_surveillant(rotation, code_service);

                        int taille = liste.size();

                        for (int i = 0; i < liste.size(); i++) {
                            System.out.println("" + liste.get(i));
                            // Connnexion renvoit un tableau de String, avec dans chaque string tous les attirbuts désirés par la requete séparés par des virgules                            
                            Jcombo_chambres.addItem(liste.get(i));
                        }

                        // si toutes les chambres du service ont déjà un surveillant pour la rotation sélectionnée, on affiche un message 
                        if (taille == 0) {
                            JOptionPane.showMessageDialog(null, "Toutes les chambres de ce service ont déjà un surveillant", "Erreur", JOptionPane.ERROR_MESSAGE);
                            // on n'affiche plus l'option cocher la case surveillant
                            //on déselectionne la checkbox surveillant
                            jch_surveillant.setSelected(false);

                            // et on rend vide la liste déroulante des chambres  
                            Jcombo_chambres.removeAllItems();
                        }

                    }
                }
            }

        });

        Jcombo_rotation.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                   // si on change la rotation ou le service, il faut qu'il réappuie sur sureveillant pour récupérer la liste des chambres 

                    // si on change la rotation, on déselectionne la checkbox surveillant
                    jch_surveillant.setSelected(false);

                    // et on rend vide la liste déroulante des chambres  
                    Jcombo_chambres.removeAllItems();
                }
            }
        });

        Jcombo_service.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                   // si on change la rotation ou le service, il faut qu'il réappuie sur sureveillant pour récupérer la liste des chambres 

                    // si on change la rotation, on déselectionne la checkbox surveillant
                    jch_surveillant.setSelected(false);

                    // et on rend vide la liste déroulante des chambres  
                    Jcombo_chambres.removeAllItems();
                }
            }
        });

    }

    public static Ajouter_employe getFenetre(JFrame f) {

        if (fenetre == null) {
            fenetre = new Ajouter_employe(f);
        }

        // On ajoute tous les JPannel à la fenêtre
        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        f.add(p1);
        f.add(p3);
        f.add(p4);
        f.add(p16);
        f.add(p5);
        f.add(p6);
        f.add(p7);

        f.add(p12); // liste deroulante infirmier / docteur
        f.add(p13); // liste 
        f.add(p14);
        f.add(p15);
        f.add(p17); // ORL
        f.add(p18); // REA
        f.add(p19); // CHG
        f.add(p20); // surveillant

        p14.setVisible(false);
        p15.setVisible(false);
        p20.setVisible(false);

        f.add(p11);

        f.setSize(600, 600);

        f.setVisible(true);

        return fenetre;
    }

    public int docteurs_cohérence_chboxs(JCheckBox jch_ORL, JCheckBox jch_Dir_ORL, JCheckBox jch_REA, JCheckBox jch_Dir_REA, JCheckBox jch_CHG, JCheckBox jch_Dir_CHG) {
        // par défaut on va cocher les directeurs sélectionnés en renvoyant 1
        int cocher_directeurs = 1;

        // check si un directeur a été coché sans que le service associé ait été coché également 
        // service ORL
        if (jch_ORL.isSelected() == false && jch_Dir_ORL.isSelected() == true) {
            JOptionPane.showMessageDialog(null, "La case directeur du service ORL a été cochée sans que la case du service ne l'ait été.", "Erreur", JOptionPane.ERROR_MESSAGE);
            cocher_directeurs = 0;
        }
        // service REA
        if (jch_REA.isSelected() == false && jch_Dir_REA.isSelected() == true) {
            JOptionPane.showMessageDialog(null, "La case directeur du service REA a été cochée sans que la case du service ne l'ait été.", "Erreur", JOptionPane.ERROR_MESSAGE);
            cocher_directeurs = 0;
        }
        // service CHG
        if (jch_CHG.isSelected() == false && jch_Dir_CHG.isSelected() == true) {
            JOptionPane.showMessageDialog(null, "La case directeur du service CHG a été cochée sans que la case du service ne l'ait été.", "Erreur", JOptionPane.ERROR_MESSAGE);
            cocher_directeurs = 0;
        }

        return cocher_directeurs;

    }
}
