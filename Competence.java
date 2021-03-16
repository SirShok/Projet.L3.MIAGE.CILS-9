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

    public Competence (String c){ // prend en entré un string du mème type que se dans le fichier competence et remplie un type compètence avec ! ne calcula pas les dégat
        String[] tab = c.split(";");
        nom = tab[0];
        rang = Integer.parseInt(tab[1]);
        stat = tab[2];
        nbCoup = Integer.parseInt(tab[3]);
        DM = Integer.parseInt(tab[4]);
        perca = Integer.parseInt(tab[5]);
        description = tab[6];
        effet = tab[7];
        id = Integer.parseInt(tab[8]);
        type = tab[9]
        
        /*int i = 0;
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
        DM = Integer.parseInt(degat);
        perca = Integer.parseInt(per);*/
    }

    public void Degat(Individu ind){                    // comme on ne peux pas stocker de fonction dans un String, on attribus un chiffre a chacune 
        List<Integer> degat = new ArrayList<Integer>(); // des fonctions exixtante puis via cette fonction on calcul les degat en fonction de se chiffre
        d = this.DM;
        s = this.stat;
        c = this.cout;
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
