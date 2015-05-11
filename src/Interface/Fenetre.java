/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.sql.*;

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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import projet.Malade;

/**
 *
 * @author mathieuchebassier
 */
public class Fenetre extends JFrame {
   // final JButton rechercher, ajouter, admin, consulter, emp_presents, lit_libre, stats;

    /**
     * C'est ici qu'est la base de l'interface graphique, la classe fenetre
     * extends JFrame sera envoyée à toutes les classes de l'interface
     */
    public Fenetre() {

       this.setTitle("Gestion Hopital");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Quand on clique sur la croix, ça quitte proprement
        this.setLayout(new FlowLayout()); // La fenêtre est répartie en grille : 8 lignes, 2 colonnes
        

        //Accueil.getFenetre(this);
        Choix_connexion c = new Choix_connexion(this);
    }

}