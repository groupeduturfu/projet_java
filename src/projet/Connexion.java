/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;
import Interface.Fenetre;


/*
 * 
 * Librairies importées
 */
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


/*
 * 
 * Connexion à notre BDD via le tunnel SSH
 * @author meyronneaudrey
 */
public class Connexion 
{
    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat requete
     */
    private Connection conn;
    private Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    
    /**
     * ArrayList public pour les requêtes de sélection
     */
    public ArrayList<String> Liste_requetes = new ArrayList<String>();
    

    public Connexion() throws SQLException, ClassNotFoundException 
    {
        //String user = "chebassi";
        //String login_DataBase = "chebassi-rw";
        //String password_DataBase = "cvKTbS3k";        
        
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        //String urlDatabase = "jdbc:mysql://localhost:3305/chebassi";

        
        // Connexion via le tunnel SSH avec le username et le password ECE
        SSH ssh = new SSH("meyronne", "JSEing2..13");

        
        if (ssh.connect()) 
        {
            
            System.out.println("Connexion reussie");

        //création d'une connexion JDBC à la base
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/chebassi","chebassi-rw", "cvKTbS3k");

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();

                
        // ESSAI : initialisation de la liste des requetes de selection 
        //Remplir_Requetes_Selection();
        //Afficher_Requetes_Selection();
        // 
        }
    }
    
    
    
    
    /**
    * NE SERA PAS UTILISE *
    * Méthode privée qui ajoute la requete de selection en parametre dans son ArrayList
    
    private void AjouterRequete(String requete) 
    {
        Liste_requetes_selection.add(requete);
    }*/


    

    

