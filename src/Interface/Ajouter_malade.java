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
public class Ajouter_malade {

    private static Ajouter_malade fenetre = null;
    private static JPanel p1, p2, p3, p4, p5, p6, p8, p9, p10, p11, p12, p13, p14;

    private Ajouter_malade(JFrame f) {
        JTextField jtf_nom, jtf_prenom, jtf_no_chambre, jtf_no_lit, jtf_adresse, jtf_tel, jtf_mutuelle, jtf_docteur, jtf_description, jtf_date_naissance;
        JLabel jl_no_id, jl_nom, jl_prenom, jl_no_chambre, jl_no_lit, jl_adresse, jl_tel, jl_mutuelle, jl_docteur, jl_description, jl_date_naissance, texte;
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");

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
        jtf_description = new JTextField();
        jtf_date_naissance = new JTextField();

        //jtf_no_id.setColumns(10);
        jtf_nom.setColumns(15);
        jtf_prenom.setColumns(15);
        jtf_no_chambre.setColumns(15);
        jtf_no_lit.setColumns(15);
        jtf_adresse.setColumns(15);
        jtf_tel.setColumns(15);
        jtf_mutuelle.setColumns(15);
        jtf_docteur.setColumns(15);
        jtf_description.setColumns(15);
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

        p12 = new JPanel();
        p12.add(jl_docteur);
        p12.add(jtf_docteur);
        p12.setOpaque(false);
        p12.setPreferredSize(new Dimension(600, 30));

        p13 = new JPanel();
        p13.add(jl_description);
        p13.add(jtf_description);
        p13.setOpaque(false);
        p13.setPreferredSize(new Dimension(600, 30));

        p14 = new JPanel();
        p14.add(jl_date_naissance);
        p14.add(jtf_date_naissance);
        p14.setOpaque(false);
        p14.setPreferredSize(new Dimension(600, 30));

        System.out.println("nom : ");

        // On gère l'évennement du bouton
        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // C'est ici qu'il faut récupérer les informations et ajouter un patient dans la BDD
                // Attention, il faut que le numero id du patient soit implémenté tout seul ainsi que la date d'arrivée

                int id_recu;
                String nom_recu;
                String prenom_recu;
                int no_chambre_recu;
                int no_lit_recu;
                String lit_string;
                String adresse_recu;
                String tel_recu;
                String mutuelle_recu;
                String nom_docteur_recu;
                String date_naissance_recu;
                String no_chambre;
                String no_lit;

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
                    date_naissance_recu = jtf_date_naissance.getText();

                    // récupération du numéro de chambre
                    try {
                        no_chambre_recu = Integer.parseInt(jtf_no_chambre.getText().trim());

                        // récupération du numéro de lit
                        try {
                            no_lit_recu = Integer.parseInt(jtf_no_lit.getText().trim());

                            // avant d'enregistrer le malade on vérifie que le nom du docteur existe
                            // on récupère le numéro de docteur correspondant au nom inscrit dans le formulaire 
                            requete_docteur = Connexion.getInstance().CreerRequete_recup_id_docteur(nom_docteur_recu);
                            try {
                                // on recupere le numero du medecin qui soigne le patient
                                id_string_docteur_recup = Connexion.getInstance().RecupererId(requete_docteur);
                                // si le nom du docteur mentionné n'exite pas dans la base
                                if (id_string_docteur_recup == "NotExist") {
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

                                                    // écriture de la requete : écrire infos dans la table malade
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
                                                            requete_hopsitalisation = Connexion.getInstance().CreerRequete_hospitalisation(id_malade_recup, no_chambre_recu, no_lit_recu, id_docteur_recup);
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
                    } catch (NumberFormatException nfe) {
                        JOptionPane.showMessageDialog(null, "Le numéro de chambre n'est pas correct.", "Erreur", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        );

        retour.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Accueil.getFenetre(f);
            }
        });

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
        f.add(p5);
        f.add(p6);
        f.add(p8);
        f.add(p9);
        f.add(p10);
        f.add(p12);
        f.add(p11);

        f.setSize(600, 600);

        f.setVisible(true);

        return fenetre;
    }

}
