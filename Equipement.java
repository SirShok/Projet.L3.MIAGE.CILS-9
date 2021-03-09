public class Equipement {
	//caractéristiques de l'arme
	public String nom;
	//0 = pas de bonus; plus de 0: octroie du dégât/soin supplémentaire pour certaines capacités
	public int degatPhysique, degatMagique, bonusSoin;
	//indique le nombre d'armure ignorer par l'arme
	public int perceArmure;
	public int nbMain;
	public int rang;


	public Equipement(String n, int dP, int dM, int bS, int pA, int m, int r) {
		nom = n;
		degatPhysique = dP;
		degatMagique = dM;
		bonusSoin = bS;
		perceArmure = pA;
		nbMain = m;
		rang = r;
	}
}