    public String CreerRequete_Recherche_Historique(int id, String nom, 
            String prenom, String adresse, String tel, String mutuelle, String date_arrivee, String date_sortie, String nom_docteur, String code_service)
    {
        String requete = "initialisee";
        // astuce : quand l'utilisateur ne remplit pas le champs, s'il s'agit d'un champs String on l'intialise avec un %, si c'est un int on ne peut rien faire, d'où les nombreux esle if 

        // si l'utilisateur connait dejà le numéro du malade recherché, on affiche toutes les infos du malade d'apres ce numéro
        // si d'autres infos étaient renseignées, seul le no d'identification est pris en compte
        if (id != 0)
        {
            requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.date_arrivee, h.date_sortie, e.nom, h.description, "
                       + "h.code_service "
                       + "FROM malade m, historique h, employe e "
                       + "WHERE (m.no_malade = h.no_malade AND h.no_docteur = e.no_employe AND m.no_malade = " + id + ");";
        }
        
        // si l'utilisateur ne connait pas le numéro du malade
        //on affiche le numéro et les infos des malades correspond aux infos renseignées (que des string)
        else 
        {
            /*
            requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.date_arrivee, h.date_sortie, e.nom, h.description, "
                      + "h.code_service "
                      + "FROM malade m, historique h, employe e, docteur d"
                      + "WHERE ( m.nom LIKE '" + nom +
                            "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel + 
                            "' AND h.date_arrivee LIKE '" + date_arrivee + "' AND h.date_sortie LIKE '" + date_sortie + "'"
                    + " AND h.code_service LIKE '" + code_service + "' AND m.mutuelle LIKE '" + mutuelle + 
                    "' AND e.no_emloye LIKE '" + nom_docteur + "' AND m.no_malade=h.no_malade AND h.no_docteur = d.no_docteur AND d.no_docteur=e.no_employe);";
  */
            requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.date_arrivee, h.date_sortie, e.nom, h.description, "
                       + "h.code_service "
                       + "FROM malade m, historique h, employe e "
                       + "WHERE (m.no_malade = h.no_malade AND h.no_docteur = e.no_employe AND m.nom LIKE '" + nom + "'AND m.prenom LIKE '" + prenom + 
                    "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel + "' AND h.date_arrivee LIKE '" + date_arrivee + "' AND h.date_sortie LIKE '" 
                    + date_sortie + "' AND h.code_service LIKE '" + code_service + "' AND m.mutuelle LIKE '" + mutuelle + "' AND e.nom LIKE '" + nom_docteur + "');";
  
        }
 
        System.out.println("requete envoyee : " + requete);

        return requete;
    }
    
    
    public String CreerRequete_Recherche_Hospitalisation(int id, String nom, 
            String prenom, int chambre, int lit, String adresse, String tel, String mutuelle, String date_arrivee)
    {
        String requete = "initialisee";

        
            // RECHERCHER UN PATIENT
            // astuce : quand l'utilisateur ne remplit pas le champs, s'il s'agit d'un champs String on l'intialise avec un %, si c'est un int on ne peut rien faire, d'où les nombreux esle if 
                    
                    // si l'utilisateur connait dejà le numéro du malade recherché, on affiche toutes les infos du malade d'apres ce numéro
                    // si d'autres infos étaient renseignées, seul le no d'identification est pris en compte
                    if (id != 0)
                    {
                        //requete = "SELECT * FROM malade m WHERE no_malade = " + id + ";";
                        requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.no_chambre, h.no_lit, h.date_arrivee "
                                + "FROM malade m, hospitalisation h WHERE (m.no_malade = " + id + " AND m.no_malade = h.no_malade);";
                    }
                            
                    // si l'utilisateur ne connait ni le numéro du malade, ni sa chambre, ni son lit
                    //on affiche le numéro et les infos des malades correspond aux infos renseignées (que des string)
                    else if ((id == 0) && (chambre ==0) && (lit ==0))
                    {
                        requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.no_chambre, h.no_lit, h.date_arrivee "
                                + "FROM malade m, hospitalisation h "
                                + "WHERE (m.no_malade = h.no_malade AND m.nom LIKE '" + nom +
                            "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel + 
                            "' AND m.mutuelle LIKE '" + mutuelle + "');";
                    }
                    
                    // si l'utilisateur ne connait ni le numéro du malade, ni sa chambre, mais connait son lit
                    // on ajoute le numero du lit dans la recherche
                    else if ((id == 0) && (chambre ==0) && (lit !=0))
                    {
                          requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.no_chambre, h.no_lit, h.date_arrivee "
                                  + "FROM malade m, hospitalisation h "
                                  + "WHERE (m.no_malade = h.no_malade AND m.nom LIKE '" + nom +
                            "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel + 
                            "' AND m.mutuelle LIKE '" + mutuelle + "' AND h.date_arrivee LIKE '" + date_arrivee + "' AND h.no_lit = " + lit + ");";  
                    }
                        
                     // si l'utilisateur ne connait ni le numéro du malade, ni son lit, mais connait sa chambre
                    // on ajoute le numero du lit dans la recherche
                    else if ((id == 0) && (chambre !=0) && (lit ==0))
                    {
                          requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.no_chambre, h.no_lit, h.date_arrivee "
                                  + "FROM malade m, hospitalisation h "
                                  + "WHERE (m.no_malade = h.no_malade AND m.nom LIKE '" + nom +
                            "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel + 
                            "' AND m.mutuelle LIKE '" + mutuelle + "' AND h.date_arrivee LIKE '" + date_arrivee + "' AND h.no_chambre = " + chambre + ");";  
                    }
                       
                     // si l'utilisateur ne connait pas le numéro du malade mais connait sa chambre et son lit
                    // on ajoute le numero du lit dans la recherche
                    else if ((id == 0) && (chambre !=0) && (lit !=0))
                    {
                          requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.no_chambre, h.no_lit, h.date_arrivee "
                                  + "FROM malade m, hospitalisation h WHERE (m.nom LIKE '" + nom +
                            "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel + 
                            "' AND m.mutuelle LIKE '" + mutuelle + "' AND h.date_arrivee LIKE '" + date_arrivee + "' AND h.no_chambre = " + chambre + " AND h.no_lit = " + lit + ");";  
                    }
                    
                    
                    System.out.println("requete envoyee : " + requete);
                   
                                               
        return requete;
        
    }
    
    private void ajouterRequete_creer(String requete)
    {
        Liste_requetes.add(requete);
    }  
    
    
    
