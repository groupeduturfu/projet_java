/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

/**
 * Cette classe détermine les informatiosn de chaque chambre d'un service.
 * @author maurinco
 */
public class Chambre {
    private int no_chambre; // identifie la chambre 
    
    private int nb_lits;
    private int code_service; // indique dans quel service est cette chambre
    private int no_surveillant;
    
    // Constructeur
    public Chambre(int numChambre, int nblits, int code, int numSurveillant)
    {
        no_chambre = numChambre; 
        nb_lits = nblits;
        code_service = code;
        no_surveillant = numSurveillant;
    }
    
    // TOUS LES GETTERS
    private int getNoChambre()
    {
        return no_chambre;
    }
    
    private int getNbLits()
    {
        return nb_lits;
    }
    
    private int getCodeService()
    {
        return code_service;
    }
    
    private int getNoSurveillant()
    {
        return no_surveillant;
    }
            
            
    
}
