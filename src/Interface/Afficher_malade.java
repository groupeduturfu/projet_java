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
import javax.swing.JComboBox;
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
public class Afficher_malade {
    private static Afficher_malade fenetre;
    private static ArrayList<ArrayList<String>> liste;
    private Connexion maconnexion;
    private static JPanel pbouton, phaut, p2, p3, p4, p5, p6, p7, p8, p9, p10,p11;
    private static JLabel jtf_no_id, jtf_nom, jtf_prenom, jtf_no_chambre, jtf_no_lit, jtf_date_arrivee, jtf_adresse, jtf_tel, jtf_mutuelle;
    private static JComboBox combo;
    
    
        public Afficher_malade(JFrame f, ArrayList<ArrayList<String>> liste) {
        JButton retour = new JButton("Retour");
        JButton modifier = new JButton("Modifier");
        JButton archiver = new JButton("Archiver");
        this.liste = liste;
        maconnexion = Connexion.getInstance();
        
        JLabel jl_no_id, jl_nom, jl_prenom, jl_no_chambre, jl_no_lit, jl_date_arrivee, jl_adresse, jl_tel, jl_mutuelle, texte, jl_nom_malade;
        // On initialise les JLabel
        jl_no_id = new JLabel("N° identification");
        jl_nom = new JLabel("Nom");
        jl_prenom = new JLabel("Prénom");
        jl_no_chambre = new JLabel("N° chambre");
        jl_no_lit = new JLabel("N° lit");
        jl_date_arrivee = new JLabel("Date d'arrivée");
        jl_adresse = new JLabel("Adresse");
        jl_tel = new JLabel("N° telephone");
        jl_mutuelle = new JLabel("Mutuelle");
        // On initialise les JTF
        jtf_no_id = new JLabel("");
        jtf_nom = new JLabel("");
        jtf_prenom = new JLabel("");
        jtf_no_chambre = new JLabel("");
        jtf_no_lit = new JLabel("");
        jtf_date_arrivee = new JLabel("");
        jtf_adresse = new JLabel("");
        jtf_tel = new JLabel("");
        jtf_mutuelle = new JLabel("");
        
        combo=new JComboBox();
        combo.setPreferredSize(new Dimension(200, 30));
        combo.setOpaque(false);
        // On initialise les objets
        retour.setPreferredSize(new Dimension(250, 30));
        retour.setOpaque(false);
        modifier.setPreferredSize(new Dimension(250, 30));
        modifier.setOpaque(false);
        archiver.setOpaque(false);
        archiver.setPreferredSize(new Dimension(300, 30));
        
        //On initialise la liste avec les résultats correspondants à la recherche
        for (int i = 0; i < liste.size(); i++) {
            combo.addItem(this.liste.get(i));
        }
        // On crée les panels
        phaut = new JPanel();
        phaut.add(combo);
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
        p7.add(jl_date_arrivee);
        p7.add(jtf_date_arrivee);
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
        pbouton.add(retour);
        pbouton.add(modifier);
        pbouton.setOpaque(false);
        pbouton.setPreferredSize(new Dimension(600, 30));
        p11 = new JPanel();
        p11.add(archiver);
        p11.setOpaque(false);
        p11.setPreferredSize(new Dimension(600, 30));
        // Ici il faut remplir les champs pour voir les données de chaque patient
        ArrayList<String> combobox_choix;
        combobox_choix = new ArrayList<String>();
        combobox_choix = (ArrayList<String>) combo.getSelectedItem();
        // On REMPLIT les JTF --> Ca ne marche pas encore
        jtf_no_id.setText(combobox_choix.get(0));
        jtf_nom.setText(combobox_choix.get(1));
        jtf_prenom.setText(combobox_choix.get(2));
        jtf_no_chambre.setText(combobox_choix.get(3));
        jtf_no_lit.setText(combobox_choix.get(4));
        jtf_date_arrivee.setText(combobox_choix.get(5));
        jtf_adresse.setText(combobox_choix.get(6));
        jtf_tel.setText(combobox_choix.get(7));
        jtf_mutuelle.setText(combobox_choix.get(8));
        int id;
        id = Integer.parseInt(combobox_choix.get(0));
        //////////listeners//////
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Accueil.getFenetre(f);
            }
        });
        modifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Modifier_malade.getFenetre(f,(ArrayList<String>) combo.getSelectedItem(),liste);
            }
        });
        archiver.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
               try{
                   maconnexion.Archiver(jtf_no_id.getText(),jtf_date_arrivee.getText());
                   Accueil.getFenetre(f);
               }
               catch(SQLException ex){
                   System.out.println("Echec SQL");
                    ex.printStackTrace();
               }
           } 
        });
        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        f.add(phaut);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        f.add(p5);
        f.add(p6);
        f.add(p7);
        f.add(p8);
        f.add(p9);
        f.add(p10);
        f.add(pbouton);
        f.add(p11);
        f.setSize(600, 600);
        f.setVisible(true);
    }
    
    public Afficher_malade(JFrame f, ArrayList<ArrayList<String>> liste, ArrayList<String> combobox_choix) {
        JButton retour = new JButton("Retour");
        JButton modifier = new JButton("Modifier");
        JButton archiver = new JButton("Archiver");
        this.liste = liste;
        maconnexion = Connexion.getInstance();
        
        JLabel jl_no_id, jl_nom, jl_prenom, jl_no_chambre, jl_no_lit, jl_date_arrivee, jl_adresse, jl_tel, jl_mutuelle, texte, jl_nom_malade;
        // On initialise les JLabel
        jl_no_id = new JLabel("N° identification");
        jl_nom = new JLabel("Nom");
        jl_prenom = new JLabel("Prénom");
        jl_no_chambre = new JLabel("N° chambre");
        jl_no_lit = new JLabel("N° lit");
        jl_date_arrivee = new JLabel("Date d'arrivée");
        jl_adresse = new JLabel("Adresse");
        jl_tel = new JLabel("N° telephone");
        jl_mutuelle = new JLabel("Mutuelle");
        // On initialise les JTF
        jtf_no_id = new JLabel("");
        jtf_nom = new JLabel("");
        jtf_prenom = new JLabel("");
        jtf_no_chambre = new JLabel("");
        jtf_no_lit = new JLabel("");
        jtf_date_arrivee = new JLabel("");
        jtf_adresse = new JLabel("");
        jtf_tel = new JLabel("");
        jtf_mutuelle = new JLabel("");
        /*jtf_no_id.setColumns(10);
        jtf_nom.setColumns(10);
        jtf_prenom.setColumns(10);
        jtf_no_chambre.setColumns(10);
        jtf_no_lit.setColumns(10);
        jtf_date_arrivee.setColumns(10);
        jtf_adresse.setColumns(40);
        jtf_tel.setColumns(10);
        jtf_mutuelle.setColumns(10);*/
        
        combo=new JComboBox();
        combo.setPreferredSize(new Dimension(200, 30));
        combo.setOpaque(false);
        // On initialise les objets
        retour.setPreferredSize(new Dimension(250, 30));
        retour.setOpaque(false);
        modifier.setPreferredSize(new Dimension(250, 30));
        archiver.setOpaque(false);
        archiver.setPreferredSize(new Dimension(300, 30));
        
        //On initialise la liste avec les résultats correspondants à la recherche
        for (int i = 0; i < liste.size(); i++) {
            combo.addItem(this.liste.get(i));
        }
        // On crée les panels
        phaut = new JPanel();
        phaut.add(combo);
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
        p7.add(jl_date_arrivee);
        p7.add(jtf_date_arrivee);
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
        p11.add(archiver);
        p11.setOpaque(false);
        p11.setPreferredSize(new Dimension(600, 30));
        pbouton = new JPanel();
        pbouton.add(retour);
        pbouton.add(modifier);
        pbouton.setOpaque(false);
        pbouton.setPreferredSize(new Dimension(600, 30));
        // Ici il faut remplir les champs pour voir les données de chaque patient
        
        //combobox_choix = new ArrayList<String>();
        //combobox_choix = (ArrayList<String>) combo.getSelectedItem();
        // On REMPLIT les JTF --> Ca ne marche pas encore
        jtf_no_id.setText(combobox_choix.get(0));
        jtf_nom.setText(combobox_choix.get(1));
        jtf_prenom.setText(combobox_choix.get(2));
        jtf_no_chambre.setText(combobox_choix.get(3));
        jtf_no_lit.setText(combobox_choix.get(4));
        jtf_date_arrivee.setText(combobox_choix.get(5));
        jtf_adresse.setText(combobox_choix.get(6));
        jtf_tel.setText(combobox_choix.get(7));
        jtf_mutuelle.setText(combobox_choix.get(8));
        int id;
        id = Integer.parseInt(combobox_choix.get(0));
        //////////listeners//////
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Accueil.getFenetre(f);
            }
        });
        modifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                Modifier_malade.getFenetre(f,(ArrayList<String>) combo.getSelectedItem(),liste);
            }
        });
        archiver.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
               try{
                   maconnexion.Archiver(jtf_no_id.getText(),jtf_date_arrivee.getText());
               }
               catch(SQLException ex){
                   System.out.println("Echec SQL");
                    ex.printStackTrace();
               }
           } 
        });
        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        f.add(phaut);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        f.add(p5);
        f.add(p6);
        f.add(p7);
        f.add(p8);
        f.add(p9);
        f.add(p10);
        f.add(pbouton);
        f.add(p11);
        f.setSize(600, 600);
        f.setVisible(true);
    }
    public static Afficher_malade getFenetre(JFrame f, ArrayList<ArrayList<String>> liste) {
        fenetre = new Afficher_malade(f, liste);
        return fenetre;
    }
    public static Afficher_malade getFenetre(JFrame f, ArrayList<ArrayList<String>> liste, ArrayList<String> combobox_choix) {
            fenetre = new Afficher_malade(f, liste,combobox_choix);
        
        return fenetre;
    }
}