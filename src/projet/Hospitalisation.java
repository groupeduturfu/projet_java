/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

/**
 * Cette classe est visible à l'instant t, 
 * lorsque le patient est en train de subir une hospitalisation.
 * Elle disparait à partir du moment où le patient sort de lhôpital.
 * 
 * @author maurinco
 */
public class Hospitalisation {
    private int no_malade; // identifie le patient dont l'hospitalisation est question
    
    private int no_chambre;
    private int no_lit; 
    private long date_arrivee;
    
}
