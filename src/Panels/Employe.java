/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panels;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mathieuchebassier
 */
public class Employe extends Personne{
    
    private JTextField jtf_tel, jtf_salaire;
    private JLabel jl_tel, jl_salaire;
    private JPanel panel, p2, p3;
    
    public Employe()
    {
        super();
        // On initialise les JLabel
        jl_tel = new JLabel("N° telephone");
        jl_salaire = new JLabel("Salaire");
    
        // On iitialise les JTF
        jtf_tel = new JTextField();
        jtf_salaire = new JTextField();
        
        jtf_tel.setColumns(20);
        jtf_salaire.setColumns(20);
        
        // On initialise les JPanel
        p2 = new JPanel();
        p2.add(jl_tel);
        p2.add(jtf_tel);
        p2.setOpaque(false);
        p2.setPreferredSize(new Dimension(600, 30));
        
        p3 = new JPanel();
        p3.add(jl_salaire);
        p3.add(jtf_salaire);
        p3.setOpaque(false);
        p3.setPreferredSize(new Dimension(600, 30));
        
        panel = new JPanel(); // Taille 600,120
        panel.add(super.getPanel()); // On ajoute la partie commune a toutes les personnes
        panel.add(p2);
        panel.add(p3);
    }
    
    public Employe(int n, String nom, String prenom, String date, String adresse, String tel, long salaire)
    {
        super(n, nom, prenom, date, adresse);
        {
            jtf_tel.setText(tel);
            jtf_salaire.setText(Long.toString(salaire));
        }
    }
    
    public JPanel getPanel()
    {
        return panel;
    }
}
