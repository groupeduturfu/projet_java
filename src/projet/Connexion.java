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
    ArrayList<String> Liste_requetes_selection = new ArrayList<String>();
    

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
        
        
    /**
    * UTILE si besoin de faire plusieurs requêtes en même temps
    * Méthode privée qui crée un liste à n lignes : n string contenant les requete */
    private void Remplir_Requetes_Selection() 
    {
        Liste_requetes_selection.add("SELECT prenom FROM malade;");
        Liste_requetes_selection.add("SELECT nom FROM malade;");

    }    
    
    /**
    * ESSAI
    */
    private void Afficher_Requetes_Selection()
    {
        // On récupère la taille de la liste de requêtes 
	int count = Liste_requetes_selection.size();
	System.out.println("Count: " + count);        
    }
    


    public String CrerRequete_Recherche_Historique(int id, String nom, 
            String prenom, String adresse, String tel, String date_arrivee, String date_sortie, int no_docteur, String code_service)
    {
        String requete = "initialisee";
        // astuce : quand l'utilisateur ne remplit pas le champs, s'il s'agit d'un champs String on l'intialise avec un %, si c'est un int on ne peut rien faire, d'où les nombreux esle if 

        // si l'utilisateur connait dejà le numéro du malade recherché, on affiche toutes les infos du malade d'apres ce numéro
        // si d'autres infos étaient renseignées, seul le no d'identification est pris en compte
        if (id != 0)
        {
            requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, h.date_arrivee, h.date_sortie, h.no_docteur, "
                       + "h.code_service "
                       + "FROM malade m, historique h WHERE (m.no_malade = h.no_malade AND m.no_malade = " + id + ");";
        }
        
        // si l'utilisateur ne connait ni le numéro du malade, ni le numéro de son docteur
        //on affiche le numéro et les infos des malades correspond aux infos renseignées (que des string)
        else if ((id == 0) && (no_docteur ==0))
        {
            requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, h.date_arrivee, h.date_sortie, h.no_docteur, "
                      + "h.code_service "
                       + "FROM malade m, historique h WHERE (m.no_malade = h.no_malade AND m.nom LIKE '" + nom +
                            "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel + 
                            "' AND h.date_arrivee LIKE '" + date_arrivee + "' AND h.date_sortie LIKE '" + date_sortie + "'"
                    + " AND h.code_service LIKE '" + code_service + "');";
        }
        
        // si l'utilisateur ne connait pas le numéro du malade, mais connait celui de son docteur
        //on affiche le numéro et les infos des malades correspond aux infos renseignées (que des string)
        else if ((id == 0) && (no_docteur !=0))
        {
            requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, h.date_arrivee, h.date_sortie, h.no_docteur, "
                      + "h.code_service "
                       + "FROM malade m, historique h WHERE (m.no_malade = h.no_malade AND m.nom LIKE '" + nom +
                            "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel + 
                            "' AND h.date_arrivee LIKE '" + date_arrivee + "' AND h.date_sortie LIKE '" + date_sortie + "'"
                    + " AND h.no_docteur = " + no_docteur + " AND h.code_service LIKE '" + code_service + "');";
        }
        
        return requete;
    }
    
    
    public String CrerRequete_Recherche_Hospitalisation(int id, String nom, 
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
                        requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.no_chambre, h.no_lit, h.date_arrivee FROM malade m, hospitalisation h "
                                + "WHERE (m.no_malade = h.no_malade AND m.nom LIKE '" + nom +
                            "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel + 
                            "' AND m.mutuelle LIKE '" + mutuelle + "');";
                    }
                    
                    // si l'utilisateur ne connait ni le numéro du malade, ni sa chambre, mais connait son lit
                    // on ajoute le numero du lit dans la recherche
                    else if ((id == 0) && (chambre ==0) && (lit !=0))
                    {
                          requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.no_chambre, h.no_lit, h.date_arrivee FROM malade m, hospitalisation h "
                                  + "WHERE (m.no_malade = h.no_malade AND m.nom LIKE '" + nom +
                            "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel + 
                            "' AND m.mutuelle LIKE '" + mutuelle + "' AND h.date_arrivee LIKE '" + date_arrivee + "' AND h.no_lit = " + lit + ");";  
                    }
                        
                     // si l'utilisateur ne connait ni le numéro du malade, ni son lit, mais connait sa chambre
                    // on ajoute le numero du lit dans la recherche
                    else if ((id == 0) && (chambre !=0) && (lit ==0))
                    {
                          requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.no_chambre, h.no_lit, h.date_arrivee FROM malade m, hospitalisation h "
                                  + "WHERE (m.no_malade = h.no_malade AND m.nom LIKE '" + nom +
                            "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel + 
                            "' AND m.mutuelle LIKE '" + mutuelle + "' AND h.date_arrivee LIKE '" + date_arrivee + "' AND h.no_chambre = " + chambre + ");";  
                    }
                       
                     // si l'utilisateur ne connait pas le numéro du malade mais connait sa chambre et son lit
                    // on ajoute le numero du lit dans la recherche
                    else if ((id == 0) && (chambre !=0) && (lit !=0))
                    {
                          requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.no_chambre, h.no_lit, h.date_arrivee FROM malade m, hospitalisation h WHERE (m.nom LIKE '" + nom +
                            "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel + 
                            "' AND m.mutuelle LIKE '" + mutuelle + "' AND h.date_arrivee LIKE '" + date_arrivee + "' AND h.no_chambre = " + chambre + " AND h.no_lit = " + lit + ");";  
                    }
                    
                    
                    System.out.println("requete envoyee : " + requete);
                   
                                               
        return requete;
        
    }
    
    /*public String Hopsitalisation_CrerRequete( int id, String nom, 
            String prenom, int chambre, int lit, String adresse, String tel, String mutuelle, String date_arrivee)
    {
        
    }
    */
   
    
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
