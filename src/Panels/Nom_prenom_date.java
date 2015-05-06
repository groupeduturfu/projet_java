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
 * 
 */
public class Nom_prenom_date {
    
    private JTextField jtf_no_id, jtf_nom, jtf_prenom, jtf_date;
    private JLabel jl_no_id, jl_nom, jl_prenom, jl_date;
    private JPanel panel, p1, p2, p3, p4;
    
    public Nom_prenom_date()
    {
        // On initialise les JLabel
        jl_no_id = new JLabel("N° identification");
        jl_nom = new JLabel("Nom");
        jl_prenom = new JLabel("Prénom");
        jl_date = new JLabel("Date de naissance");
    
        // On iitialise les JTF
        jtf_no_id = new JTextField();
        jtf_nom = new JTextField();
        jtf_prenom = new JTextField();
        jtf_date = new JTextField();
        
        jtf_no_id.setColumns(20);
        jtf_nom.setColumns(20);
        jtf_prenom.setColumns(20);
        jtf_date.setColumns(20);
        
        // On initialise les JPanel
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
        
        p1 = new JPanel();
        p1.add(jl_date);
        p1.add(jtf_date);
        p1.setOpaque(false);
        p1.setPreferredSize(new Dimension(600, 30));
        
        panel = new JPanel(); // Taille 600,120
        panel.add(p2);
        panel.add(p3);
        panel.add(p4);
        panel.add(p1);
    }
    
    /**
     * 
     * @param n
     * @param nom
     * @param prenom
     * @param date 
     */
    public Nom_prenom_date(int n, String nom, String prenom, String date)
    {
        this();
        jtf_no_id.setText(Integer.toString(n));
        jtf_nom.setText(nom);
        jtf_prenom.setText(prenom);
        jtf_date.setText(date);
    }
    
    /**
     * Cette fonction renvoie un JPanel de taille 600,120 contenant n° id, nom, prénom, date de naissance
     * @return JPanel 
     */
    public JPanel getPanel()
    {
        return panel;
    }
}
