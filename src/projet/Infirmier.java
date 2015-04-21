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
    private int code_service; // numéro du service dans lequel l'infirmier travaille
    
    // constructeur qui hérite de celui d'employé
    public Infirmier(int num, String nom, String prenom, String adresse, long tel, long sal, boolean type, int numinf, boolean rot, int codeService) {
        super(num, nom, prenom, adresse, tel, sal, type);
        no_infirmier = numinf;
        rotation = rot;
        code_service = codeService;
    }
    
    public int getNoInfirmier()
    {
        return no_infirmier;
    }
    
    public boolean getRotation()
    {
        return rotation;
    }
    
    public int getCodeService()
    {
        return code_service;
    }
}
