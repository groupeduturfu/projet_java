/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import Interface.Fenetre;
import Interface.Login;


/*
 * 
 * Librairies importées
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;


/*
 * 
 * Connexion à notre BDD via le tunnel SSH
 * @author meyronneaudrey
 */
public class Connexion {

    private static Connexion laConnexion = null;
    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private Connection conn;
    private Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;

    /**
     * ArrayList public pour les requêtes de sélection
     */
    public ArrayList<String> Liste_requetes_appartient = new ArrayList<String>();
    public ArrayList<String> Liste_requetes_directeur = new ArrayList<String>();

    private Connexion(String adresse, String password) throws SQLException, ClassNotFoundException // "jdbc:mysql://http://localhost:8888"
    {
        conn = DriverManager.getConnection(adresse, "root", password);
        stmt = conn.createStatement();
        System.out.println("Connexion reussie");

    }

    public static Connexion getInstance(String a, String p) {
        try {
            if (laConnexion == null) {
                laConnexion = new Connexion(a, p);
            }
        } catch (Exception e) {
            System.err.println("getConnexion(): " + e);
            e.printStackTrace();
        }
        return laConnexion;
    }

    private Connexion() throws SQLException, ClassNotFoundException {
        String user = "chebassi";
        String login_DataBase = "chebassi-rw";
        String password_DataBase = "cvKTbS3k";

        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        // url de connexion "jdbc:mysql://localhost:3305/usernameECE"
        //String urlDatabase = "jdbc:mysql://localhost:3305/chebassi";
        // Connexion via le tunnel SSH avec le username et le password ECE
        SSH ssh = new SSH("meyronne", "JSEing2..13");

        if (ssh.connect()) {

            System.out.println("Connexion reussie");

            // On regarde si l'utilisateur à choisi une autre BDD que chebassi
            if (Login.login_tape.equals("") && Login.mdp_tape.equals("")) {
              // il n'a changé les champs donc BBD par défaut
            } else {
                user = Login.login_tape;
                login_DataBase = Login.login_tape + "-rw";
                password_DataBase = Login.mdp_tape;
            }

            //création d'une connexion JDBC à la base
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3305/" + user, login_DataBase, password_DataBase);

            // création d'un ordre SQL (statement)
            stmt = conn.createStatement();

            // ESSAI : initialisation de la liste des requetes de selection 
            //Remplir_Requetes_Selection();
            //Afficher_Requetes_Selection();
            // 
        }
    }

    public synchronized static Connexion getInstance() {
        try {
            if (laConnexion == null) {
                laConnexion = new Connexion();
            }
        } catch (Exception e) {
            System.err.println("getConnexion(): " + e);
            e.printStackTrace();
        }
        return laConnexion;
    }

    /**
     * NE SERA PAS UTILISE * Méthode privée qui ajoute la requete de selection
     * en parametre dans son ArrayList
     *
     * private void AjouterRequete(String requete) {
     * Liste_requetes_selection.add(requete); }
     */
    public String CreerRequete_Recherche_Historique(int id, String nom,
            String prenom, String adresse, String tel, String mutuelle, String date_arrivee, String date_sortie, String nom_docteur, String code_service) {
        String requete = "initialisee";
        // astuce : quand l'utilisateur ne remplit pas le champs, s'il s'agit d'un champs String on l'intialise avec un %, si c'est un int on ne peut rien faire, d'où les nombreux esle if 

        // si l'utilisateur connait dejà le numéro du malade recherché, on affiche toutes les infos du malade d'apres ce numéro
        // si d'autres infos étaient renseignées, seul le no d'identification est pris en compte
        if (id != 0) {
            requete = "SELECT m.no_malade, m.nom, m.prenom, m.adresse, m.tel, m.mutuelle, h.date_arrivee, h.date_sortie, e.nom, h.description, "
                    + "h.code_service "
                    + "FROM malade m, historique h, employe e "
                    + "WHERE (m.no_malade = h.no_malade AND h.no_docteur = e.no_employe AND m.no_malade = " + id + ");";
        } // si l'utilisateur ne connait pas le numéro du malade
        //on affiche le numéro et les infos des malades correspond aux infos renseignées (que des string)
        else {
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
                    + "WHERE (m.no_malade = h.no_malade AND h.no_docteur = e.no_employe AND m.nom LIKE '" + nom + "'AND m.prenom LIKE '" + prenom
                    + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel + "' AND h.date_arrivee LIKE '" + date_arrivee + "' AND h.date_sortie LIKE '"
                    + date_sortie + "' AND h.code_service LIKE '" + code_service + "' AND m.mutuelle LIKE '" + mutuelle + "' AND e.nom LIKE '" + nom_docteur + "');";

        }

        System.out.println("requete envoyee : " + requete);

        return requete;
    }

