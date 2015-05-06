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
    
    private Mdp fenetre = null;
    
    public static boolean mdp_fonctionnement()
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
}
