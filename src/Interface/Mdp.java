/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import projet.Connexion;

/**
 *
 * @author meyronneaudrey
 */
public class Mdp {
    
    public static boolean mdp_fonctionnement(JFrame f)
    {
       JPanel p = new JPanel();
        JLabel l = new JLabel("Entrer le mot de passe pour acceder à la partie admin :");
        JTextField mdp = new JTextField(10);
        String mdp_tape = "";
                 
        p.add(l);
        p.add(mdp);
        String[] options = new String[]{"OK", "Retour"};
        int option = JOptionPane.showOptionDialog(null, p, "Mot de passe",
                                 JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                 null, options, options[1]);
        if(option == 0) // Boutton OK
        {
            mdp_tape  = mdp.getText();
        }
        else Accueil.getFenetre(f); // Retour
        
        if(mdp_tape.equals("hopital")) return true;
        else return false; 
    }
}
