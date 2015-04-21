/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

/**
 * Cette classe définit un service selon son nom, son batiment et son directeur.
 * @author maurinco
 */
public class Service {
    private int code_service; // identifie le service
    
    private String nom;
    private String batiment;
    private String no_directeur; // identifie le docteur qui dirige ce service
    
    public Service(int codeS, String name, String bati, String directeur)
    {
        code_service = codeS;
        nom = name;
        batiment = bati;
        no_directeur = directeur;
    }
   
    public int getCode_service() 
    {
        return code_service;
    }

    public String getNom() 
    {
        return nom;
    }

    public String getBatiment() 
    {
        return batiment;
    }

    public String getNo_directeur() 
    {
        return no_directeur;
    }
   
    
}
