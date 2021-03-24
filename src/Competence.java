import java.util.*;
import java.io.Serializable;

public class Competence implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -1675753638838475097L;
    String nom = "";
    int rang;
    String stat = "";
    int nbCoup;
    List<Integer> DM = new ArrayList<Integer>();
    int degat;
    int perca;
    String description = "";
    String effet;
    int id;
    int cout = 0;
    String type = "";


    // prend en entrée un string dans le fichier competence.txt et remplie une instance de classe Competence
    //attention! Cette classe ne calculeraa pas les dégâts, elle prendra justes ceux définies par la compétence
    public Competence (String name0, int rangc1, String statc2, int nbc3,int degatc4,int percac5, String descriptionc6,String effetc7,int idc8,String typec9){
        nom = name0;
        rang = rangc1;
        stat = statc2;
        nbCoup = nbc3;
        degat = degatc4;
        perca = percac5;
        description = descriptionc6;
        effet = effetc7;
        id = idc8;
        type = typec9;
    }
    
    // comme on ne peut pas stocker des fonctions dans un String, on attribue un chiffre à chacune 
    // des fonctions existantes puis via cette fonction on calcule les dégâts en fonction de ce chiffre
    public static ArrayList<Integer> Degat(Individu ind, Competence comp){                    
        ArrayList<Integer> degat = new ArrayList<Integer>(); 
        int d = comp.degat;
        String s = comp.stat;
        int c = comp.nbCoup;
        int rang = comp.rang;
        switch(d){
            case 1:
                if(s.equals("FOR")){
                    degat.add(ind.attaqueF(1));
                    degat.add(ind.attaqueF(2));
                }
                if(s.equals("AGI")){
                    degat.add(ind.attaqueA(1));
                    degat.add(ind.attaqueA(2));
                }
                if(s.equals("SAG")){
                    degat.add((int)(ind.sagesse*(rang/2)));
                    degat = ind.attaqueM(degat);
                }
                break;
            case 2:
                if(s.equals("FOR")){
                    degat.add((int)((ind.attaqueF(1))*(((rang-1)*0.2)+1)));
                    degat.add((int)((ind.attaqueF(2))*(((rang-1)*0.2)+1)));     
                } 
                if(s.equals("AGI")){
                    degat.add((int)((ind.attaqueA(1))*(((rang-1)*0.2)+1))); 
                    degat.add((int)((ind.attaqueA(2))*(((rang-1)*0.2)+1))); 
                }
                if(s.equals("SAG")){
                    for(int i = 0; i<rang; i++){
                        degat.add(ind.sagesse/2);
                    }
                    degat = ind.attaqueM(degat);
                }
                break;
            case 3:
                if(s.equals("FOR")){
                    while(c-- > 1){
                        degat.add(ind.attaqueF(1));
                        degat.add(ind.attaqueF(2));
                    }
                    if((rang == 2)||(rang == 5)||(rang == 8)){
                        degat.add((int)(ind.attaqueF(1)/2));
                        degat.add((int)(ind.attaqueF(2)/2));
                    }
                    if((rang == 3)||(rang == 6)||(rang == 9)){
                        degat.add((int)(ind.attaqueF(1)*0.8));
                        degat.add((int)(ind.attaqueF(2)*0.8));
                    }
                    if((rang == 4)||(rang == 7)){
                        degat.add(ind.attaqueF(1));
                        degat.add(ind.attaqueF(2));
                    }
                    break;
                }
                if(s.equals("AGI")){
                    while(c-- > 1){
                        degat.add(ind.attaqueA(1));
                        degat.add(ind.attaqueA(2));
                    }
                    if((rang == 2)||(rang == 5)||(rang == 8)){
                        degat.add((int)(ind.attaqueA(1)/2));
                        degat.add((int)(ind.attaqueA(2)/2));
                    }
                    if((rang == 3)||(rang == 6)||(rang == 9)){
                        degat.add((int)(ind.attaqueA(1)*0.8));
                        degat.add((int)(ind.attaqueA(2)*0.8));
                    }
                    if((rang == 4)||(rang == 7)){
                        degat.add(ind.attaqueA(1));
                        degat.add(ind.attaqueA(2));
                    }
                    break;
                }
        }
        comp.DM =  degat;
        return degat;
    }
}
