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
 * @author Antoine
 */
public class Modifier_malade {
    private static Modifier_malade fenetre = null;
    private static JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;
    private static JTextField jtf_nom, jtf_prenom, jtf_no_chambre, jtf_no_lit, jtf_date_arrivee, jtf_adresse, jtf_tel, jtf_mutuelle;
    private static JLabel jtf_no_id;
    private Connexion maconnexion;
    private static ArrayList<ArrayList<String>> liste;
    public Modifier_malade(JFrame f, ArrayList<String> combobox_choix, ArrayList<ArrayList<String>> liste) {
        
        JLabel jl_no_id, jl_nom, jl_prenom, jl_no_chambre, jl_no_lit, jl_datea, jl_adresse, jl_tel, jl_mutuelle, texte;
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");
        maconnexion = Connexion.getInstance();
        this.liste = liste;
        System.out.println("1");
        // On initialise les JLabel
        texte = new JLabel("Modifier les informations connues sur le patient");
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
        jtf_no_id = new JLabel("");
        jtf_no_id.setText(combobox_choix.get(0));
        jtf_nom = new JTextField();
        jtf_prenom = new JTextField();
        jtf_no_chambre = new JTextField();
        jtf_no_lit = new JTextField();
        jtf_date_arrivee = new JTextField();
        jtf_adresse = new JTextField();
        jtf_tel = new JTextField();
        jtf_mutuelle = new JTextField();
        jtf_nom.setColumns(10);
        jtf_prenom.setColumns(10);
        jtf_no_chambre.setColumns(10);
        jtf_no_lit.setColumns(10);
        jtf_date_arrivee.setColumns(10);
        jtf_adresse.setColumns(40);
        jtf_tel.setColumns(10);
        jtf_mutuelle.setColumns(10);
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
        p11.add(retour);
        p11.add(valider);
        p11.setOpaque(false);
        p11.setPreferredSize(new Dimension(600, 30));
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
        System.out.println("2");
        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String requete, id_recu, nom_recu, prenom_recu, date_arrivee_recu, adresse_recu, tel_recu, mutuelle_recu;
                int no_chambre_recu, no_lit_recu;
                ArrayList<ArrayList<String>> QueryList;
                QueryList = new ArrayList<ArrayList<String>>();
                id_recu = combobox_choix.get(0);
                nom_recu = jtf_nom.getText();
                prenom_recu = jtf_prenom.getText();
                no_chambre_recu = Integer.parseInt(jtf_no_chambre.getText().trim());
                no_lit_recu = Integer.parseInt(jtf_no_lit.getText().trim());
                date_arrivee_recu = jtf_date_arrivee.getText();
                adresse_recu = jtf_adresse.getText();
                tel_recu = jtf_tel.getText();
                mutuelle_recu = jtf_mutuelle.getText();
                //if (date_arrivee_recu.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})") && (tel_recu.matches("([0-9]{10})"))) {
                    QueryList = maconnexion.ActuPage(id_recu, nom_recu, prenom_recu, no_chambre_recu, no_lit_recu, adresse_recu, tel_recu, mutuelle_recu, date_arrivee_recu, liste);
                    liste.clear();
                    liste.addAll(QueryList);
                //}
                    Afficher_malade.getFenetre(f,liste);
            }
        });
        
        retour.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    
                    Afficher_malade.getFenetre(f, liste);
                }
        });
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
        f.setSize(600, 600);
        f.setVisible(true);
    }
    public static Modifier_malade getFenetre(JFrame f, ArrayList<String> combobox_choix, ArrayList<ArrayList<String>> liste) {
       
            fenetre = new Modifier_malade(f, combobox_choix, liste);
        return fenetre;
    }
}