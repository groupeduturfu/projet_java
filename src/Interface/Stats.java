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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import projet.Connexion;

/**
 *
 * @author mathieuchebassier
 */
public class Stats {

    private static Stats fenetre = null;
    private static JPanel p1, p2, p3, p4;

    private Stats(JFrame f) {
        // On initialise les boutons
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");
        JComboBox combo = new JComboBox();

        // On initialise et remplit la combobox
        combo.setPreferredSize(new Dimension(400, 30));
        combo.addItem("Nombre de patient par service");
        combo.addItem("Salaire moyen des infirmiers");
        combo.addItem("Salaire moyen des docteurs");

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
                Admin.getFenetre(f);
            }
        });

        valider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

              System.out.println("Moyenne salaire docteurs : " + Connexion.getInstance().moyenne_salaired());
            }
        });
    }

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