    public String CreerRequete_Recherche_Hospitalisation(int id, String nom, String prenom, int chambre, int lit, String adresse, String tel, String mutuelle, String date_arrivee) {
        String requete = "initialisee";

            // RECHERCHER UN PATIENT
        // astuce : quand l'utilisateur ne remplit pas le champs, s'il s'agit d'un champs String on l'intialise avec un %, si c'est un int on ne peut rien faire, d'où les nombreux esle if 
        // si l'utilisateur connait dejà le numéro du malade recherché, on affiche toutes les infos du malade d'apres ce numéro
        // si d'autres infos étaient renseignées, seul le no d'identification est pris en compte
        if (id != 0) {
            //requete = "SELECT * FROM malade m WHERE no_malade = " + id + ";";
            requete = "SELECT m.no_malade, m.nom, m.prenom, h.no_chambre, h.no_lit, h.date_arrivee, m.adresse, m.tel, m.mutuelle "
                    + "FROM malade m, hospitalisation h WHERE (m.no_malade = " + id + " AND m.no_malade = h.no_malade);";
        } // si l'utilisateur ne connait ni le numéro du malade, ni sa chambre, ni son lit
        //on affiche le numéro et les infos des malades correspond aux infos renseignées (que des string)
        else if ((id == 0) && (chambre == 0) && (lit == 0)) {
            requete = "SELECT m.no_malade, m.nom, m.prenom, h.no_chambre, h.no_lit, h.date_arrivee, m.adresse, m.tel, m.mutuelle "
                    + "FROM malade m, hospitalisation h "
                    + "WHERE (m.no_malade = h.no_malade AND m.nom LIKE '" + nom
                    + "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel
                    + "' AND m.mutuelle LIKE '" + mutuelle + "');";
        } // si l'utilisateur ne connait ni le numéro du malade, ni sa chambre, mais connait son lit
        // on ajoute le numero du lit dans la recherche
        else if ((id == 0) && (chambre == 0) && (lit != 0)) {
            requete = "SELECT m.no_malade, m.nom, m.prenom, h.no_chambre, h.no_lit, h.date_arrivee, m.adresse, m.tel, m.mutuelle "
                    + "FROM malade m, hospitalisation h "
                    + "WHERE (m.no_malade = h.no_malade AND m.nom LIKE '" + nom
                    + "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel
                    + "' AND m.mutuelle LIKE '" + mutuelle + "' AND h.date_arrivee LIKE '" + date_arrivee + "' AND h.no_lit = " + lit + ");";
        } // si l'utilisateur ne connait ni le numéro du malade, ni son lit, mais connait sa chambre
        // on ajoute le numero du lit dans la recherche
        else if ((id == 0) && (chambre != 0) && (lit == 0)) {
            requete = "SELECT m.no_malade, m.nom, m.prenom, h.no_chambre, h.no_lit, h.date_arrivee, m.adresse, m.tel, m.mutuelle "
                    + "FROM malade m, hospitalisation h "
                    + "WHERE (m.no_malade = h.no_malade AND m.nom LIKE '" + nom
                    + "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel
                    + "' AND m.mutuelle LIKE '" + mutuelle + "' AND h.date_arrivee LIKE '" + date_arrivee + "' AND h.no_chambre = " + chambre + ");";
        } // si l'utilisateur ne connait pas le numéro du malade mais connait sa chambre et son lit
        // on ajoute le numero du lit dans la recherche
        else if ((id == 0) && (chambre != 0) && (lit != 0)) {
            requete = "SELECT m.no_malade, m.nom, m.prenom, h.no_chambre, h.no_lit, h.date_arrivee, m.adresse, m.tel, m.mutuelle "
                    + "FROM malade m, hospitalisation h WHERE (m.nom LIKE '" + nom
                    + "' AND m.prenom LIKE '" + prenom + "' AND m.adresse LIKE '" + adresse + "' AND m.tel LIKE '" + tel
                    + "' AND m.mutuelle LIKE '" + mutuelle + "' AND h.date_arrivee LIKE '" + date_arrivee + "' AND h.no_chambre = " + chambre + " AND h.no_lit = " + lit + ");";
        }

        System.out.println("requete envoyee : " + requete);

        return requete;

    }

