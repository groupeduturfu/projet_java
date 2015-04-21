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
    
    // attributs de cete classe
    private String nom;
    private String prenom;
    private String adresse;
    private long tel;
    private long salaire;
    private boolean type; // indique si l'employé est un infirmier ou un docteur
}
