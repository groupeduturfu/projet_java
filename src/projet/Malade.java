/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

/**
 * Cette classe regroupe toutes les informations liés au patient.
 * 
 * @author maurinco
 */
public class Malade {
    private int no_malade; // identifie le malade
    private String nom_malade;
    private String prenom_malade;
    private String adresse_malade;
    private long tel_malade;
    private String mutuelle_malade;
    
    // CONSTRUCTEUR
    public Malade(int numMalade, String nom, String prenom, String adresse, long tel, String mutuelle)
    {
        no_malade = numMalade;
        nom_malade=nom;
        prenom_malade= prenom;
        adresse_malade = adresse;
        tel_malade = tel;
        mutuelle_malade = mutuelle;
    }
    
    private int getNoMalade()
    {
        return no_malade;
    }
    
    private String getNomMalade()
    {
        return nom_malade;
    }
    
    private String getPrenomMalade()
    {
        return prenom_malade;
    }
    
    private String getAdresseMalade()
    {
        return adresse_malade;
    }   
    
    private long getTelMalade()
    {
        return tel_malade;
    }
    
    private String getMutuelle()
    {
        return mutuelle_malade;
    }
    
}
