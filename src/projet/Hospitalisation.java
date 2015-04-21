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
    
    // CONSTRUCTEUR AVEC ARGUMENTS
    public Hospitalisation(int numMalade, int numchambre, int nblits, long dateA)
            {
                no_malade = numMalade;
                no_chambre = numchambre;
                no_lit = nblits;
                date_arrivee = dateA;
            }
    
    // CONSTRUCEUR SANS ARGUMENTS 
    // JE SAIS PAS SI IL EN FAUT UN EN FAIT ET SI CA DOIT FONCTIONNER COMME CA
    public Hospitalisation()
    {
        no_malade = 0;
        no_chambre = 0;
        no_lit = 0;
        date_arrivee = 0;
    }
    
    public int getNoMalade()
    {
        return no_malade;
    }
    
    public int getNoChambe()
    {
        return no_chambre;
    }
    
    public int getNoLit()
    {
        return no_lit;
    }
    
    public long getDateA()
    {
        return date_arrivee;
    }    
    
}
