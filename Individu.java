import java.util.Random;

public class Individu {
	public static int tailleEquipement = 2;
	//caractéristiques de l'individu
	public String nom;
	public int pv, mana, armurePhysique = 0, armureMagique = 0, agilite, force, constitution, sagesse, perception, charisme, chance;
	private Equipement[] equipement = new Equipement[tailleEquipement]; int nbMainL = 2; 	//désigne l'équipement et le nombre de main libres restantes
	
	public Individu(String n, int ag, int f, int co, int s, int p, int ca, int ch) {
		nom = n;
		agilite = ag;
		force = f;
		constitution = co;
		sagesse = s;
		p = perception;
		charisme = ca;
		chance = ch;
	}

	//retourne les pv max de l'individu
	public int pvMax() {
		return constitution*2;
	}
	
	//retourne les points de mana max de l'individu
	public int manaMax() {
		return sagesse*2;
	}
	
	//permet d'équiper un équipement
	public void equiper(Equipement e) {
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
	}
	
	//permet de déséquiper un équipement
	public void desequiper(Equipement e) {
		for(int i = 0; i < tailleEquipement; i++) {
			if((equipement[i] != null)&&(equipement[i].nom == e.nom)) {
				equipement[i] = null;
				nbMainL = nbMainL + e.nbMain;
				return;
			}
		}
		System.out.println("erreur: impossible de déséquiper l'équipement");
		System.exit(-1);
	}
	
	//permet de voir son équipement
	public void afficherEquipement() {
		int j = 1;
		for(int i = 0; i < tailleEquipement; i++) {
			if(equipement[i] != null) {
				System.out.println("Arme " + j + " : " + equipement[i].nom);
				j++;
			}				
		}
		if(j == 1) {
			System.out.println("Vous n'avez pas d'armes");
		}
	}
	
	//attaque normale avec l'attribut force
	public int attaqueF() {
		int degat = 0;
		for(int i = 0; i < tailleEquipement; i++) {
			if(equipement[i] != null) {
				degat = degat + equipement[i].degatPhysique;
			}
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
	public int attaqueA() {
		int degat = 0;
		for(int i = 0; i < tailleEquipement; i++) {
			if(equipement[i] != null) {
				degat = degat + equipement[i].degatPhysique;
			}
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
	public ArrayList attaqueM(ArrayList l) {
		for(int i = 0; i < tailleEquipement; i++) {
			if(equipement[i] != null) {
				l.set(0, l.get(0) + equipement[i].degatMagique);
			}
		}
		Random random = new Random(); 
		float f=random.nextFloat();
		
		for(int i = 0; i < l.size(); i++) {
			if(f*100 < 5 + chance/5) {
				l.set(i, l.get(0) * 2);
			}
		}
		return l;
	}
}