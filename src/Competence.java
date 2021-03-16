import java.util.*;

public class Competence {
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
    public Competence (String c){
        String[] tab = c.split(";");
        nom = tab[0];
        rang = Integer.parseInt(tab[1]);
        stat = tab[2];
        nbCoup = Integer.parseInt(tab[3]);
        degat = Integer.parseInt(tab[4]);
        perca = Integer.parseInt(tab[5]);
        description = tab[6];
        effet = tab[7];
        id = Integer.parseInt(tab[8]);
        type = tab[9];
    }
    
    // comme on ne peut pas stocker des fonctions dans un String, on attribue un chiffre à chacune 
    // des fonctions existantes puis via cette fonction on calcule les dégâts en fonction de ce chiffre
 public static ArrayList<Integer> Degat(Individu ind, Competence comp){                    
        ArrayList<Integer> degat = new ArrayList<Integer>(); 
        int d = comp.degat;
        String s = comp.stat;
        int c = comp.cout;
        int rang = comp.rang;
        switch(d){
            case 1:
                if(s == "FOR"){
                    degat.add(ind.attaqueF(1));
                    degat.add(ind.attaqueF(2));
                }
                if(s == "AGI"){
                    degat.add(ind.attaqueA(1));
                    degat.add(ind.attaqueA(2));
                }
                if(s == "SAG"){
                    degat.add((int)(ind.sagesse*(rang/2)));
                    degat = ind.attaqueM(degat);
                }
                break;
            case 2:
                if(s == "FOR"){
                    degat.add((int)((ind.attaqueF(1))*(((rang-1)*0.2)+1)));
                    degat.add((int)((ind.attaqueF(2))*(((rang-1)*0.2)+1)));     
                } 
                if(s == "AGI"){
                    degat.add((int)((ind.attaqueA(1))*(((rang-1)*0.2)+1))); 
                    degat.add((int)((ind.attaqueA(2))*(((rang-1)*0.2)+1))); 
                }
                if(s == "SAG"){
                    for(int i = 0; i<=rang; i++){
                        degat.add(ind.sagesse/2);
                    }
                    degat = ind.attaqueM(degat);
                }
                break;
            case 3:
                if(s == "FOR"){
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
                if(s == "AGI"){
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