    private void ajouterRequete_appartient_creer(String requete) {
        Liste_requetes_appartient.add(requete);
    }

    public String CreerRequete_employe(String nom, String prenom, String adresse, String tel, int salaire, String fonction, String d_naissance) {
        String requete = "initialisee";
        requete = "INSERT INTO employe (nom, prenom, adresse, tel, salaire, fonction, date_naissance) values ('" + nom + "', '" + prenom + "', '" + adresse + "', '" + tel + "', " + salaire + ", '" + fonction + "', '" + d_naissance + "');";
        System.out.println(requete);

        return requete;
    }

    public String CreerRequete_malade(String nom, String prenom, String adresse, String tel, String mutuelle, String date_naissance) {
        String requete = "initialisee";
        requete = "INSERT INTO malade (nom, prenom, adresse, tel, mutuelle, date_naissance) values ('" + nom + "', '" + prenom + "', '" + adresse + "', '" + tel + "', '" + mutuelle + "', '" + date_naissance + "');";
        System.out.println(requete);

        return requete;
    }

    public String CreerRequete_recup_id(int no_requete, String nom, String prenom, String tel) {
        // requete à renvoyer
        String requete = "initialisee";

        switch (no_requete) {
            // récupérer le numéro d'un patient créé
            case 1:
                requete = "SELECT no_malade FROM malade ORDER BY no_malade DESC LIMIT 1 OFFSET 0;";
                System.out.println(requete);
                break;
            // récupérer le no emloye du medecin/infirmier créé
            case 2:
                requete = "SELECT no_employe FROM employe ORDER BY no_employe DESC LIMIT 1 OFFSET 0;";
                System.out.println(requete);
                break;
        }

        return requete;
    }

    public String CreerRequete_recup_id_docteur(String nom_docteur) {
        // requete à renvoyer
        String requete = "initialisee";
        requete = "SELECT e.no_employe FROM employe e, docteur d WHERE (e.no_employe = d.no_docteur AND e.nom LIKE '" + nom_docteur + "');";

        System.out.println(requete);

        return requete;
    }

    public String CreerRequete_docteur_infirmier(int no_fonction, int id, String specialite, String code_service, String rotation) {
        // requete qui enregistre le docteur ou l'infimier dans la table correspondante
        String requete = "initialisee";

        switch (no_fonction) {
            // si docteur
            case 1:
                requete = "INSERT INTO docteur values (" + id + ", '" + specialite + "');";
                System.out.println(requete);
                break;

            // si infirmier
            case 2:
                requete = "INSERT INTO infirmier values (" + id + ", '" + code_service + "', '" + rotation + "');";
                System.out.println(requete);
                break;
        }

        return requete;
    }

    public String CreerRequete_hospitalisation(int id, int chambre, int lit, int no_docteur, String service) {
        String requete = "initialisee";
        requete = "INSERT INTO hospitalisation (no_malade, no_chambre, no_lit, no_docteur, code_service) values (" + id + ", " + chambre + ", " + lit + ", " + no_docteur + ",  '" + service + "');";
        System.out.println(requete);

        return requete;
    }

