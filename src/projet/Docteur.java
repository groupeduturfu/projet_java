/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

/**
 * Découlant de la classe Employé, cette classe définit les particularités 
 * d'un docteur, différentes donc d'un infirmier. 
 * 
 * @author maurinco
 */
public class Docteur extends Employe { 
    private int no_docteur; // identifie le docteur
    
    private String specialite;
    
    // constructeur qui hérite de celui d'employé
    public Docteur(int num, String nom, String prenom, String adresse, long tel, long sal, boolean type, int numDoc, String spec) {
        super(num, nom, prenom, adresse, tel, sal, type);
        no_docteur = numDoc;
        specialite = spec;
    }
    
    public int getNoDocteur()
    {
        return no_docteur;
    }
    
    public String getSpecialite()
    {
        return specialite;
    }
}