    public String CreerRequete_employe(String nom, String prenom, String adresse, String tel, int salaire, String fonction, String d_naissance)
    {
        String requete = "initialisee";
        requete = "INSERT INTO employe (nom, prenom, adresse, tel, salaire, fonction, date_naissance) values ('" + nom + "', '" + prenom + "', '" + adresse + "', '" + tel + "', " + salaire + ", '" + fonction + "', '" + d_naissance + "');";
        System.out.println(requete);
        
        return requete;
    }
    
    public String CreerRequete_malade(String nom, String prenom, String adresse, String tel, String mutuelle, String date_naissance)
    {
        String requete = "initialisee";
        requete = "INSERT INTO malade (nom, prenom, adresse, tel, mutuelle, date_naissance) values ('" + nom + "', '" + prenom + "', '" + adresse + "', '" + tel + "', '" + mutuelle + "', '" + date_naissance + "');";
        System.out.println(requete);
        
        return requete;
    }
    
    public String CreerRequete_recup_id(int no_requete, String nom, String prenom, String tel)
    {
        // requete à renvoyer
        String requete = "initialisee";
        
        switch (no_requete)
        {
            // récupérer le numéro d'un patient créé
            case 1 :
                    requete = "SELECT no_malade FROM malade ORDER BY no_malade DESC LIMIT 1 OFFSET 0;";
                    System.out.println(requete);
                break ;
            // récupérer le no emloye du medecin/infirmier créé
            case 2 :
                    requete = "SELECT no_employe FROM employe ORDER BY no_employe DESC LIMIT 1 OFFSET 0;";
                    System.out.println(requete);
                break;
        }
        

        return requete;
    }
    
    public String CreerRequete_recup_id_docteur(String nom_docteur)
    {
        // requete à renvoyer
        String requete = "initialisee";
        requete = "SELECT e.no_employe FROM employe e, docteur d WHERE (e.no_employe = d.no_docteur AND e.nom LIKE '" + nom_docteur + "');";
    
        System.out.println(requete);
        
        return requete;
    }
    
    
    public String CreerRequete_docteur_infirmier(int no_fonction, int id, String specialite, String code_service, String rotation)
    {
        // requete qui enregistre le docteur ou l'infimier dans la table correspondante
        String requete = "initialisee";

        
        switch (no_fonction)
        {
            // si docteur
            case 1 :
                    requete = "INSERT INTO docteur values (" + id + ", '" + specialite + "');";
                    System.out.println(requete);
                break ;
                
            // si infirmier
            case 2 : 
                    requete = "INSERT INTO infirmier values (" + id + ", '" + code_service + "', '" + rotation + "');";
                    System.out.println(requete);
                break ;
        }

        
        return requete;
    }
    
    public String CreerRequete_hospitalisation(int id, int chambre, int lit, int no_docteur)
    {
        String requete = "initialisee";
        requete = "INSERT INTO hospitalisation (no_malade, no_chambre, no_lit, no_docteur) values (" + id + ", " + chambre + ", " + lit + ", " + no_docteur + ");";
        System.out.println(requete);
        
        return requete;
    }
    
    public ArrayList Requete_chambre_dispo_surveillant(String rotation, String code_service)
    {
            ArrayList<String> liste =null;

                    try 
                    {
                       // on renvoie les chambres disponibles à la surveillance dans ce service
                       if (rotation == "JOUR") 
                       {
                            liste  = RemplirChampsRequete("SELECT no_chambre FROM chambre WHERE (code_service LIKE '" + code_service + "' AND no_surveillant_jour IS NULL);");
                       }
                       else if (rotation == "NUIT") 
                       {
                            liste  = RemplirChampsRequete("SELECT no_chambre FROM chambre WHERE (code_service LIKE '" + code_service + "' AND no_surveillant_nuit IS NULL);");
                       }
                        
                    }
                     catch (SQLException ex)
                    {
                         System.out.println("Echec SQL");
                        ex.printStackTrace();
                    }
                    
                return liste;
    }
    
    
    public String CreerRequete_surveillant(int no_infirmier, String rotation, String code_service, int no_chambre)
    {
        String requete = null;
        
        if (rotation == "JOUR")
        {
            requete = "INSERT into chambre (no_surveillant_jour) values (no_infirmier) WHERE (code_service LIKE '" + code_service + "' AND no_chambre = " + no_chambre + ");";
        }
        else if (rotation == "NUIT")
        {
            requete = "INSERT into chambre (no_surveillant_nuit) values (no_infirmier) WHERE (code_service LIKE '" + code_service + "' AND no_chambre = " + no_chambre + ");";
        }
        
        return requete;
    }
    