    public ArrayList Requete_chambre_dispo_surveillant(String rotation, String code_service) {
        ArrayList<String> liste = null;

        try {
                       //System.out.println("chambres sans surveillant jour" + RemplirChampsRequete("SELECT code_service, no_chambre FROM chambre WHERE ( no_surveillant_jour = 0);"));
            //System.out.println("chambres sans surveillant nuit" + RemplirChampsRequete("SELECT code_service, no_chambre FROM chambre WHERE ( no_surveillant_nuit = 0);"));
            System.out.println("" + rotation);
            System.out.println("" + code_service);

            // on renvoie les chambres disponibles à la surveillance dans ce service
            if (rotation == "JOUR") {
                liste = RemplirChampsRequete("SELECT no_chambre FROM chambre WHERE (code_service LIKE '" + code_service + "' AND no_surveillant_jour = 0);");
            } else if (rotation == "NUIT") {
                liste = RemplirChampsRequete("SELECT no_chambre FROM chambre WHERE (code_service LIKE '" + code_service + "' AND no_surveillant_nuit = 0);");
            }

        } catch (SQLException ex) {
            System.out.println("Echec SQL");
            ex.printStackTrace();
        }

        return liste;
    }

    /*
     public String CreerRequete_surveillant(int no_infirmier, String rotation, String code_service, int no_chambre)
     {
     String requete = null;
        
     if (rotation == "JOUR")
     {
            
     requete = "UPDATE chambre SET no_surveillant_jour = " + no_infirmier + " WHERE (code_service LIKE '" + code_service + "' AND no_chambre = " + no_chambre + ");";
            
     try {
     System.out.println("chambres sans surveillant jour" + RemplirChampsRequete("SELECT code_service, no_chambre FROM chambre WHERE ( no_surveillant_jour = 0);"));
     System.out.println("chambres sans surveillant nuit" + RemplirChampsRequete("SELECT code_service, no_chambre FROM chambre WHERE ( no_surveillant_nuit = 0);"));

     // on renvoie les chambres disponibles à la surveillance dans ce service
     if (rotation == "JOUR") {
     System.out.println("rentre dans jour");
     liste = RemplirChampsRequete("SELECT no_chambre FROM chambre WHERE (code_service LIKE '" + code_service + "' AND no_surveillant_jour = 0);");
     } else if (rotation == "NUIT") {
     System.out.println("rentre dans nuit");
     liste = RemplirChampsRequete("SELECT no_chambre FROM chambre WHERE (code_service LIKE '" + code_service + "' AND no_surveillant_nuit = 0);");
     }

     } catch (SQLException ex) {
     System.out.println("Echec SQL");
     ex.printStackTrace();
     }

     return liste;
     }

     */
    public String CreerRequete_surveillant(int no_infirmier, String rotation, String code_service, int no_chambre) {
        String requete = null;

        if (rotation == "JOUR") {

            requete = "UPDATE chambre SET no_surveillant_jour = " + no_infirmier + " WHERE (code_service LIKE '" + code_service + "' AND no_chambre = " + no_chambre + ");";
        } else if (rotation == "NUIT") {
            requete = "UPDATE chambre SET no_surveillant_nuit = " + no_infirmier + " WHERE (code_service LIKE '" + code_service + "' AND no_chambre = " + no_chambre + ");";
        }

        return requete;
    }

