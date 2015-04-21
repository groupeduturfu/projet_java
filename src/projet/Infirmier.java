/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

/**
 * Découlant de la classe Employé, cette classe définit les particularités 
 * d'un infirmier, différentes donc d'un docteur. 
 * 
 * @author maurinco
 */
public class Infirmier extends Employe { 
    private int no_infirmier; // identifie l'infirmier
    
    private boolean rotation; // prendra soit la valeur JOUR soit la valeur NUIT
    private int no_chambre; // numéro de la chambre qu'il surveille
    private int code_service; // numéro du service dans lequel l'infirmier travaille
    
    // constructeur qui hérite de celui d'employé
    public Infirmier(int num, String nom, String prenom, String adresse, long tel, long sal, boolean type) {
        super(num, nom, prenom, adresse, tel, sal, type);
    }
    
    public int getNoInfirmier()
    {
        return no_infirmier;
    }
    
    public boolean getRotation()
    {
        return rotation;
    }
    
    public int getNoChambre()
    {
        return no_chambre;
    }
    
    public int getCodeService()
    {
        return code_service;
    }
}
