import java.util.Random;
import java.util.*;

public class Individu {
	public static int tailleEquipement = 3;
	//caractéristiques de l'individu
	public String nom;
	public int pv, mana, armure = 0, agilite, force, constitution, sagesse, perception, charisme, chance;
	private Equipement[] equipement = new Equipement[tailleEquipement]; int nbMainL = 2; 	//désigne l'équipement et le nombre de main libres restantes
	private Competence[] competence = new Competence[4];
	private boolean equipArmure = false;	//indique si l'individu porte une armure
	
	public Individu(String n, int ag, int f, int co, int s, int p, int ca, int ch) {
		nom = n;
		agilite = ag;
		force = f;
		constitution = co;
		sagesse = s;
		p = perception;
		charisme = ca;
		chance = ch;
		pv = pvMax();
		mana = manaMax();
	}

	//retourne les pv max de l'individu
	public int pvMax() {
		return constitution*2;
	}
	
	//retourne les points de mana max de l'individu
	public int manaMax() {
		return sagesse*2;
	}
	
	//permet d'équiper un équipement selon plusieurs conditions:
	//- si c'est un arme, on va vérifier qu'il peut la porter
	//- si c'est une armure, on va vérifier qu'il n'en a pas déjà
	public void equiper(Equipement e) {
		if(e.type == "arme") {
			if(nbMainL <= e.nbMain) {
				nbMainL = nbMainL - e.nbMain;
			}
			for(int i = 0; i < tailleEquipement; i++) {
				if(equipement[i] == null) {
					equipement[i] = e;
					return;
				}
			}
			System.out.println("erreur: impossible d'équiper l'équipement");
			System.exit(-1);
		}else if(e.type == "armure") {
			if(equipArmure == true) {
				System.out.println("erreur: impossible d'équiper l'équipement");
				System.exit(-1);
			} else {
				equipArmure = true;
				for(int i = 0; i < tailleEquipement; i++) {
					if(equipement[i] == null) {
						equipement[i] = e;
						return;
					}
				}
				System.out.println("erreur: impossible d'équiper l'équipement");
				System.exit(-1);
			}	
			
		} else {
			System.out.println("type d'équipement incorrect");
			System.exit(-1);
		}

	}
	
	//permet de déséquiper un équipement
	public void desequiper(Equipement e) {
		for(int i = 0; i < tailleEquipement; i++) {
			if((equipement[i] != null)&&(equipement[i].nom == e.nom)) {
				String tmp = equipement[i].type;
				equipement[i] = null;
				if(tmp == "arme") {
					nbMainL = nbMainL + e.nbMain;
					return;
				} else if(tmp == "armure") {
					equipArmure = false;
					return;
				} else {
					System.out.println("type d'Ã©quipement incorrect k");
					System.exit(-1);
				}
			}
		}
		System.out.println("erreur: impossible de déséquiper l'équipement");
		System.exit(-1);
	}
	
	//permet de voir son équipement ainsi que son type
	public String afficherEquipement() {
		String r = "";
		for(int i = 0; i < tailleEquipement; i++) {
			if(equipement[i] != null) {
				if(equipement[i].type == "arme") {
					r = r + "Arme : " + equipement[i].nom + "\n";
				} else if (equipement[i].type == "armure") {
					r = r + "Armure : " + equipement[i].nom + "\n";
				} else {
					System.out.println("type d'Ã©quipement incorrect i");
					System.exit(-1);
				}
			}				
		}
		if(r == "") {
			r = "Vous n'avez ni arme ni armure";
		}
		return r;
	}
	
	//attaque normale avec l'attribut force
	public int attaqueF(int n) {
		int degat = 0;
		for(int i = 0; i < tailleEquipement; i++) {
			if((equipement[i] != null)&&(equipement[i].degatPhysique != 0)) {
				if(n-- == 1) degat = degat + equipement[i].degatPhysique;
			}
		}
		if (degat == 0){
			return 0;
		}
		degat = degat + force/2;
		Random random = new Random(); 
		float f=random.nextFloat();
		
		if(f*100 < 5 + chance/5) {
			return degat*2;
		}
		return degat;
	}
	
