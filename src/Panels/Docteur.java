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
public class Docteur extends Employe{
    private JLabel jl_spe, jl_nom, jl_prenom, jl_date, jl_adresse, jl_no_id, jl_tel, jl_salaire;
    private JTextField jtf_spe, jtf_no_id, jtf_nom, jtf_prenom, jtf_date, jtf_adresse, jtf_tel, jtf_salaire;
    private JPanel panel, p1, p2, p3, p4, p5, p6, p7, p8;
    
    public Docteur()
    {
        // On initialise les JLabel
        jl_spe = new JLabel("Spécialité");
        jl_no_id = new JLabel("N° identification");
        jl_nom = new JLabel("Nom");
        jl_prenom = new JLabel("Prénom");
        jl_date = new JLabel("Date de naissance");
        jl_adresse = new JLabel("Adresse");
        jl_tel = new JLabel("N° telephone");
        jl_salaire = new JLabel("Salaire");
        
        // On iitialise les JTF
        jtf_no_id = new JTextField();
        jtf_nom = new JTextField();
        jtf_prenom = new JTextField();
        jtf_date = new JTextField();
        jtf_adresse = new JTextField();
        jtf_spe = new JTextField();
        jtf_tel = new JTextField();
        jtf_salaire = new JTextField();
        
        
        jtf_no_id.setColumns(20);
        jtf_nom.setColumns(20);
        jtf_prenom.setColumns(20);
        jtf_date.setColumns(20);
        jtf_adresse.setColumns(20);
        jtf_spe.setColumns(20);
        jtf_tel.setColumns(20);
        jtf_salaire.setColumns(20);
        
        // On initialise les JPanel
        p1 = new JPanel();
        p1.add(jl_no_id);
        p1.add(jtf_no_id);
        p1.setOpaque(false);
        p1.setPreferredSize(new Dimension(600, 30));
        
        p2 = new JPanel();
        p2.add(jl_nom);
        p2.add(jtf_nom);
        p2.setOpaque(false);
        p2.setPreferredSize(new Dimension(600, 30));
        
        p3 = new JPanel();
        p3.add(jl_prenom);
        p3.add(jtf_prenom);
        p3.setOpaque(false);
        p3.setPreferredSize(new Dimension(600, 30));
        
        p4 = new JPanel();
        p4.add(jl_date);
        p4.add(jtf_date);
        p4.setOpaque(false);
        p4.setPreferredSize(new Dimension(600, 30));
        
        p5 = new JPanel();
        p5.add(jl_adresse);
        p5.add(jtf_adresse);
        p5.setOpaque(false);
        p5.setPreferredSize(new Dimension(600, 30));
   
        p6 = new JPanel();
        p6.add(jl_tel);
        p6.add(jtf_tel);
        p6.setOpaque(false);
        p6.setPreferredSize(new Dimension(600, 30));
       
        p7 = new JPanel();
        p7.add(jl_salaire);
        p7.add(jtf_salaire);
        p7.setOpaque(false);
        p7.setPreferredSize(new Dimension(600, 30));
        
        p8 = new JPanel();
        p8.add(jl_spe);
        p8.add(jtf_spe);
        p8.setOpaque(false);
        p8.setPreferredSize(new Dimension(600, 30));
        
        panel = new JPanel();
        panel.add(super.getPanel());
        panel.add(p1);
        panel.add(p2);
        panel.add(p3);
        panel.add(p4);
        panel.add(p5);
        panel.add(p6);
        panel.add(p7);
        panel.add(p8);
    }
    
    public Docteur(int n, String nom, String prenom, String date, String adresse, String tel, long salaire, String spe)
    {
        super(n, nom, prenom, date, adresse, tel, salaire);
        jtf_spe.setText(spe);
    }
    
    
    public JPanel getPanel()
    {
        return panel;
    }
}
