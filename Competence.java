import java.util.*;

public class Competence {
    String nom = "";
    int rang;
    String stat = "";
    int nbCoup;
    List<Integer> DM = new ArrayList<Integer>();
    int perca;
    String description = "";
    int effet;
    int id;
    int cout = 0;
    String type = "";

    public Competence (String c, Individu ind){
        int i = 0;
        int j = 0;
        String degat = "";
        String per = "";
        while (j != 10){
            if (c.charAt(i) == ';'){
                j++;
            }else{
                if(j == 0){
                    nom = nom+c.charAt(i);
                }
                if(j == 1){
                    rang = Integer.parseInt(Character.toString(c.charAt(i)));
                }
                if(j == 2){
                    stat = stat+c.charAt(i);
                }
                if(j == 3){
                    nbCoup = Integer.parseInt(Character.toString(c.charAt(i)));
                }
                if(j == 4){
                    degat = degat+c.charAt(i);
                }
                if(j == 5){
                    per = per+c.charAt(i);
                }
                if(j == 6){
                    description = description+c.charAt(i);
                }
                if(j == 7){
                    effet = effet+c.charAt(i);
                }
                if(j == 8){
                    id = id+c.charAt(i);
                }
                if(j == 9){
                    type = type+c.charAt(i);
                }
            }
            i++;
        }
        if(stat == "SAG"){
            cout = rang*5;
        }
        DM = Degat(degat, stat, rang, ind, nbCoup);
        perca = Integer.parseInt(per);
    }

    public List<Integer> Degat(int d, String s, int r, Individu ind, int c){
        List<Integer> degat = new ArrayList<Integer>();
        switch(d){
            case 1:
                if(s == "FOR"){
                    degat.add(ind.attaqueF());
                }
                if(s == "AGI"){
                    degat.add(ind.attaqueA());
                }
                if(s == "SAG"){
                    degat.add((int)(ind.sagesse*(rang/2)));
                    degat = ind.attaqueM(degat);
                }
                break;
            case 2:
                if(s == "FOR"){
                    degat.add((int)((ind.attaqueF())*(((rang-1)*0.2)+1)));   
                } 
                if(s == "AGI"){
                    degat.add((int)((ind.attaqueA())*(((rang-1)*0.2)+1))); 
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
                        degat.add(ind.attaqueF());
                    }
                    if((rang == 2)||(rang == 5)||(rang == 8)){
                        degat.add((int)(ind.attaqueF()/2));
                    }
                    if((rang == 3)||(rang == 6)||(rang == 9)){
                        degat.add((int)(ind.attaqueF()*0.8));
                    }
                    if((rang == 4)||(rang == 7)){
                        degat.add(ind.attaqueF());
                    }
                    break;
                }
                if(s == "AGI"){
                    while(c-- > 1){
                        degat.add(ind.attaqueA());
                    }
                    if((rang == 2)||(rang == 5)||(rang == 8)){
                        degat.add((int)(ind.attaqueA()/2));
                    }
                    if((rang == 3)||(rang == 6)||(rang == 9)){
                        degat.add((int)(ind.attaqueA()*0.8));
                    }
                    if((rang == 4)||(rang == 7)){
                        degat.add(ind.attaqueA());
                    }
                    break;
                }
        }
        return degat;
    }

    public String getNom(){
        return nom;
    }

    public int getRang(){
        return rang;
    }

    public String getStat(){
        return stat;
    }

    public int getNbCoup(){
        return nbCoup;
    }

    public ArrayList getDM(){
        return DM;
    }

    public int getPerca(){
        return perca;
    }

    public String getDescription(){
        return description;
    }
}
