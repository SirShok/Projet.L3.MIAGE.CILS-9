import java.util.Random;
import java.util.*;

public class Individu {
	public static int tailleEquipement = 3;
	//caracteristiques de l'individu
	public String nom;
	public int pv, armure = 0, agilite, force, constitution, sagesse, perception, charisme, chance;
	private Equipement[] equipement = new Equipement[tailleEquipement]; int nbMainL = 2; 	//designe l'equipement et le nombre de main libres restantes
	private Competence[] competence = new Competence[4];
	private boolean equipArmure = false;	//indique si l'individu porte une armure

	//retourne les pv max de l'individu
	public int pvMax() {
		return constitution*2;
	}
	
	public Competence getCompetence(int i) {
		return competence[i];
	}
	
	//permet d'equiper un equipement selon plusieurs conditions:
	//- si c'est un arme, on va verifier qu'il peut la porter
	//- si c'est une armure, on va verifier qu'il n'en a pas deja
	public void equiper(Equipement e) {
		if(e.type.equals("arme")) {
			if(nbMainL <= e.nbMain) {
				nbMainL = nbMainL - e.nbMain;
			}
			for(int i = 0; i < tailleEquipement; i++) {
				if(equipement[i] == null) {
					equipement[i] = e;
					return;
				}
			}
			System.out.println("erreur: impossible d'equiper l'equipement");
			System.exit(-1);
		}else if(e.type.equals("armure")) {
			if(equipArmure) {
				System.out.println("erreur: impossible d'equiper l'equipement");
				System.exit(-1);
			} else {
				equipArmure = true;
				armure = e.armure;
				for(int i = 0; i < tailleEquipement; i++) {
					if(equipement[i] == null) {
						equipement[i] = e;
						return;
					}
				}
				System.out.println("erreur: impossible d'equiper l'equipement");
				System.exit(-1);
			}	
		} else {
			System.out.println("type d'equipement incorrect");
			System.exit(-1);
		}

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
	
	//attaque normale avec l'attribut agilite
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
				l.set(i, (l.get(i))*2);
			}
		}
		return l;
	}
	
	public Equipement[] armeEquip(){
		Equipement[] res = new Equipement[2];
		int i = 0;
		for(Equipement e: equipement){
			if((e != null)&&(e.type.equals("arme"))){
				res[i++] = e;
			}
		}
		return res;
	}
	
	public Individu(int n){
		competence = Competence.compDisp(n);
		switch (n){
			case 0:
				nom = "Rain";
				force = 30;
				agilite = 5;
				sagesse = 10;
				perception = 5;
				constitution = 30;
				charisme = 15;
				chance = 20;
				pv = pvMax();
				equiper(new Equipement("epee a 2 mains rouille;8;0;0;0;2;1;arme;"));
				equiper(new Equipement("Armure rouille;0;0;10;0;0;1;armure;"));
				break;
			case 1:
				nom = "Robin des bois";
				force = 5;
				agilite = 30;
				sagesse = 15;
				perception = 15;
				constitution = 15;
				charisme = 10;
				chance = 20;
				pv = pvMax();
				equiper(new Equipement("Arc use",5,0,0,2,2,1,"arme"));
				equiper(new Equipement("Armure rouille;0;0;10;0;0;1;armure;"));
				break;
			case 2:
				nom = "kaplan";
				force = 30;
				agilite = 5;
				sagesse = 30;
				perception = 10;
				constitution = 20;
				charisme = 10;
				chance = 20;
				pv = pvMax();
				equiper(new Equipement("epee rouille;4;0;0;0;1;1;arme;"));
				equiper(new Equipement("Baguette use;0;2;0;0;1;1;arme;"));
				equiper(new Equipement("Armure rouille;0;0;10;0;0;1;armure;"));
				break;
			case 3:
				nom = "Gandalf";
				force = 5;
				agilite = 10;
				sagesse = 30;
				perception = 20;
				constitution = 15;
				charisme = 10;
				chance = 30;
				pv = pvMax();
				equiper(new Equipement("Baton use;0;4;0;0;2;1;arme;"));
				equiper(new Equipement("Armure rouille;0;0;10;0;0;1;armure;"));
				break;
		}
	}
}