    public void docteurs_requetes_appartient(JCheckBox jch_ORL, JCheckBox jch_REA, JCheckBox jch_CHG, int no_docteur) {
        // on supprime toutes les requêtes restées en mémoire dans la liste
        Liste_requetes_directeur.clear();

        // services sélectionnés
        if (jch_ORL.isSelected()) {
            ajouterRequete_appartient_creer("INSERT INTO appartient VALUES (" + no_docteur + ", 'ORL');");
        }
        if (jch_REA.isSelected()) {
            ajouterRequete_appartient_creer("INSERT INTO appartient VALUES (" + no_docteur + ", 'REA');");
        }
        if (jch_CHG.isSelected()) {
            ajouterRequete_appartient_creer("INSERT INTO appartient VALUES (" + no_docteur + ", 'CHG');");
        }

        // executer la liste de requetes
        System.out.println("nb check boxes : " + Liste_requetes_appartient.size());

        int i;
        for (i = 0; i < Liste_requetes_appartient.size(); i++) {
            try {
                this.executeUpdate(Liste_requetes_appartient.get(i));
            } catch (SQLException ex) {
                System.out.println("Echec SQL");
                ex.printStackTrace();
            }
            System.out.println("" + Liste_requetes_appartient.get(i));
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
    public void executeUpdate(String requete) throws SQLException {
        stmt.executeUpdate(requete);
    }

    public String RecupererId(String requete) throws SQLException {

        String id = "NotExist";

        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();

        while (rset.next()) {
            id = rset.getString(1);
        }

        return id;
    }

    /**
     * Methode qui retourne l'ArrayList réponse à la requête en parametre
     */
    public ArrayList RemplirChampsRequete(String requete) throws SQLException {
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
                champs = champs + "," + rset.getString(i + 1);
            }

            // ajouter un "\n" à la ligne des champs
            champs = champs + "\n";

            // ajouter les champs de la ligne dans l'ArrayList
            liste.add(champs);
        }

        // Retourner l'ArrayList
        return liste;
    }

