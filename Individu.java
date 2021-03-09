public class Individu {
	public static tailleEquipement = 2;
	//caractéristiques de l'individu
	public String nom;
	public int pv, mana, armurePhysique = 0, armureMagique = 0, agilite, force, constitution, sagesse, perception, charisme, chance;
	private Equipement[tailleEquipement] equipement, int nbMainL = 2; 	//désigne l'équipement et le nombre de main libres restantes
	
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
	
	public void equiper(Equipement e) {
		if(nbMainL <= e.nbMain) {
			nbMainL = nbMainL - e.nbMain;
		}
		for(int i = 0; i < tailleEquipement; i++) {
			if(equipement[i] == null) {
				equipement[i] = e;
				return
			}
		}
		System.out.println("erreur: impossible d'équiper l'équipement");
		System.exit(-1);
	}
	
	public void desequiper(Equipement e) {
		for(int i = 0; i < tailleEquipement; i++) {
			if(equipement[i].nom == e.nom) {
				equipement[i] = null;
				nbMainL = nbMainL + e.nbMain;
				return
			}
		}
		System.out.println("erreur: impossible de déséquiper l'équipement");
		System.exit(-1);
	}
	
	public void afficherEquipement() {
		for(int i = 0; i < tailleEquipement; i++) {
			System.out.println("Arme " + i + " : " + i.nom);
		}
	}
}
