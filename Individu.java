public class Individu {
	public String nom;
	public int pv, armure = 0, agilite, force, constitution, sagesse, perception, charisme, chance, argent = 0;
	
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

	public void pvMax() {} //en fonction de la constitution

}
