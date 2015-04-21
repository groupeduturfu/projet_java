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
    private boolean rotation; // prendra soit la valeur JOUR soit la valeur NUIT
    private int no_infirmier;
    private int no_chambre; // numéro de la chambre qu'il surveille
    private int code_service; 
}
