/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Cette classe est utilisée lorsque l'utilisateur souhaite choisir la BDD en 
 * ligne sur laquelle il souhaite se connecter
 * @author mathieuchebassier
 */
public class Login {
    public static String mdp_tape = "";
    public static String login_tape = "";
    public Login(JFrame f)
    {
       JPanel p = new JPanel();
        JLabel l = new JLabel("Login :");
        JLabel m = new JLabel("Mot de Passe :");
        JPasswordField mdp = new JPasswordField(10);
        JTextField login= new JTextField(10);
        
        ArrayList<String> liste = new ArrayList();
                 
        p.add(l);
        p.add(login);
        p.add(m);
        p.add(mdp);
        String[] options = new String[]{"OK", "Retour"};
        int option = JOptionPane.showOptionDialog(null, p, "Mot de passe",
                                 JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                 null, options, options[1]);
        if(option == 0) // Boutton OK
        {
            mdp_tape  = mdp.getText();
            login_tape = login.getText();
            
            liste.add(mdp_tape);
            liste.add(login_tape);
            
            if(mdp_tape.equals("") && login_tape.equals(""))
            {
                
                new Login(f);
            }
        }
        else new Choix_connexion(f); // Retour
    }
}
