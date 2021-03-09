public class Individu {
	//caractéristiques de l'individu
	public String nom;
	public int pv, armurePhysique = 0, armureMagique = 0, agilite, force, constitution, sagesse, perception, charisme, chance, argent = 0;
	
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

	//retourne les pv max de l'invidu
	public void pvMax() {
		return constitution*2;
	}

}