    public void docteurs_requetes_services(JCheckBox jch_ORL, JCheckBox jch_REA, JCheckBox jch_CHG, int no_docteur)
    {
        if (jch_ORL.isSelected())
        {
            ajouterRequete_creer("INSERT INTO appartient VALUES (" + no_docteur + ", 'ORL');");

        }
        if (jch_REA.isSelected())
        {
            ajouterRequete_creer("INSERT INTO appartient VALUES (" + no_docteur + ", 'REA');");
            
        }
        if (jch_CHG.isSelected())
        {
            ajouterRequete_creer("INSERT INTO appartient VALUES (" + no_docteur + ", 'CHG');");     
        }
        
        
            // executer la liste de requetes
                    System.out.println("nb check boxes : " + Liste_requetes.size() );

        int i;
        for (i = 0; i<Liste_requetes.size(); i++)
        {
            try
            {
               this.executeUpdate(Liste_requetes.get(i));
            }
            catch (SQLException ex)
            {
                System.out.println("Echec SQL");
                ex.printStackTrace();
            }
            System.out.println("" + Liste_requetes.get(i));
        }
                
    }
    /*
    public void CreerRequete_CreerPatient(String nom, String prenom, int chambre, int lit, String adresse, String tel, String mutuelle)
    {
        // on cree les deux Strings
        String requete_malade = "initialisee";
        requete_malade = "INSERT INTO malade (nom, prenom, adresse, tel, mutuelle) values ('" + nom + "', '" + prenom + "', '" + adresse + "', '" + tel + "', '" + mutuelle + "');";
        System.out.println(requete_malade);
        
        String requete_hopsitalisation = "initialisee";
        //requete_hopsitalisation = "INSERT INTO hospitalisation values (SELECT no_malade FROM malade WHERE (nom LIKE '" + nom + "' AND prenom LIKE '" + prenom + "' AND tel LIKE '" + tel + "')," + chambre + "," + lit + ");";
        
        requete_hopsitalisation = "INSERT INTO hospitalisation (no_malade, no_chambre, no_lit) values (13," + chambre + "," + lit + ");";

        System.out.println(requete_hopsitalisation);

        // on les ajoute dans la liste
        ajouterRequete_creer(requete_malade);
        ajouterRequete_creer(requete_hopsitalisation);
        
    }
   */
    
    public void executeUpdate(String requete) throws SQLException
    {
         stmt.executeUpdate(requete);
    }
    
    public String RecupererId(String requete) throws SQLException 
    {
        
        String id="101";
        
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
        
        while (rset.next()) 
        {
            id = rset.getString(1);
        }
                
        return id;
    }
    
    
    
    /**
     * Methode qui retourne l'ArrayList réponse à la requête en parametre 
     */
    public ArrayList RemplirChampsRequete(String requete) throws SQLException 
    {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();

        // creation d'une ArrayList de String
        ArrayList<String> liste;
        liste = new ArrayList<String>();

        // tant qu'il reste une ligne 
        while (rset.next()) {
            String champs;
            champs = rset.getString(1); // ajouter premier champ

            // Concatener les champs de la ligne separes par ,
            for (int i = 1; i < nbColonne; i++) {
                champs = champs + "," + rset.getString(i+1);
            }

            // ajouter un "\n" à la ligne des champs
            champs = champs + "\n";

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(champs);
        }

        // Retourner l'ArrayList
        return liste;
    }
     
}
