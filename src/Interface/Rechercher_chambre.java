/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mathieuchebassier
 */
public class Rechercher_chambre {
    
    private static Rechercher_chambre fenetre = null;
    private static JPanel p1, p2, p3, p4;
    
    private Rechercher_chambre(JFrame f)
    {
        // On initialise les boutons
        JButton valider = new JButton("Valider");
        JButton retour = new JButton("Retour");
        
        // On initialise les JLabels
        JLabel jl_service = new JLabel("Service");
        JLabel jl_no_chambre = new JLabel("N° chambre");
        JLabel texte = new JLabel("Quelles sont les informations connues sur la chambre ?");
        
        // On initialise les jtf
        JTextField jtf_service = new JTextField();
        JTextField jtf_no_chambre = new JTextField();
        jtf_service.setColumns(20);
        jtf_no_chambre.setColumns(20);
        
        // On change le bouton de forme
        valider.setPreferredSize(new Dimension(200,30));
        valider.setOpaque(false);
        retour.setPreferredSize(new Dimension(200,30));
        retour.setOpaque(false);
        
        // On initialise les Jpanels
        p1 = new JPanel();
        p1.setPreferredSize(new Dimension(600,100));
        p1.add(texte);
        p1.setOpaque(false);
        
        p2 = new JPanel();
        p2.add(jl_service);
        p2.add(jtf_service);
        p2.setOpaque(false);
        
        p3 = new JPanel();
        p3.add(jl_no_chambre);
        p3.add(jtf_no_chambre);
        p3.setOpaque(false);
        
        p4 = new JPanel();
        p4.add(retour);
        p4.add(valider);
        p4.setOpaque(false);
        
        // Gestion des boutons
        retour.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
              Admin.getFenetre(f);
          }
        });
        
        valider.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          { 
              // A implémenter
          }
        });
    }
    
    public static Rechercher_chambre getFenetre(JFrame f)
    {
        if(fenetre == null) new Rechercher_chambre(f);
        
        f.setContentPane(new ImagePanel(new ImageIcon("fond66.jpg").getImage())); // Met l'image en background
        f.add(p1);
        f.add(p2);
        f.add(p3);
        f.add(p4);
        
        f.setVisible(true);
        f.setSize(new Dimension(600, 600));
        
        return fenetre;
    }
}
