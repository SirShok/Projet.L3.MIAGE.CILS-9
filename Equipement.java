public class Equipement {
	//caractéristiques de l'arme
	public String nom;
	//0 = pas de bonus; plus de 0: octroie du degat/soin supplémentaire pour certaines capacites
	public int degatPhysique,degatMagique,armure;
	//indique le nombre d'armure ignorer par l'arme
	public int perceArmure;
	public int nbMain;
	public int rang;
	public String type;


	public Equipement(String equ) {
		String[] tab = equ.split(";");
      		nom = tab[0];
		degatPhysique = Integer.parseInt(tab[1]);
		degatMagique = Integer.parseInt(tab[2]);
		armure = Integer.parsInt(tab[3]);
		perceArmure = Integer.parseInt(tab[4]);
		nbMain = Integer.parseInt(tab[5]);
		rang = Integer.parseInt(tab[6]);
		type = tab[7];
	}
}
