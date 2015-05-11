/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RefineryUtilities;
import projet.Connexion;


/**
 * Classe correspondant au module de reporting permettant d'afficher des réponse 
 * a des requetes de manière cohérente avec le type de requete
 * @author mathieuchebassier
 */
public class Stats {

    private static Stats fenetre = null;
    private static JPanel p1, p2, p3, p4;

    /**
     *
     * @param f 
     */
    private Stats(JFrame f) {
        // On initialise les boutons
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");
        JComboBox combo = new JComboBox();

        // On initialise et remplit la combobox
        combo.setPreferredSize(new Dimension(400, 30));
        combo.addItem("Nombre de patient par service");
        combo.addItem("Salaire moyen des employés");
        combo.addItem("Nombre d'intervention par médecin");

        // On initialise les JLabels
        JLabel texte = new JLabel("Veuillez selectionner la requete à envoyer");

        // On change le bouton de forme
        valider.setPreferredSize(new Dimension(200, 30));
        valider.setOpaque(false);
        retour.setPreferredSize(new Dimension(200, 30));
        retour.setOpaque(false);

        // On initialise les Jpanels
        p1 = new JPanel();
        p1.setPreferredSize(new Dimension(600, 100));
        p1.add(texte);
        p1.setOpaque(false);

        p2 = new JPanel();
        p2.add(combo);
        p2.setOpaque(false);

        p4 = new JPanel();
        p4.add(retour);
        p4.add(valider);
        p4.setOpaque(false);

        // Gestion des boutons
        retour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Accueil.getFenetre(f);
            }
        });

        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (combo.getSelectedItem().equals("Nombre de patient par service")) {

                    System.out.println("Nb de patients en REA : " + Connexion.getInstance().nb_malade_services("\"REA\""));
                    System.out.println("Nb de patients en ORL : " + Connexion.getInstance().nb_malade_services("\"ORL\""));
                    System.out.println("Nb de patients en CHG : " + Connexion.getInstance().nb_malade_services("\"CHG\""));

              //      new Camembert(f, Connexion.getInstance().nb_malade_services("\"REA\""), Connexion.getInstance().nb_malade_services("\"ORL\""), Connexion.getInstance().nb_malade_services("\"CHG\""));
                    JPanel panel_camemb = Camembert.cCamembert(f, Connexion.getInstance().nb_malade_services("\"REA\""), Connexion.getInstance().nb_malade_services("\"ORL\""), Connexion.getInstance().nb_malade_services("\"CHG\""));;

                        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
                        f.add(p1);
                        f.add(p2);
                        f.add(p4);
                        f.add(panel_camemb);

                        f.setVisible(true);
                    
                } else if (combo.getSelectedItem().equals("Salaire moyen des employés")) {
                    JLabel jf_doc, jf_inf, jf_emp;
                    JTextField jtf_doc, jtf_inf, jtf_emp;
                    JPanel p5, p6, p7;

                    // On initialise les JF
                    jf_doc = new JLabel("Salaire moyen des docteurs");
                    jf_inf = new JLabel("Salaire moyen des infirmiers");
                    jf_emp = new JLabel("Salaire moyen de tous les employés");

                    // On initialise les JTF
                    jtf_doc = new JTextField();
                    jtf_doc.setPreferredSize(new Dimension(200, 30));
                    jtf_doc.setText(Float.toString(Connexion.getInstance().moyenne_salaired()) + " €");

                    jtf_inf = new JTextField();
                    jtf_inf.setPreferredSize(new Dimension(200, 30));
                    jtf_inf.setText(Float.toString((Connexion.getInstance().moyenne_salairei())) + " €");

                    jtf_emp = new JTextField();
                    jtf_emp.setPreferredSize(new Dimension(160, 30));
                    jtf_emp.setText(Float.toString((Connexion.getInstance().moyenne_salaire())) + " €");

                    
                    // On crée les JPanels
                    p5 = new JPanel();
                    p5.add(jf_doc);
                    p5.add(jtf_doc);
                    p5.setOpaque(false);

                    p6 = new JPanel();
                    p6.add(jf_inf);
                    p6.add(jtf_inf);
                    p6.setOpaque(false);

                    p7 = new JPanel();
                    p7.add(jf_emp);
                    p7.add(jtf_emp);
                    p7.setOpaque(false);

                    f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
                    f.add(p1);
                    f.add(p2);
                    f.add(p4);
                    f.add(p5);
                    f.add(p6);
                    f.add(p7);

                    f.setVisible(true);
                    f.setSize(new Dimension(600, 600));
                }
                else if(combo.getSelectedItem().equals("Nombre d'intervention par médecin"))
                {
                    ArrayList liste = null;
                    try {
                        // ICI !!!!!!!!!!
                        liste = Connexion.getInstance().reporting("SELECT e.nom , COUNT(d.no_docteur) FROM hospitalisation h, docteur d , employe e WHERE (h.no_docteur= d.no_docteur) AND e.no_employe = d.no_docteur  GROUP BY e.nom");
                    } catch (SQLException ex) {
                        Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (liste != null)
                    {
                        JPanel panel_camemb = Camembert.cCamembert(f, liste);

                        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
                        f.add(p1);
                        f.add(p2);
                        f.add(p4);
                        f.add(panel_camemb);

                        f.setVisible(true);
                    }
                   
                }
            }
        });
    }

     /**
     * Sous programme permettant de vérifier que chaque 
     * fenêtre n'est crée qu'une fois puis uniquement réutilisée
     * @param f
     * @return type de la classe
     */
    public static Stats getFenetre(JFrame f) {

        if (fenetre == null) {
            fenetre = new Stats(f);
        }

        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        f.add(p1);
        f.add(p2);
        f.add(p4);

        f.setVisible(true);
        f.setSize(new Dimension(600, 600));

        return fenetre;
    }

}
