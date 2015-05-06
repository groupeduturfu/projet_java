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
public class Infirmier extends Employe{
    private JLabel jl_rotation, jl_nom_service, jtf_no_id, jtf_nom, jtf_prenom, jtf_date, jtf_adresse;;
    private JTextField jtf_rotation, jtf_nom_service;
    private JPanel panel, p1;
    
    public Infirmier()
    {
        super();
        jl_rotation = new JLabel("Spécialité");
        jtf_rotation = new JTextField();
        jtf_rotation.setColumns(20);
        jl_nom_service = new JLabel("Nom service");
        jtf_nom_service = new JTextField();
        jtf_nom_service.setColumns(20);
        
        p1 = new JPanel();
        p1.add(jl_rotation);
        p1.add(jtf_rotation);
        p1.setOpaque(false);
        p1.setPreferredSize(new Dimension(600, 30));
        
        panel = new JPanel();
        panel.add(super.getPanel());
        panel.add(p1);
    }
    
    public Infirmier(int n, String nom, String prenom, String date, String adresse, String tel, long salaire, String rotation, String nom_service)
    {
        super(n, nom, prenom, date, adresse, tel, salaire);
        jtf_rotation.setText(rotation);
        jtf_nom_service.setText(nom_service);
    }
    
    
    public JPanel getPanel()
    {
        return panel;
    }
}
