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
      public void Degat(Individu ind){
        ArrayList<Integer> degat = new ArrayList<Integer>();
        int d = this.degat;
        String s = this.stat;
        int c = this.cout;
        switch(d){
            case 1:
                if(s == "FOR"){
                    degat.add(ind.attaqueF());
                }
                if(s == "AGI"){
                    degat.add(ind.attaqueA());
                }
                if(s == "SAG"){
                    degat.add((int)(ind.sagesse*(this.rang/2)));
                    degat = ind.attaqueM(degat);
                }
                break;
            case 2:
                if(s == "FOR"){
                    degat.add((int)((ind.attaqueF())*(((this.rang-1)*0.2)+1)));   
                } 
                if(s == "AGI"){
                    degat.add((int)((ind.attaqueA())*(((this.rang-1)*0.2)+1))); 
                }
                if(s == "SAG"){
                    for(int i = 0; i<=this.rang; i++){
                        degat.add(ind.sagesse/2);
                    }
                    degat = ind.attaqueM(degat);
                }
                break;
            case 3:
                if(s == "FOR"){
                    while(c-- > 1){
                        degat.add(ind.attaqueF());
                    }
                    if((this.rang == 2)||(this.rang == 5)||(this.rang == 8)){
                        degat.add((int)(ind.attaqueF()/2));
                    }
                    if((this.rang == 3)||(this.rang == 6)||(this.rang == 9)){
                        degat.add((int)(ind.attaqueF()*0.8));
                    }
                    if((this.rang == 4)||(this.rang == 7)){
                        degat.add(ind.attaqueF());
                    }
                    break;
                }
                if(s == "AGI"){
                    while(c-- > 1){
                        degat.add(ind.attaqueA());
                    }
                    if((this.rang == 2)||(this.rang == 5)||(this.rang == 8)){
                        degat.add((int)(ind.attaqueA()/2));
                    }
                    if((this.rang == 3)||(this.rang == 6)||(this.rang == 9)){
                        degat.add((int)(ind.attaqueA()*0.8));
                    }
                    if((this.rang == 4)||(this.rang == 7)){
                        degat.add(ind.attaqueA());
                    }
                    break;
                }
        }
        this.DM =  degat;
    }
}