	//attaque normale avec l'attribut agilité
	public int attaqueA(int n) {
		int degat = 0;
		for(int i = 0; i < tailleEquipement; i++) {
			if((equipement[i] != null)&&(equipement[i].degatPhysique != 0)) {
				if(n-- == 1) degat = degat + equipement[i].degatPhysique;
			}
		}
		if (degat == 0){
			return 0;
		}
		degat = degat + agilite/2;
		Random random = new Random(); 
		float f=random.nextFloat();
		
		if(f*100 < 5 + chance/5) {
			return degat*2;
		}
		return degat;
	}
	
	
	//attaque normale magique
	public ArrayList<Integer> attaqueM(ArrayList<Integer> l) {
		for(int i = 0; i < tailleEquipement; i++) {
			if(equipement[i] != null) {
				l.set(0, (l.get(0)+equipement[i].degatMagique));
			}
		}
		Random random = new Random(); 
		float f=random.nextFloat();
		
		for(int i = 0; i < l.size(); i++) {
			if(f*100 < 5 + chance/5) {
				l.set(i, (l.get(0))*2);
			}
		}
		return l;
	}
	
	public Equipement[] armeEquip(){
		Equipement[] res = new Equipement[2];
		int i = 0;
		for(Equipement e: equipement){
			if((e != null)&&(e.type == "arme")){
				res[i++] = e;
			}
		}
		return res;
	}
	
	public Individu(int n){
		System.out.println("hello");

		equipArmure = true;
		switch (n){
			case 0:
				nom = "Chevalier";
				force = 30;
				agilite = 5;
				sagesse = 10;
				perception = 5;
				constitution = 30;
				charisme = 15;
				chance = 20;
				pv = pvMax();
				mana = manaMax();
				equiper(new Equipement("epee a 2 mains rouille;8;0;0;0;2;1;arme;"));
				equiper(new Equipement("Armure rouille;0;0;10;0;0;1;armure;"));
				competence[0] = new Competence("Coup simple",1,"FOR",1,1,0,"coup infligeant des dégat normaux.","degat",2,"physique");
				competence[1] = new Competence("Estoc",1,"FOR",1,1,5,"Coup précis attaquant avec la pointe de la lame ignore 5 point d'armure.","degat",1,"physique");

				break;
			case 1:
				nom = "Archer";
				force = 5;
				agilite = 30;
				sagesse = 5;
				perception = 30;
				constitution = 10;
				charisme = 10;
				chance = 20;
				pv = pvMax();
				mana = manaMax();
				equiper(new Equipement("Arc use",5,0,0,2,2,1,"arme"));
				equiper(new Equipement("Armure rouille;0;0;10;0;0;1;armure;"));
				competence[0] = new Competence("tir simple",1,"AGI",1,1,0,"tir infligeant des dégÃ¢ts normaux","degat",6,"physique");
				competence[1] = new Competence("tir précis",1,"AGI",1,1,5,"tir ignorant 5 points d'armure","degat",5,"physique");

				break;
			case 2:
				nom = "Pretre";
				force = 30;
				agilite = 5;
				sagesse = 30;
				perception = 10;
				constitution = 20;
				charisme = 10;
				chance = 20;
				pv = pvMax();
				mana = manaMax();
				equiper(new Equipement("epee rouille;4;0;0;0;1;1;arme;"));
				equiper(new Equipement("Baguette use;0;2;0;0;1;1;arme;"));
				equiper(new Equipement("Armure rouille;0;0;10;0;0;1;armure;"));
				competence[0] = new Competence("Coup simple",1,"FOR",1,1,0,"coup infligeant des dégat normaux.","degat",3,"physique");
				competence[1] = new Competence("Boule de feu",1,"SAG",1,1,999,"envoi une boule de feux brulant l'ennemi, infligeant SAG/2 DM coute 5 PM.","degat",11,"feu");
				competence[2] = new Competence("Soint sacré",1,"SAG",1,1,0,"fais appels a la puissance de la lumière pour restauré votre corps, soigne SAG/2 PV, cout 5 PM.","soint",18,"lumiere");

				break;
			case 3:
				nom = "Magicien";
				force = 5;
				agilite = 10;
				sagesse = 30;
				perception = 20;
				constitution = 15;
				charisme = 10;
				chance = 30;
				pv = pvMax();
				mana = manaMax();
				equiper(new Equipement("Baton use;0;4;0;0;2;1;arme;"));
				equiper(new Equipement("Armure rouille;0;0;10;0;0;1;armure;"));
				competence[0] = new Competence("Boule de feu",1,"SAG",1,1,999,"envoi une boule de feux brulant l'ennemi, infligeant SAG/2 DM coute 5 PM.","degat",11,"feu");
				competence[1] = new Competence("Sacralisation",1,"SAG",1,1,999,"fais appels a la puissance de la lumière pour purifier l'ennemis, inflige SAG/2 DM, cout 5 PM.","degat",17,"lumiere");
				
				break;
		}
	}
}