    public ArrayList RemplirChampsRequete_Malade(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        // creation d'une ArrayList de String
        ArrayList<ArrayList<String>> liste;
        liste = new ArrayList<ArrayList<String>>();
        ArrayList<String> ligne;
        ligne = new ArrayList<String>();
        int j = 0;
        String champs;
        // tant qu'il reste une ligne 
        while (rset.next()) {
            System.out.println("" + j);
            // Concatener les champs de la ligne separes par 
            for (int i = 1; i < nbColonne + 1; i++) {
                System.out.println("" + i);
                champs = rset.getString(i);
                ligne.add(champs);

                liste.add(ligne);
                j++;
            }

        }
        // Retourner l'ArrayList
        return liste;
    }

    
    /**
     * Requete renvoyant le nombre de malade dans un service donné recu en parametre
     * @param service
     * @return int
     */
    public int nb_malade_services(String service) {

        int i = 0;

        // récupération de l'ordre de la requete
        try {
            rset = stmt.executeQuery("SELECT COUNT( * ) FROM hospitalisation WHERE hospitalisation.code_service=" + service);
            if (rset.next()) {
                i = rset.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i;
    }

    /**
     * Requete renvoyant la valeur moyenne des salaires de tous les docteurs de l'hopital
     * @return float
     */
    public Float moyenne_salaired() {
        Float i = null;
        try {
            rset = stmt.executeQuery("SELECT AVG (salaire) FROM employe WHERE fonction LIKE 'docteur'");
            if (rset.next()) {
                i = rset.getFloat(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i;
    }

    /**
     * Requete renvoyant la valeur moyenne des salaires de tous les infirmiers de l'hopital
     * @return float 
     */
    public float moyenne_salairei() {
        float i = 0;
        try {
            rset = stmt.executeQuery("SELECT AVG (salaire) FROM employe WHERE fonction LIKE 'infirmier'");
            if (rset.next()) {
                i = rset.getFloat(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i;
    }

    /**
     * Requete renvoyant la valeur moyenne des salaires de tous les employés de l'hopital
     * @return float
     */
    public float moyenne_salaire() {
        float i = 0;
        try {
            rset = stmt.executeQuery("SELECT AVG (salaire) FROM employe");
            if (rset.next()) {
                i = rset.getFloat(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
        }

        return i;
    }

    public String CreerRequete_Check_lit_chambre(int chambre, int lit) {
        String requete = "initialisee";
        requete = "SELECT * FROM hospitalisation WHERE no_chambre=" + chambre + " AND no_lit=" + lit + ";";
        System.out.println(requete);

        return requete;
    }

    public void docteurs_requetes_directeur(JCheckBox jch_Dir_ORL, JCheckBox jch_Dir_REA, JCheckBox jch_Dir_CHG, int no_docteur) {
        // on supprime toutes les requêtes restées en mémoire dans la liste
        Liste_requetes_directeur.clear();

        // directeurs sélectionnés
        if (jch_Dir_ORL.isSelected()) {
            ajouterRequete_directeur_creer("UPDATE service SET no_directeur = " + no_docteur + " WHERE code_service LIKE 'ORL';");
        }
        if (jch_Dir_REA.isSelected()) {
            ajouterRequete_directeur_creer("UPDATE service SET no_directeur = " + no_docteur + " WHERE code_service LIKE 'REA';");
        }
        if (jch_Dir_CHG.isSelected()) {
            ajouterRequete_directeur_creer("UPDATE service SET no_directeur = " + no_docteur + " WHERE code_service LIKE 'CHG';");
        }

        // executer la liste de requetes
        System.out.println("nb check boxes : " + Liste_requetes_directeur.size());

        int i;
        for (i = 0; i < Liste_requetes_directeur.size(); i++) {
            try {
                this.executeUpdate(Liste_requetes_directeur.get(i));
            } catch (SQLException ex) {
                System.out.println("Echec SQL");
                ex.printStackTrace();
            }
            System.out.println("" + Liste_requetes_directeur.get(i));
        }

    }

    private void ajouterRequete_directeur_creer(String requete) {
        Liste_requetes_directeur.add(requete);
    }

    public ArrayList Requete_chambre_dans_service(String service) {
        ArrayList<String> liste = null;

        try {
            System.out.println("service selectionné : " + service);

            // on renvoie les chambres appartenant à ce service
            liste = RemplirChampsRequete("SELECT no_chambre FROM chambre WHERE (code_service LIKE '" + service + "');");

        } catch (SQLException ex) {
            System.out.println("Echec SQL");
            ex.printStackTrace();
        }

        return liste;
    }
    
    public ArrayList Requete_lits_dans_chambre(int chambre, String service) {
        ArrayList<String> liste = new ArrayList<String>() ;

        
        
        try {
            System.out.println("chambre selectionnée : " + chambre);

            // on renvoie les lits déjà pris dans cette chambre
            liste = RemplirChampsRequete("SELECT no_lit FROM hospitalisation WHERE no_chambre=" + chambre + " AND code_service LIKE '" + service + "';");

        } catch (SQLException ex) {
            System.out.println("Echec SQL");
            ex.printStackTrace();
        }
        
        for (int k = 0; k < liste.size(); k++) 
                    {
                        System.out.println("k : " + liste.get(k));
                    }
        return liste;
    }

    /**
     * Sous programme qui interroge la BDD sur le nombre d'intervention par 
     * doteur
     * Il renvoie une liste de médecins et leurs nombre d'interventions
     * @param requete
     * @return
     * @throws SQLException 
     */
    public ArrayList<ArrayList> reporting(String requete) throws SQLException {
        // récupération de l'ordre de la requete
        rset = stmt.executeQuery(requete);

        // récupération du résultat de l'ordre
        rsetMeta = rset.getMetaData();
        // calcul du nombre de colonnes du resultat
        int nbColonne = rsetMeta.getColumnCount();
        // creation d'une ArrayList de String et une de int
        ArrayList<Integer> nb = new ArrayList<Integer>();
        ArrayList<String> nom = new ArrayList<String>();
        ArrayList<ArrayList> liste = new ArrayList<ArrayList>();
        // tant qu'il reste une ligne 
        while (rset.next()) {
            // Concatener les champs de la ligne separes par 
            nom.add(rset.getString(1));
            nb.add(rset.getInt(2));

            liste.add(nom);
            liste.add(nb);
        }

        // Retourner l'ArrayList
        return liste;
    }

}
