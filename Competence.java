//Estoc;1;FOR;1;1;5;Coup précis attaquant avec la pointe de la lame ignore 5 point d'armure.; exemple compétence type

public class Competence {
    String nom = "";
    int rang;
    String stat = "";
    int nbCoup;
    int DM;
    int perca;
    String description = "";

    public Competence (String c){
        int i = 0;
        int j = 0;
        String degat = "";
        String per = "";
        while (j != 7){
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
            }
            i++;
        }
        DM = Integer.parseInt(degat);
        perca = Integer.parseInt(per);
    }

    public int Degat(){
        return DM;
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

    public int getDM(){
        return DM;
    }

    public int getPerca(){
        return perca;
    }

    public String getDescription(){
        return description;
    }
}
