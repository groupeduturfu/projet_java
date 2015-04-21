/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

/**
 * Cette classe répertorie toutes les informations nécéssaires d'un employé. 
 * Il existe 2 types d'employés, qui vont d'ailleurs hériter de cette classe : 
 * Docteur et Infirmier.
 * 
 * @author maurinco
 */
public class Employe {
    protected int no_employe; // identifie l'employé
    
    // attributs de cete classe
    protected String nom_employe;
    protected String prenom_employe;
    protected String adresse_employe;
    protected long tel_employe;
    protected long salaire_employe;
    protected boolean type_employe; // indique si l'employé est un infirmier ou un docteur
    
    // CONSRUCTEUR
    public Employe(int num, String nom, String prenom, String adresse, long tel, long sal, boolean type)
    {
        no_employe = num;
        nom_employe = nom;
        prenom_employe = prenom;
        adresse_employe = adresse;
        tel_employe = tel;
        salaire_employe = sal;
        type_employe = type; 
    }
    
    /// TOUS LES GETTERS
    public int getNoEmploye() 
    {
        return no_employe;
    }
    
    public String getNomEmploye()
    {
        return nom_employe;
    }
    
    public String getPrenomEmploye()
    {
        return prenom_employe;
    }
    
    public String getAdresseEmployee()
    {
        return adresse_employe;
    }   
    
    public long getNumEmploye()
    {
        return tel_employe;
    }
    
    public long salaireEmploye()
    {
        return salaire_employe;
    }
    
    public boolean getTpeEmploye()
    {
        return type_employe;
    }
            
}
