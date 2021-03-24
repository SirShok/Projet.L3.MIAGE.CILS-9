import java.util.*;
import java.io.Serializable;
import java.util.Random;
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
        int c = comp.cout;
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
                    for(int i = 0; i<=rang; i++){
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
    public static Competence[] compDisp(int n){
        ArrayList<Competence> CompetencePhysique = new ArrayList<Competence>();
        ArrayList<Competence> CompetenceDistance = new ArrayList<Competence>();
        ArrayList<Competence> CompetenceCorpACorp = new ArrayList<Competence>();
        ArrayList<Competence> CompetenceMagique = new ArrayList<Competence>();
        ArrayList<Competence> CompetenceDegat = new ArrayList<Competence>();
        ArrayList<Competence> CompetenceSoin = new ArrayList<Competence>();
        ArrayList<Competence> CompetenceBouclier = new ArrayList<Competence>();
        ArrayList<Competence> competenceC = new ArrayList<Competence>();
        ArrayList<Competence> competenceD = new ArrayList<Competence>();
        ArrayList<Competence> competenceMD = new ArrayList<Competence>();
        ArrayList<Competence> competenceS = new ArrayList<Competence>();
        ArrayList<Competence> competenceB = new ArrayList<Competence>();
        Competence[] res = new Competence[4];
        for(Competence e: Main.listeCompetence){
            if(e.type.equals("physique")){
                CompetencePhysique.add(e);
            }else{
                CompetenceMagique.add(e);
            }
        }
        for(Competence e: CompetencePhysique){
            if((e.id == 0)||(e.id == 1)||(e.id == 2)||(e.id == 3)){
                CompetenceCorpACorp.add(e);
            }else{
                CompetenceDistance.add(e);
            }
        }
        for(Competence e: CompetenceMagique){
            if(e.effet.equals("degat")) CompetenceDegat.add(e);
            if(e.effet.equals("soin")) CompetenceSoin.add(e);
            if(e.effet.equals("bouclier")) CompetenceBouclier.add(e);
        }
        switch(n){
            case 0: //chevalier
                for(Competence e: CompetenceCorpACorp){
                    if(e.rang == 2) competenceC.add(e);
                }
                res[0] = competenceC.get(new Random().nextInt(competenceC.size()));
                do{
                    res[1] = competenceC.get(new Random().nextInt(competenceC.size()));
                }while(res[0] == res[1]);
               
                for(Competence e: CompetenceSoin){
                    if(e.rang == 1) competenceS.add(e);
                }
                res[2] = competenceS.get(new Random().nextInt(competenceS.size()));

                for(Competence e: CompetenceDegat){
                    if(e.rang == 1) competenceMD.add(e);
                }
                res[3] = competenceMD.get(new Random().nextInt(competenceMD.size()));
                break;
            case 1: //archer
                for(Competence e: CompetenceDistance){
                    if(e.rang == 2) competenceD.add(e);
                }
                res[0] = competenceD.get(new Random().nextInt(competenceD.size()));
                do{
                    res[1] = competenceD.get(new Random().nextInt(competenceD.size()));
                }while(res[0] == res[1]);
               
                for(Competence e: CompetenceSoin){
                    if(e.rang == 1) competenceS.add(e);
                }
                res[2] = competenceS.get(new Random().nextInt(competenceS.size()));

                for(Competence e: CompetenceDegat){
                    if(e.rang == 1) competenceMD.add(e);
                }
                res[3] = competenceMD.get(new Random().nextInt(competenceMD.size()));
                break;
            case 2: //pretre
                for(Competence e: CompetenceCorpACorp){
                    if(e.rang == 1) competenceC.add(e);
                }
                res[0] = competenceC.get(new Random().nextInt(competenceC.size()));

                for(Competence e: CompetenceBouclier){
                    if(e.rang == 1) competenceB.add(e);
                }
                res[1] = competenceS.get(new Random().nextInt(competenceS.size()));

                for(Competence e: CompetenceDegat){
                    if(e.rang == 2) competenceMD.add(e);
                }
                res[2] = competenceMD.get(new Random().nextInt(competenceMD.size()));
                do{
                    res[3] = competenceMD.get(new Random().nextInt(competenceMD.size()));
                }while(res[2] == res[3]);                
                break;
            case 3: //mage
                for(Competence e: CompetenceMagique){
                    if(e.rang == 2) competenceMD.add(e);
                }
                res[0] = competenceMD.get(new Random().nextInt(competenceMD.size()));
                do{
                    res[1] = competenceC.get(new Random().nextInt(competenceC.size()));
                }while(res[0] == res[1]);
                do{
                    res[2] = competenceC.get(new Random().nextInt(competenceC.size()));
                }while((res[0] == res[2])||(res[1] == res[2]));
                for(Competence e: CompetenceBouclier){
                    if(e.rang == 1) competenceB.add(e);
                }
                res[3] = competenceS.get(new Random().nextInt(competenceS.size()));
                break;
        }
        return res;
    }
}
