/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projet;

/**
 * Cette classe nous permet de 
 * voir toutes les hospitalisations passés d'un patient,
 * et d'ainsi assurer les meilleurs soins connaissant ses antécédants médicaux.
 * 
 * @author maurinco
 */
public class Historique { 
   private int no_malade;
   private int date_arrivee; 
   private int date_sortie;
   private String description;
   private int code_service;
   private int no_docteur;

    // CONSTRUCTEUR
   public Historique (int numMalade, int dateA, int dateS, String descri, int codeServ, int numDocteur )
   {
       no_malade = numMalade;
       date_arrivee = dateA;
       date_sortie = dateS;
       description = descri;
       code_service = codeServ;
       no_docteur = numDocteur;
   }
   
   public int getNoMalade()
   {
       return no_malade;
   }
   
   public int getDateArrivee()
   {
       return date_arrivee;
   }
   
   public int getDateSortie()
   {
      return date_sortie; 
   }
   
   public String getDescription()
   {
       return description;
   }
   
   public int getCodeService()
   {
       return code_service;
   }
   
   public int getNoDocteur()
   {
       return no_docteur;
   }
          
}
