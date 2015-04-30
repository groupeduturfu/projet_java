/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

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
